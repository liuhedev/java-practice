package com.lh.transaction.service.impl;

import com.lh.transaction.dao.IBankDao;
import com.lh.transaction.dao.impl.BankDaoImpl;
import com.lh.transaction.service.IBankService;

import java.sql.SQLException;

/**
 * 没有涉及事务的类
 *
 * @author liuhe
 * @date 2020/03/25
 */
public class BankServiceImpl implements IBankService {

    @Override
    public void transferMoney() throws SQLException {
        IBankDao accountDao = new BankDaoImpl();
        accountDao.outMoney();
        int a = 1 / 0;
//        手动制造异常情况，因为未使用事务，导致只转出钱，未转入钱。
        accountDao.inMoney();
    }

    @Override
    public Double getTotalMoney() throws SQLException {
        IBankDao accountDao = new BankDaoImpl();
        return accountDao.totalMoney();
    }
}
