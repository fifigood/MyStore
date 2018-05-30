package cn.tedu.store.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNameAlreadyExsitException;
import cn.tedu.store.service.ex.UserNotFoundException;

@Service
public class UserService implements IUserService {
	@Resource
	private UserMapper userMapper;

	public void register(User user) {
		// �Τ�W�O�_�s�b�A�Y�s�b�ߥX���`�A�_�h�������J�ާ@
		if (userMapper.selectByUsername(user.getUsername()) == null) {
			userMapper.insert(user);

		} else {

			throw new UserNameAlreadyExsitException("�ӥΤ�w�s�b");

		}
	}

	public boolean checkemail(String email) {

		return userMapper.selectByEmail(email) > 0;
	}

	public boolean checkphone(String phone) {

		return userMapper.selectByPhone(phone) > 0;
	}

	public boolean checkUsername(String username) {
		/**
		 * �Τ�����
		 * @param username
		 * @return�Y�Onull,�^false:�_�h��^true
		 */
		User user=userMapper.selectByUsername(username);
		if(user==null) {
			return false;
		}else {
			return true;	
		}
		
	}

	public User login(String username, String password) {
		User user=userMapper.selectByUsername(username);
		if(user==null) {
			throw new UserNotFoundException("�ӥΤᤣ�s�b");
		}else if(user.getPassword().equals(password)){
			return user;
		}else {
			throw new PasswordNotMatchException("�K�X���~");
		}
	}

	public void changePassword(Integer id, String oldPwd, String newPwd) {
      User user= userMapper.selectById(id);
       if(user!=null){
    	   
    	   if(user.getPassword().equals(oldPwd)){
    		   User u=new User();
    		   u.setId(id);
    		   u.setPassword(newPwd);
    		   userMapper.update(u);
    	   }else{
    		   
    		   throw new PasswordNotMatchException("�K�X���~");
    		   
    	   }
    	   
    	   
       }
		
	}

}
