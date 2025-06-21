package es.nextdigital.demo.models;

import java.util.Date;

import es.nextdigital.demo.models.enums.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private Long id;
	private Date date;
	private Float ammount;
	@ManyToOne
	private Account account;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
}