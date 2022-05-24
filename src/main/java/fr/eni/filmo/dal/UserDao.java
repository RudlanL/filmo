package fr.eni.filmo.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.filmo.bo.User;

public interface UserDao extends JpaRepository<User, Long> {

}
