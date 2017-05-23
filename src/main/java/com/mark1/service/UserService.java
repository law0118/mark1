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

import com.mark1.entity.core.User;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserService {
	@GET
	@Path("/{username}")
	User getUserByUsername(@PathParam("username") String username);
	
	@GET
	List<User> findUserByName(@QueryParam("name") @DefaultValue("") String name);
	
	@POST
	User saveUser(User user);
	
	@PUT
	@Path("/{username}")
	User updateUser(@PathParam("username") String username, User user);
	
	@DELETE
	@Path("/{username}")
	void deleteUser(@PathParam("username") String username);


}