package es.nextdigital.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import es.nextdigital.demo.models.Account;
import es.nextdigital.demo.models.Card;
import es.nextdigital.demo.models.Transaction;
import es.nextdigital.demo.repositories.ICardRepository;
import es.nextdigital.demo.services.TransactionService;

public class TransactionTests {
	
	@Test
	void getTransactionsTest() throws ParseException {
		
		ICardRepository cardRepo = mock(ICardRepository.class);
		TransactionService service = new TransactionService(cardRepo);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		
		Card testCard = new Card();
		Account testAccount = new Account();
		
		List<Transaction> transactions = new ArrayList<>();
		for (int i = 0; i <= 5; i++) {
			Transaction transaction = new Transaction();
			transaction.setAmmount((float) i);
			transactions.add(transaction);
		}
		
		testAccount.setTransactions(transactions);
		testCard.setAccount(testAccount);
		testCard.setCardNumber("9999");
		testCard.setSecretNumber("1111");
		testCard.setActive(true);
		testCard.setExpirationDate(sdf.parse("28-Oct-2028"));
		
		when(cardRepo.findByCardNumber("9999")).thenReturn(testCard);
		
		assertEquals(transactions, service.getAccountTransactions("9999", "1111"));
		
	}

}
