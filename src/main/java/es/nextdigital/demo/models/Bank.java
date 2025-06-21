package es.nextdigital.demo.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private Long id;
	private String name;
	private Float externalCommission;
	@OneToMany(mappedBy = "bank")
	private List<Account> accounts;

}
