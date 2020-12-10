package com.controllers;

import com.entities.Account;
import com.repositories.AccountDao;
import com.usils.WsAddressConstants;
import com.usils.email.CommonsEmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WsAddressConstants.accountLogicUrl)
public class AccountController {

    @Autowired
    private AccountDao accountDao;

    @PostMapping(value = "createAccount")
    public Account createAccount(@RequestBody Account account) {
        if (!validateEmail(account.getEmail()))
            throw new IllegalArgumentException(String.format("email %s not valid", account.getEmail()));
        return accountDao.save(account);
    }

    private boolean validateEmail(String email) {
        CommonsEmailValidator commonsEmailValidator = new CommonsEmailValidator();
        return commonsEmailValidator.isValid(email, null);
    }

}
