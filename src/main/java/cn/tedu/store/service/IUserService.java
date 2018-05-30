package cn.tedu.store.service;

import cn.tedu.store.bean.User;
import cn.tedu.store.service.ex.UserNameAlreadyExsitException;

public interface IUserService {
	/*
	 * 用來實現註冊功能的方法
	 * user封裝了頁面數據的對象
	 */
void register(User user) ;
/**
 * 
 * @param email
 * @return 如果存在返回 ture 沒就返回false
 */
boolean checkemail(String email);
boolean checkphone(String phone);
/**
 * 用戶驗證
 * @param username
 * @return若是null,回false:否則返回true
 */
boolean checkUsername(String username);
/**
 * 完成登錄
 * @param username
 * @param password
 * @return 返回user對象,否則拋出異常
 */
User login(String username,String password);
/**
 * 修改密碼
 * @param id
 * @param oldPwd
 * @param newPwd
 * @return 
 */
void changePassword(Integer id, String oldPwd, String newPwd);
}


