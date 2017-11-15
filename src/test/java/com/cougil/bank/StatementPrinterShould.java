package com.cougil.bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
}