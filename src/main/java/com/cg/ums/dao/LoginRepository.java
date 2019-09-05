package com.cg.ums.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ums.dto.Login;

@Repository("loginJpaDao")
@Transactional
public interface LoginRepository extends JpaRepository<Login,String> 
{
	@Query("SELECT userList FROM Login userList")
	public ArrayList<Login> getAllUsers();
	
	@Query("SELECT log FROM Login log WHERE log.userName=:unm")
	public Login getUserByUserName( @Param("unm")String unm);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Login log WHERE log.userName=:unm")
	public void deleteUserByUserName(@Param("unm") String unm);
	
	@Modifying
	@Query("update Login log SET log.userPass=:pwd WHERE log.userName=:nm")
	public void updateUserInfo(@Param("pwd") String pwd, @Param("nm") String unm); 

}
