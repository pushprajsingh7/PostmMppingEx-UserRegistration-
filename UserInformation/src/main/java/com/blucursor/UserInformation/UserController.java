package com.blucursor.UserInformation;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	@Autowired
	public UserRepository Userrepo;
     List<User>  DBemails=new ArrayList<>();
	@Autowired
	private UserService service;

	@PostMapping("/adduser")
	
	public void inputvalue(@RequestBody User user) {
        service.save(user);
	}	
	
	@PostMapping("/validate")
     public boolean validate(@RequestBody User email) {
		boolean userFound=true;
			DBemails= service.emailIdValidation();
			for(User temp:DBemails) {
				if(temp.equals(email)) {
					return userFound;
				}
				else {
					return false;
				}
			}
			return false;
		}
}
		
		
	


