package com.mark1.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mark1.entity.core.Role;
import com.mark1.repository.RoleRepository;

@Service
@Transactional(readOnly = true)
public class RestRoleService implements RoleService {
	
	@Inject
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role getRoleById(long id) {
		return roleRepository.findById(id);
	}

	@Override
	public List<Role> findRoleByName(String name) {
		return roleRepository.findByName(name);
	}

	@Override
	@Transactional
	public Role saveRole(Role role) {
		role.setId(0);
		role.setName(StringUtils.upperCase(role.getName()));
		
		return roleRepository.save(role);
	}

	@Override
	@Transactional
	public Role updateRole(long id, Role role) {
		Role ori = getRoleById(role.getId());
		if (ori != null) {
			ori.setName(role.getName());
			ori.setDescription(role.getDescription());
		}
		
		return ori;
	}

	@Override
	@Transactional
	public void deleteRole(long id) {
		roleRepository.delete(id);
	}
	
}