package es.nextdigital.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.nextdigital.demo.dto.CardDTO;
import es.nextdigital.demo.services.CardService;

@RestController
@RequestMapping("/card")
public class CardController {
	
	private CardService cardService;
	
	public CardController(CardService cardService) {
		this.cardService = cardService;
	}
	
	@PostMapping("/activate")
	public ResponseEntity<?> activateCard(@RequestBody CardDTO cardDto) {
		
		try {
			cardService.activateCard(cardDto.getCardNumber(), cardDto.getSecretNumber());
			return ResponseEntity.ok().body("Card activated");
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}

}
