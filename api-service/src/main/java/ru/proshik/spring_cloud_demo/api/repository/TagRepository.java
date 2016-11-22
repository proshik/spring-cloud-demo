package ru.proshik.spring_cloud_demo.api.repository;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.proshik.spring_cloud_demo.api.model.Tag;

import javax.persistence.ColumnResult;
import javax.persistence.SqlResultSetMapping;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by proshik on 21.11.16.
 */
@Repository
public interface TagRepository extends org.springframework.data.repository.Repository<Tag, Long> {

    @Query(value = "INSERT INTO tag (created_date, title) VALUES (?1, ?2) ON CONFLICT (title) DO NOTHING",
            nativeQuery = true)
    void saveOrUpdate(LocalDateTime createdDate, String title);

    Set<Tag> findByIdIn(Set<Long> ids);

    Tag findById(Long tagId);

    Tag findByTitle(String title);
}
