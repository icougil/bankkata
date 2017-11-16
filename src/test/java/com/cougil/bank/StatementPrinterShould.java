package com.cougil.bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {
    @Mock
    private Console console;
    private StatementPrinter statementPrinter;

    private static final List<Transaction> NO_TRANSACTIONS = Collections.EMPTY_LIST;

    @Before
    public void setUp() {
        statementPrinter = new StatementPrinter(console);
    }
    @Test
    public void always_print_the_header() {
        statementPrinter.print(NO_TRANSACTIONS);
        verify(console).printLine("DATE | AMOUNT | BALANCE");
    }

    @Test
    public void print_transactions_in_chronological_order () {
        statementPrinter.print(transactionsContaining(
                deposit("01/04/2014", 1000),
                withdraw("02/04/2014", 100),
                deposit("10/04/2014", 500)
        ));
        verify(console).printLine("DATE | AMOUNT | BALANCE");

        InOrder inOrder = Mockito.inOrder(console);

        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");


    }

    private List<Transaction> transactionsContaining(final Transaction ...transactions) {
        return Arrays.asList(transactions);
    }

    private Transaction withdraw(final String date, final int amount) {
        return new Transaction(date, -amount);
    }

    private Transaction deposit(final String date, final int amount) {
        return new Transaction(date, amount);
    }
}