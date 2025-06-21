package es.nextdigital.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import es.nextdigital.demo.models.BankUser;

public interface IUserRepository extends JpaRepository<BankUser, UUID> {

}
