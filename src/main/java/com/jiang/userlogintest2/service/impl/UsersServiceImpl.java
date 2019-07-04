package com.jiang.userlogintest2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiang.userlogintest2.mapper.UsersMapper;
import com.jiang.userlogintest2.pojo.User;
import com.jiang.userlogintest2.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public Boolean isUserRight(User user) {
		User resultUser=usersMapper.getUserByName(user.getUsername());
		if(resultUser!=null) {
			String userName=user.getUsername(),userPassword=user.getPassword();
			String resultUserName=resultUser.getUsername(),resultUserPassword=resultUser.getPassword();
			
			System.out.println("user.username="+userName);
			System.out.println("user.password="+userPassword);
			System.out.println("resultUser.username="+resultUserName);
			System.out.println("resultUser.password="+resultUserPassword);
			if(userPassword.equals(resultUserPassword)) {
				return true;
			}
		}
		return false;
		
	
	}

	@Override
	public User[] getAllUser() {
		return usersMapper.getAllUserInfo();
	}

	@Override
	public Boolean changeUserInfo(User user) {
		try {
			usersMapper.updateUserInfo(user.getId(),user.getUsername(),user.getPassword());
		}catch (Exception err) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean deleteUser(Integer id) {
		try {
			usersMapper.deleteById(id);
		}catch (Exception err) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean addUser(User user) {
		try {
			usersMapper.insertUser(user.getUsername(), user.getPassword());
		}catch (Exception err) {
			return false;
		}
		return true;
	}

	
}
