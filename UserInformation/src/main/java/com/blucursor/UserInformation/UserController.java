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

	public boolean inputdata(@RequestBody User data) {
		String payload = data.email;
		if (service.check().contains(payload)) {
			return false;
		} else {
			service.save(data);
			return true;
		}
	}

	@PostMapping("/delete")
	public boolean deletevalue(@RequestBody Map<String, String> email) {
		String payload = email.get("email");
		if (!(this.validate(email))) {
			return false;
		} else {
			service.delete(payload);
			return true;
		}
	}

	@PostMapping("/password")
	public boolean passwordvalidate(@RequestBody Map<String, String> payload) {
		String payloadmail = payload.get("email");
		if (!(this.validate(payload))) {
			return false;
		}
		String passwordInDB = service.validate(payloadmail);
		String payloadPass = payload.get("password");
		return passwordInDB.equals(payloadPass) ? true : false;

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
