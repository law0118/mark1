package com.mark1.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.mark1.entity.core.Role;


@Path("/roles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RoleService {
	@GET
	@Path("/{id}")
	Role getRoleById(@PathParam("id") long id);
	
	@GET
	List<Role> findRoleByName(@QueryParam("name") @DefaultValue("") String name);
	
	@POST
	Role saveRole(Role role);
	
	@PUT
	@Path("/{id}")
	Role updateRole(@PathParam("id") long id, Role role);
	
	@DELETE
	@Path("/{id}")
	void deleteRole(@PathParam("id") long id);
}