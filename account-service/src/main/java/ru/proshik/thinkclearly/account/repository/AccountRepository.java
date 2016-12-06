package ru.proshik.thinkclearly.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.proshik.thinkclearly.account.model.Account;

/**
 * Created by proshik on 23.11.16.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    Account findByUsername(String username);
}
