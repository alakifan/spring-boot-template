package es.nextdigital.demo.dto;

import java.util.Date;
import java.util.UUID;

import es.nextdigital.demo.models.enums.TransactionType;
import lombok.Data;

@Data
public class TransactionDTO {

	private UUID id;
	private Date date;
	private Float ammount;
	private TransactionType transactionType;
	
}
