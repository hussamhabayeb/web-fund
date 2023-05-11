package com.example.project.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.project.models.User;



//.. imports .. //

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
 Optional<User> findByEmail(String email);
 
}
