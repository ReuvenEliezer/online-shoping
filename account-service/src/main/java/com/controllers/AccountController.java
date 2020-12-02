package com.controllers;

import com.config.CommonsEmailValidator;
import com.entities.Account;
import com.repositories.AccountDao;
import com.usils.WsAddressConstants;
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
        if (!validateEmail(account.getEmail())) {
            //TODO add exception handling
            throw new IllegalArgumentException(String.format("email %s not valid", account.getEmail()));
        }
        return accountDao.save(account);
//      return  ResponseEntity.status(HttpStatus.BAD_REQUEST);//.body("Request Have Invalid Parameters");
    }

    private boolean validateEmail(String email) {
        CommonsEmailValidator commonsEmailValidator = new CommonsEmailValidator();
        return commonsEmailValidator.isValid(email, null);
    }

}
