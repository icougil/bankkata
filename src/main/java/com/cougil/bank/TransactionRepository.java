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
        Transaction depositTransaction = new Transaction(clock.today(), amount);
        transactions.add (depositTransaction);
    }

    public void addWithdraw(final int amount) {
        throw new UnsupportedOperationException();
    }

    public List<Transaction> findTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}
