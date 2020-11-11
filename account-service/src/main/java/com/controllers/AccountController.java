package com.controllers;

import com.entities.Account;
import com.repositories.AccountDao;
import com.usils.WsAddressConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(WsAddressConstants.accountLogicUrl)
public class AccountController {

    @Autowired
    private AccountDao accountDao;

    @PostMapping(value = "createAccount")
    public Account createAccount(@RequestBody Account account) {
        return accountDao.save(account);
    }

}
