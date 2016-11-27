package ru.proshik.spring_cloud_demo.auth_service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.proshik.spring_cloud_demo.auth_service.repository.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
