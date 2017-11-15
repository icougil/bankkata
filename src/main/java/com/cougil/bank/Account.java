package com.cougil.bank;

public class Account {
    private final TransactionRepository transactionRepository;
    private final StatementPrinter statementPrinter;

    public Account(final TransactionRepository transactionRepository, final StatementPrinter statementPrinter) {
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount) {
        transactionRepository.addDeposit(amount);
    }

    public void withdraw(int amount) {
        transactionRepository.addWithdraw(amount);
    }

    public void printStatement() {
        statementPrinter.print(transactionRepository.findTransactions());
    }

}
