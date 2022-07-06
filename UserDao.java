package net.codejava;


import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;  
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.util.ArrayList; 
import java.util.List;  

public class UserDao { 
	
	static List<Book> bookList = new ArrayList<Book>(); 
	
	public List<User> updateUser(int id, String name) throws IOException, ClassNotFoundException{ 
		 List<User> userList = null; 
			File file = new File("Users.dat"); 
		 FileInputStream fis;
		try {
		
			fis = new FileInputStream(file);
			 ObjectInputStream ois = new ObjectInputStream(fis); 
			
	         userList = (List<User>) ois.readObject(); 
	         for (int i=0;i<userList.size();i++) {
	            	if(userList.get(i).getId()==id) {
	            		userList.get(i).setName(name);
	            	}
	            }
	         
	         ois.close(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		if( file.delete()) {
		file = new File("Users.dat"); 
         if (!file.exists()) { 
        
            saveUserList(userList); 
         } 
		}
		 return userList; 
	}
   public List<User> getAllUsers(){ 
      
      List<User> userList = null; 
      try { 
         File file = new File("Users.dat"); 
         if (!file.exists()) { 
            User user = new User(1, "Ahmad", "Yahya"); 
            userList = new ArrayList<User>(); 
            userList.add(user); 
            User user1 = new User(2, "Zahraa", "Mohamed"); 
            userList.add(user1); 
            saveUserList(userList); 
         } 
         else{ 
            FileInputStream fis = new FileInputStream(file); 
            ObjectInputStream ois = new ObjectInputStream(fis); 
            userList = (List<User>) ois.readObject(); 
            
            ois.close(); 
         } 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } catch (ClassNotFoundException e) { 
         e.printStackTrace(); 
      }   
      return userList; 
   } 
   private void saveUserList(List<User> userList){ 
      try { 
         File file = new File("Users.dat"); 
         FileOutputStream fos;  
         fos = new FileOutputStream(file); 
         ObjectOutputStream oos = new ObjectOutputStream(fos); 
         oos.writeObject(userList); 
         oos.close(); 
      } catch (FileNotFoundException e) { 
         e.printStackTrace(); 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } 
   }  
   
   
	public List<User> deleteUser(int id) throws ClassNotFoundException, IOException{ 
		 List<User> userList = null; 
			File file = new File("Users.dat"); 
		 FileInputStream fis;
		try {
		
			fis = new FileInputStream(file);
			 ObjectInputStream ois = new ObjectInputStream(fis); 
			
	         userList = (List<User>) ois.readObject(); 
	         for (int i=0;i<userList.size();i++) {
	            	if(userList.get(i).getId()==id) {
	            		userList.remove(i);
	            	}
	            }
	         
	         ois.close(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		if( file.delete()) {
		file = new File("Users.dat"); 
        if (!file.exists()) { 
       
           saveUserList(userList); 
        } 
		}
		 return userList; 
	}
	
	public List<Book> addbook( String title, String author )
	{
		
		   Book book1 = new Book(title, author); 
           bookList.add(book1); 
		return bookList;
}

	public String searchbook( String title ){

for (int i=0;i<bookList.size();i++) {
	if(bookList.get(i).getTitle().toString().equals(title)) {
		return bookList.get(i).getTitle()+"/"+bookList.get(i).getAuthor();
	
}
}
return "not found";
	
}
}


