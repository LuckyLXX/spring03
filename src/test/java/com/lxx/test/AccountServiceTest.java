package com.lxx.test;

import com.lxx.domain.Account;
import com.lxx.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * ClassName:AccountServiceImpl
 * Package:com.lxx.test
 * Description:
 *
 * @Date:2019/10/2 10:14
 * @Author:857251389@qq.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService as = null;
    @Test
    public void testFindAll() {
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
        List<Account> allAccount = as.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }

    }

    @Test
    public void testFindone() {

        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("lxsi");
        account.setMoney(1999F);

        //3.执行方法
        as.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        //1.获取容器

        //3.执行方法
        Account account = as.findAccountById(3);
        account.setMoney(2977f);
        as.updateAccount(account);

    }

    @Test
    public void testDelete() {
        //1.获取容器

        //3.执行方法
        as.deleteAccount(4);
    }

}
