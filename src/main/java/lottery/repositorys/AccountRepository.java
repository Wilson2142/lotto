package lottery.repositorys;

import lottery.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public class AccountRepository implements JpaRepository<Account,Long> {
    public Optional<Account> findByIpAddress(String ipAddress);
}
