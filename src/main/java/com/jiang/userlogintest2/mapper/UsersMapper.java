package com.jiang.userlogintest2.mapper;


import com.jiang.userlogintest2.pojo.User;

//@Mapper
public interface UsersMapper {

	//根据用户名返回用户数据
	User getUserByName(String username);
	
	//返回全部用户数据
	User[] getAllUserInfo();
	
	//更新用户数据
	Boolean updateUserInfo(Integer id,String username,String password);
	
	//删除用户
	Boolean deleteById(Integer id);
	
	//增加用户
	Boolean insertUser(String username,String password);
}
