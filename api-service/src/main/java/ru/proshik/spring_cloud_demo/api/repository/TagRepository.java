package ru.proshik.spring_cloud_demo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.proshik.spring_cloud_demo.api.model.Tag;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by proshik on 21.11.16.
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query(value = "INSERT INTO tag (created_date, title) VALUES (?1, ?2) ON CONFLICT (title) DO NOTHING",
            nativeQuery = true)
    void saveOrUpdate(LocalDateTime createdDate, String title);

    Set<Tag> findByIdIn(Set<Long> ids);

    Tag findById(Long tagId);

    Tag findByTitle(String title);
}
