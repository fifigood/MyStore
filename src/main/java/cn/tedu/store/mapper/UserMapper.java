package cn.tedu.store.mapper;

import cn.tedu.store.bean.User;
/*
 * �V�ƾڴ��J�ƾ�
 * @param user
 */


public interface UserMapper {
void insert(User user);
User selectByUsername(String username);
/*
 * �q�Lemail�����d��
 * �p�Gemail�s�b��^1
 * �_�h��^0
 */
Integer selectByEmail(String email);
Integer selectByPhone(String phone);

/**
 * �ק�ӤH�H��
 * @param user
 */
void update(User user);

User selectById(Integer id);



}
