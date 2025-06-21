package es.nextdigital.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import es.nextdigital.demo.models.Account;

public interface IAccountRepository extends JpaRepository<Account, UUID> {

}
