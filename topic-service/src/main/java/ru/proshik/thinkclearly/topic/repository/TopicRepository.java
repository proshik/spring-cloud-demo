package ru.proshik.thinkclearly.topic.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.proshik.thinkclearly.topic.model.Topic;

import java.util.List;

/**
 * Created by proshik on 21.11.16.
 */
@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE Topic SET rating = rating + 1 where id = :topicId")
    void incrementRating(@Param("topicId") Long topicId);

    @Query(value = "select t from Topic t join fetch t.tags tg where t.id = :topicId")
    Topic findTopicWithTags(@Param("topicId") Long topicId);

    @Query(value = "select t from Topic t join fetch t.tags tg")
    List<Topic> findTopicsWithTags(Pageable pageable);
}
