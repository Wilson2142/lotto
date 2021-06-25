package lottery.services;


import lottery.domain.Account;
import lottery.repositorys.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findByIpAddress(String ipAddress) {
        Optional<Account> optionalAccount = accountRepository.findByIpAddress(ipAddress);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            return account;
        } else {
            return null;
        }
    }

    public Account findById(Long target) {
        return accountRepository.findById(target).orElse(null);
    }


}
