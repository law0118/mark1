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

import com.mark1.entity.Category;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CategoryService {
	@GET
	@Path("/{id}")
	Category getCategoryById(@PathParam("id") long id);
	
	@GET
	List<Category> findCategoryByName(@QueryParam("name") @DefaultValue("") String name);
	
	@POST
	Category saveCategory(Category category);
	
	@PUT
	@Path("/{id}")
	Category updateCategory(@PathParam("id") long id, Category category);
	
	@DELETE
	@Path("/{id}")
	void deleteCategory(@PathParam("id") long id);
}

