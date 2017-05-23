package com.mark1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mark1.entity.core.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Role findById(long id);
	
	@Query("SELECT r FROM Role r WHERE r.name LIKE %?1%")
	List<Role> findByName(String name);

}
