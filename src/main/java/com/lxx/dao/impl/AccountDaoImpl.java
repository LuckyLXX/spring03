package com.lxx.dao.impl;

import com.lxx.dao.IAccountDao;
import com.lxx.domain.Account;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * ClassName:AccountDaoImpl
 * Package:com.lxx.dao.impl
 * Description:
 *
 * @Date:2019/9/30 15:28
 * @Author:857251389@qq.com
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private QueryRunner queryRunner;


    @Override
    public List<Account> findAllAccount() {
        try {
            return queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer id) {
        try {
            return queryRunner.query("select * from account where id=?", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            queryRunner.update("insert into account (id,name,money) values(?,?,?)",
                    account.getId(), account.getName(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            queryRunner.update("update account set name=?,money=? where id=?",
                    account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountid) {
        try {
            queryRunner.update("delete from account where id=?", accountid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
