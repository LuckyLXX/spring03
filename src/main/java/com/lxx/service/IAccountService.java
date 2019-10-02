package com.lxx.service;

import com.lxx.domain.Account;

import java.util.List;

/**
 * ClassName:IAccountService
 * Package:com.lxx.service
 * Description:
 *
 * @Date:2019/9/30 15:11
 * @Author:857251389@qq.com
 */
public interface IAccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 通过id查询
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountid
     */
    void deleteAccount(Integer accountid);
}
