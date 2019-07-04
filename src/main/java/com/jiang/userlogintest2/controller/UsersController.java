package com.jiang.userlogintest2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiang.userlogintest2.pojo.User;
import com.jiang.userlogintest2.service.UsersService;



@Controller
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@ResponseBody
	@RequestMapping(value="/logincheck",method=RequestMethod.POST)
	public Boolean isUserRight(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		User receivedUser=new User();
		receivedUser.setUsername(username);
		receivedUser.setPassword(password);
		return usersService.isUserRight(receivedUser);
	}
	
	@ResponseBody
	@RequestMapping(value="/getalluser",method=RequestMethod.GET)
	public User[] getAllUser() {
		User[] allUser=usersService.getAllUser();
		System.out.println(allUser);
		return usersService.getAllUser();
	}
	
	@ResponseBody
	@RequestMapping(value="/userupdate",method=RequestMethod.POST)
	public Boolean changeUserInfo(@RequestParam("id") Integer id,
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		User receivedUser=new User();
		receivedUser.setId(id);
		receivedUser.setUsername(username);
		receivedUser.setPassword(password);
		return usersService.changeUserInfo(receivedUser);
	}
	
	@ResponseBody
	@RequestMapping(value="/userdelete",method=RequestMethod.POST)
	public Boolean deleteUser(@RequestParam("id") Integer id) {
		return usersService.deleteUser(id);
	}
	
	@ResponseBody
	@RequestMapping(value="/useradd",method=RequestMethod.POST)
	public Boolean addUser(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		User receivedUser=new User();
		receivedUser.setUsername(username);
		receivedUser.setPassword(password);
		return usersService.addUser(receivedUser);
	}
	
	@ResponseBody
	@RequestMapping("/")
	public String test() {
		return "spring boot is running!";
	}
	
	@ResponseBody
	@RequestMapping(value="/cma/login",method=RequestMethod.POST)
	public Boolean temperaryLoginCheck(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		if(username=="cctv"&&password=="cctv20190124") {
			return true; 
		}
		return false;
	}
}
