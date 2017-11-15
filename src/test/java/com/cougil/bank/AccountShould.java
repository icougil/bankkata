package com.cougil.bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

    @Mock private TransactionRepository transactionRepository;
    @Mock private StatementPrinter statementPrinter;

    private Account account;

    @Before
    public void setUp() {
        account = new Account(transactionRepository, statementPrinter);
    }

    @Test
    public void store_a_deposit_transaction() {
        account.deposit(100);
        verify(transactionRepository).addDeposit(100);
    }

    @Test
    public void store_a_withdraw_transaction() {
        account.withdraw(300);
        verify(transactionRepository).addWithdraw(300);
    }

    @Test
    public void print_a_statement() {
        List<Transaction> transactions = Arrays.asList( new Transaction() );
        given(transactionRepository.findTransactions()).willReturn(transactions);

        account.printStatement();

        verify(statementPrinter).print(transactions);
    }
}