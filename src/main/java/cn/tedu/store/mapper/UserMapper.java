package cn.tedu.store.mapper;

import cn.tedu.store.bean.User;
/*
 * 向數據插入數據
 * @param user
 */


public interface UserMapper {
void insert(User user);
User selectByUsername(String username);
/*
 * 通過email完成查詢
 * 如果email存在返回1
 * 否則返回0
 */
Integer selectByEmail(String email);
Integer selectByPhone(String phone);

/**
 * 修改個人信息
 * @param user
 */
void update(User user);

User selectById(Integer id);



}
