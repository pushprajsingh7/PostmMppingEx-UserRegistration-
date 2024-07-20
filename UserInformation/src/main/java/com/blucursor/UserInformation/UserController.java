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

	public Map<String,String> inputdata(@RequestBody User data) {
		Map<String, String> addUser = new HashMap<>();
		if (data.email != null && data.password != null && data.fullname != null) {
			String payload = data.email;
			if (service.check().contains(payload)) {
				addUser.put("email", "User already Exists");
				return addUser;
			} else {
				addUser.put("email", "User Created");
				service.save(data);
				return addUser;
			}
		}
		addUser.put("email","Please add Credentials");
		return addUser;
	}

	@PostMapping("/delete")
	public Map<String, String> deletevalue(@RequestBody Map<String, String> email) {
		Map <String,String> deleteUser= new HashMap<>();
		String payload = email.get("email");
		if (!(this.validate(email))) {
			deleteUser.put("email","Incorrect email");
			return deleteUser;
		} else {
			service.delete(payload);
			deleteUser.put("email","User deleted");
			return deleteUser;
		}
	}

	@PostMapping("/password")
	public Map <String,String> passwordValidate(@RequestBody Map<String, String> payload) {
		Map <String,String> login= new HashMap<>();
		String payloadmail = payload.get("email");
		if (!(this.validate(payload))) {
			login.put("email","Incorrect email");
			login.put("password","checking password");
			return login;
		}
		String passwordInDB = service.validate(payloadmail);
		String payloadPass = payload.get("password");
		if (passwordInDB.equals(payloadPass)) {
			login.put("email","correct email");
			login.put("password", "correct password");
			return login;
		} else {
			login.put("email","correct email");
			login.put("password", "incorrect password");
			return login;
		}
	}

	@PostMapping("/validateEmail")
	public boolean validate(@RequestBody Map<String, String> email) {
		String payload = email.get("email");
		boolean userFound = true;
		DBemails = service.check();
		for (String temp : DBemails) {
			if (temp.trim().equals(payload)) {
				return userFound;
			}
		}
		return false;
	}

}
