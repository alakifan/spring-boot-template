package es.nextdigital.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.nextdigital.demo.models.User;

public interface IUserRepository extends JpaRepository<User, Long> {

}
