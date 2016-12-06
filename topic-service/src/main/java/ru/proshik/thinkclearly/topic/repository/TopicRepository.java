package ru.proshik.thinkclearly.topic.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.proshik.thinkclearly.topic.model.Topic;

/**
 * Created by proshik on 21.11.16.
 */
@Repository
public interface TopicRepository extends PagingAndSortingRepository<Topic, Long> {

    @Query(value = "UPDATE Topic SET rating = rating + 1 where id = :topicId")
    Topic incrementRating(@Param("topicId") Long topicId);
}
