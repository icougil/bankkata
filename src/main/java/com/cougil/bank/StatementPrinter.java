package com.cougil.bank;

import java.util.List;

public class StatementPrinter {
    public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    private final Console console;

    public StatementPrinter(final Console console) {
        this.console = console;
    }

    public void print(final List<Transaction> transactions) {
        console.printLine(STATEMENT_HEADER);
    }
}
