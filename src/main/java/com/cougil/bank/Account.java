package com.cougil.bank;

public class Account {
    private final TransactionRepository transactionRepository;

    public Account(final TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amount) {
        transactionRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        transactionRepository.addWithdraw(amount);
    }

    public void printStatement() {

    }

}
