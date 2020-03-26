package com.lh.transaction.service;

import java.sql.SQLException;

/**
 * @author liuhe
 * @date 2020/03/25
 */
public interface IBankService {

    void transferMoney() throws SQLException;

    Double getTotalMoney() throws SQLException;
}
