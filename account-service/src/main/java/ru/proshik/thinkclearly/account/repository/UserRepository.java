package ru.proshik.thinkclearly.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.proshik.thinkclearly.account.model.User;

/**
 * Created by proshik on 26.02.17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
