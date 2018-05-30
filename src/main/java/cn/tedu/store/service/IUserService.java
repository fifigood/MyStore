package cn.tedu.store.service;

import cn.tedu.store.bean.User;
import cn.tedu.store.service.ex.UserNameAlreadyExsitException;

public interface IUserService {
	/*
	 * �Ψӹ�{���U�\�઺��k
	 * user�ʸˤF�����ƾڪ���H
	 */
void register(User user) ;
/**
 * 
 * @param email
 * @return �p�G�s�b��^ ture �S�N��^false
 */
boolean checkemail(String email);
boolean checkphone(String phone);
/**
 * �Τ�����
 * @param username
 * @return�Y�Onull,�^false:�_�h��^true
 */
boolean checkUsername(String username);
/**
 * �����n��
 * @param username
 * @param password
 * @return ��^user��H,�_�h�ߥX���`
 */
User login(String username,String password);
/**
 * �ק�K�X
 * @param id
 * @param oldPwd
 * @param newPwd
 * @return 
 */
void changePassword(Integer id, String oldPwd, String newPwd);
}


