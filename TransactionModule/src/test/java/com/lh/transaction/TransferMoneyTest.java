package com.lh.transaction;

import com.lh.transaction.dao.IBankDao;
import com.lh.transaction.dao.impl.BankDaoImpl;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author liuhe
 * @date 2020/03/25
 */
public class TransferMoneyTest {

    @Test
    public void testTotalMoney() throws SQLException {
        IBankDao bankDao = new BankDaoImpl();
        Double s = bankDao.totalMoney();
        System.out.println(s);
    }
}
