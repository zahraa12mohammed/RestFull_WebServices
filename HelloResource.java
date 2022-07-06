package net.codejava;


import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/bonjour")
public class HelloResource {
	 UserDao userDao = new UserDao();  
	
	@GET
	@Path("/users") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers(){ 
	      return userDao.getAllUsers(); 
	   }
	
	@GET
	@Path("/users/{id}/{name}") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> updateUsers(@PathParam("id") Integer id, @PathParam("name") String name){ 
		
	      try {
			return userDao.updateUser(id, name);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	      return null;
	   }
	
	@GET
	@Path("/users/delete/{id}") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> deleteUsers(@PathParam("id") Integer id) {
	      try {
			return userDao.deleteUser(id);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	      return null;
	   }
	
	@GET
	@Path("/book/add/{title}/{author}") 
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> addbook(@PathParam("title") String title, @PathParam("author") String author) {
		return userDao.addbook(title,author);
	      
	}
	
	@GET
	@Path("/book/search/{title1}") 
	@Produces(MediaType.TEXT_PLAIN)
	public String addbook(@PathParam("title1") String titlee) {
		return userDao.searchbook(titlee);
	      
	}
}
