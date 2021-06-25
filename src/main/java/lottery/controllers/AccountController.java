package lottery.controllers;

import lottery.services.AccountService;
import lottery.validators.AccountRegistrationValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/account")
public class AccountController {

    private static Logger logger = LoggerFactory.getLogger(AccountController.class);

    private AccountService accountService;
    private AccountRegistrationValidator accountRegistrationValidator;

    @Autowired
    public AccountController(AccountService accountService, AccountRegistrationValidator accountRegistrationValidator) {
        this.accountService = accountService;
        this.accountRegistrationValidator = accountRegistrationValidator;
    }

    @GetMapping
    public ResponseEntity<List<AccountDetails>> getAllAccounts() {
        List<AccountDetails> accountDetails = accountService.findAll().stream()
                .map(AccountDetails::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(accountDetails, HttpStatus.OK);
    }
}
