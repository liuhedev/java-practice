package com.lh.transaction.service.impl;

import com.lh.transaction.dao.IBankDao;
import com.lh.transaction.dao.impl.BankDaoImpl;
import com.lh.transaction.service.IBankService;
import com.lh.transaction.uitls.JDBCUtils;
import com.mysql.jdbc.Connection;

import java.sql.SQLException;

/**
 * 使用事务保证转账过程正确
 *
 * @author liuhe
 * @date 2020/03/25
 */
public class BankServiceImpl2 implements IBankService {

    @Override
    public void transferMoney() throws SQLException {
        IBankDao accountDao = new BankDaoImpl();
        Connection conn = null;
        try {
            //1、开始事务，开启事务，其实就是关闭自动提交
            conn = JDBCUtils.getConn();
            conn.setAutoCommit(false);

            accountDao.outMoney();
            //手动制造异常情况，因为未使用事务，导致只转出钱，未转入钱。
            int a = 1 / 0;
            accountDao.inMoney();
            // 2、提交事务
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (null != conn) {
                // 3、事务回滚
                conn.rollback();
            }
            throw new SQLException();
        }
    }

    @Override
    public Double getTotalMoney() throws SQLException {
        IBankDao accountDao = new BankDaoImpl();
        return accountDao.totalMoney();
    }
}
