package com.lh.transaction.dao;

import java.sql.SQLException;

/**
 * @author liuhe
 * @date 2020/03/25
 */
public interface IBankDao {
    void outMoney() throws SQLException;
    void inMoney() throws SQLException;
    Double totalMoney() throws SQLException;
}
