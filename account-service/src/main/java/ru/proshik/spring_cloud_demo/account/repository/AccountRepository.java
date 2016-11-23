package ru.proshik.spring_cloud_demo.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.proshik.spring_cloud_demo.account.model.Account;

/**
 * Created by proshik on 23.11.16.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    Account findByUsername(String username);
}
