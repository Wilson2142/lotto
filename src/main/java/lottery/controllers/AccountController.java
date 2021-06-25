package lottery.controllers;

import lottery.services.AccountService;
import lottery.validators.AccountRegistrationValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
