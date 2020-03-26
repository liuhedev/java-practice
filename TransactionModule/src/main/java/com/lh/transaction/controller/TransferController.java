package com.lh.transaction.controller;

import com.lh.transaction.service.IBankService;
import com.lh.transaction.service.impl.BankServiceImpl;
import com.lh.transaction.service.impl.BankServiceImpl2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * @author liuhe
 * @date 2020/03/25
 */
@RestController
public class TransferController {

    @RequestMapping("transferException")
    public String transferMoneyException() {
        IBankService transactionService = new BankServiceImpl();
        try {
            transactionService.transferMoney();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
    }

    @RequestMapping("transferNormal")
    public String transferMoneyNormal() {
        IBankService transactionService = new BankServiceImpl2();
        try {
            transactionService.transferMoney();
            return "成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "失败";
        }
    }

    @RequestMapping("totalMoney")
    public Double getTotalMoney() {
        IBankService transactionService = new BankServiceImpl();
        try {
            return transactionService.getTotalMoney();
        } catch (SQLException e) {
            e.printStackTrace();
            return Double.valueOf(0);
        }

    }
}
