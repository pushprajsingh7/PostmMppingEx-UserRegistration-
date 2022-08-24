package com.blucursor.UserInformation;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "select Email from userinfo", nativeQuery = true)
	 List<String> listOfEmailId();
	
	@Query(value = "select userid from userinfo where email=:email", nativeQuery = true)
	int serialid(@Param("email")String email);
	
	@Query(value = "select password from userinfo where email=:email", nativeQuery = true)
	String validaterepo(@Param("email")String email);
	
	@Query(value="select email from userinfo",nativeQuery=true)
	List<String> emailcheck();
	
}
