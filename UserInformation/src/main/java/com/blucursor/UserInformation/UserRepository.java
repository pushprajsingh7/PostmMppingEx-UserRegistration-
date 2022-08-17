package com.blucursor.UserInformation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, String> {
	@Query(value = "select Email from userinfo", nativeQuery = true)
	List<User> listOfEmailId();


}
