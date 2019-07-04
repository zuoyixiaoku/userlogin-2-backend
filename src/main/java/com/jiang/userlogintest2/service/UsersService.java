package com.jiang.userlogintest2.service;

import com.jiang.userlogintest2.pojo.User;

public interface UsersService {

	Boolean isUserRight(User user);
	
	User[] getAllUser();
	
	Boolean changeUserInfo(User user);
	
	Boolean deleteUser(Integer id);
	
	Boolean addUser(User user);
}
