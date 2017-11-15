package com.cougil.bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryShould {

    private TransactionRepository transactionRepository;
    @Mock
    private Clock clock;

    public static final String TODAY = "16/11/2017";

    @Before
    public void setUp() {
        transactionRepository = new TransactionRepository(clock);
        given(clock.today()).willReturn(TODAY);
    }

    @Test
    public void create_and_store_a_deposit_transaction() {

        transactionRepository.addDeposit(100);

        List<Transaction> transactions = transactionRepository.findTransactions();
        assertThat(transactions.size()).isEqualTo(1);
        assertThat(transactions.get(0)).isEqualTo(transaction(TODAY, 100));
    }

    @Test
    public void create_and_store_a_withdraw_transaction() {

        transactionRepository.addWithdraw(100);

        List<Transaction> transactions = transactionRepository.findTransactions();
        assertThat(transactions.size()).isEqualTo(1);
        assertThat(transactions.get(0)).isEqualTo(transaction(TODAY, -100));

    }

    private Transaction transaction(final String date, final int amount) {
        return new Transaction(date, amount);
    }
}