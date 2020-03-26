package com.lh.transaction.dao.impl;

import com.lh.transaction.dao.IBankDao;
import com.lh.transaction.uitls.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 * @author liuhe
 * @date 2020/03/25
 */
public class BankDaoImpl implements IBankDao {

    @Override
    public void outMoney() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update("update t_bank set money=money-100 where name='lisi'");
    }

    @Override
    public void inMoney() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        queryRunner.update("update t_bank set money=money+100 where name='zhangsan'");
    }

    @Override
    public Double totalMoney() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select sum(`money`) from t_bank  where `name` in('zhangsan','lisi')";
        return queryRunner.query(sql, new ScalarHandler<Double>());
    }
}
