package com.blucursor.UserInformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	List<String> DBemails = new ArrayList<>();
	@Autowired
	private UserService service;

	@PostMapping("/adduser")

	public void inputvalue(@RequestBody User user) {
		service.save(user);
	}
	@PostMapping("/delete")
	public void deletevalue(@RequestBody Map<String, String> email) {
		String payload = email.get("email");
		service.delete(payload);
	}
        
	@PostMapping("/validateEmail")
	public boolean validate(@RequestBody Map<String, String> email) {
		String payload = email.get("email");
		boolean userFound = true;
		DBemails = service.emailIdValidation();
		for (String temp : DBemails) {
			if (temp.trim().equals(payload)) {
				return userFound;
			}
		}
		return false;
	}

}

