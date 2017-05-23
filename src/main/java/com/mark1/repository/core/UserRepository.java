package com.mark1.repository.core;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mark1.entity.core.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	
	User findUserByUsername(String username);
	
	User findUserByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.name LIKE %?1% AND u.logInformation.activeFlag = ?2")
	List<User> findUserByName(String name, int activeFlag);

	

}
