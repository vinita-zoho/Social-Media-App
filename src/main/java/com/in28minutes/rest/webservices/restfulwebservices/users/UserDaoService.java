package com.in28minutes.rest.webservices.restfulwebservices.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	
	private static Integer usersCount = 0;
	
	static 
	{
		users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30))); // 30 yrs old
		users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25))); // 25 yrs old
		users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20))); // 20 yrs old
	}
	
	public List<User> findAll()
	{
		return users;
	}
	
	public User findOne(int id)
	{
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	public User saveUser(User user)
	{
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id)
	{
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}

}
