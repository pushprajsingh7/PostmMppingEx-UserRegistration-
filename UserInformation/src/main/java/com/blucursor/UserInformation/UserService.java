package com.blucursor.UserInformation;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

	@Autowired
	public UserRepository Userrepo;

	public List<User> listAll() {
		return Userrepo.findAll();
	}

	public void save(User data) {
		Userrepo.save(data);
	}

	public List<String> emailIdValidation() {
		return Userrepo.listOfEmailId();
	}

	void delete(String email) {
		int id = Userrepo.serialid(email);
		Userrepo.deleteById(id);
	}

	public String validate(String email) {
		String pass = Userrepo.validaterepo(email);
		return pass;
	}

	public List<String> check() {
		return Userrepo.emailcheck();
	}
}
