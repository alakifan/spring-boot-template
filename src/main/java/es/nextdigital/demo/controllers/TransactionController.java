package es.nextdigital.demo.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.nextdigital.demo.dto.TransactionDTO;
import es.nextdigital.demo.models.Transaction;
import es.nextdigital.demo.services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	private TransactionService transactionService;
	private ModelMapper mapper = new ModelMapper();
	
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	private TransactionDTO mapToTransactionDTO(Transaction transaction) {
		return this.mapper.map(transaction, TransactionDTO.class);
	}
	
	@GetMapping("/getTransactions")
	public List<TransactionDTO> getTransactions(@RequestParam String cardNumber, @RequestParam String secretNumber) {
		return transactionService.getAccountTransactions(cardNumber, secretNumber).stream().map(this::mapToTransactionDTO).toList();
	}
	
}
