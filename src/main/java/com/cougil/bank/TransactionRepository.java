package com.cougil.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionRepository {
    private final Clock clock;
    private List<Transaction> transactions = new ArrayList<>();

    public TransactionRepository(final Clock clock) {
        this.clock = clock;
    }

    public void addDeposit(final int amount) {
        Transaction deposit = new Transaction(clock.today(), amount);
        transactions.add (deposit);
    }

    public void addWithdraw(final int amount) {
        Transaction withdraw = new Transaction(clock.today(), -amount);
        transactions.add (withdraw);
    }

    public List<Transaction> findTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
