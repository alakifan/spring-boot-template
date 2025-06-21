package es.nextdigital.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import es.nextdigital.demo.models.Transaction;

public interface ITransactionRepository extends JpaRepository<Transaction, UUID> {

}
