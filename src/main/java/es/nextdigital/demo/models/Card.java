package es.nextdigital.demo.models;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String cardNumber;
	private Date expirationDate;
	private String secretNumber;
	private boolean active;
	private Float limit;
	@ManyToOne
	private Account account;

}
