package com.blucursor.UserInformation;

import java.util.List;

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

	public void save(User user) {
		Userrepo.save(user);
	}

	public List<User> emailIdValidation() {
		return Userrepo.listOfEmailId();
	}

}
