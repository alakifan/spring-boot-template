package es.nextdigital.demo.services;

import org.springframework.stereotype.Service;

import es.nextdigital.demo.models.Card;
import es.nextdigital.demo.repositories.ICardRepository;
import jakarta.transaction.Transactional;

@Service
public class CardService {

private ICardRepository cardRepository;
	
	public CardService(ICardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
	
	@Transactional
	public void activateCard(String cardNumber, String secretNumber) {
		
		Card card = cardRepository.findByCardNumber(cardNumber);
		
		if (secretNumber != card.getSecretNumber()) {
			throw new RuntimeException("Invalid secret number");
		} else if (card.isCardExpired()) {
			throw new RuntimeException("Your card expired");
		} else if (card.isActive()) {
			throw new RuntimeException("Your card is already active");
		}
		
		card.setActive(true);
		cardRepository.save(card);
		
	}
	
}
