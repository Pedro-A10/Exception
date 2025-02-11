package model.entities;

import model.exception.BusinessException;

public class Account {

    private Integer numberAccount;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account( Integer numberAccount, String holder, Double balance, Double withdrawLimit ) {
        this.numberAccount = numberAccount;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount( Integer numberAccount ) {
        this.numberAccount = numberAccount;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder( String holder ) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double setBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public Double setWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount) {
        validateWithdraw(amount);
        balance -= amount;
    }

    private void validateWithdraw (double amount) {
        if (amount > getWithdrawLimit()) {
           throw new BusinessException("Erro de saque: Valor do saque maior que o limite!");
        }
        if (amount > getBalance()) {
            throw new BusinessException("Erro de saque : Saldo insuficiente");
        }
    }

}
