package es.nextdigital.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import es.nextdigital.demo.models.Card;
import es.nextdigital.demo.models.Transaction;
import es.nextdigital.demo.repositories.ICardRepository;

@Service
public class TransactionService {
	
	private ICardRepository cardRepository;
	
	public TransactionService(ICardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	
	public List<Transaction> getAccountTransactions(String cardNumber, String secretNumber) {
		
		Card card = cardRepository.findByCardNumber(cardNumber);
		
		if (secretNumber != card.getSecretNumber()) {
			throw new RuntimeException("Invalid secret number");
		} else if (!card.isActive()) {
			throw new RuntimeException("Please, activate your card first");
		} else if (card.isCardExpired()) {
			throw new RuntimeException("Your card expired");
		}
		
		return card.getAccount().getTransactions();
		
	}

}
