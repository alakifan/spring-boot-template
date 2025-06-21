package es.nextdigital.demo.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private Long id;
	private Float savings;
	private String iban;
	@ManyToOne
	private User user;
	@ManyToOne
	private Bank bank;
	@OneToMany(mappedBy = "account")
	private List<Transaction> transactions;
	@OneToMany(mappedBy = "account")
	private List<Card> cards;
}
