package com.lxx.service.impl;

import com.lxx.dao.IAccountDao;
import com.lxx.dao.impl.AccountDaoImpl;
import com.lxx.domain.Account;
import com.lxx.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:AccountServiceImpl
 * Package:com.lxx.service.impl
 * Description:
 *
 * @Date:2019/9/30 15:26
 * @Author:857251389@qq.com
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;


    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountid) {
        accountDao.deleteAccount(accountid);
    }
}
