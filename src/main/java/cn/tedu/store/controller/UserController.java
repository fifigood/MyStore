package cn.tedu.store.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.UserNameAlreadyExsitException;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private IUserService userservice;

	// @Resource
	// private ResponseResult<Void>rr;

	@RequestMapping("/showRegister.do")
	public String showRegister() {

		return "register";
	}

	/**
	 * 顯示登錄頁面
	 * 
	 * @return view組件名 
	 */
	@RequestMapping("/showLogin.do")
	public String showLogin() {

		return "login";
	}
/**
 * 顯示個人信息頁面
 * @return
 */
	@RequestMapping("/showpersoninfo.do")
	public String ShowInfo() {

		return "personinfo";

	}

	@RequestMapping("/spassword.do")
	public String showpassword() {

		return "personal_password";
	}

	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if (userservice.checkUsername(username)) {
			rr.setState(0);
			rr.setMessage("用戶已存在");
		} else {
			rr.setState(1);
			rr.setMessage("用戶可以使用");

		}

		return rr;
	}

	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email) {
		ResponseResult<Void> rr = new ResponseResult<Void>();

		if (userservice.checkemail(email)) {
			rr.setState(0);
			rr.setMessage("email已存在");
		} else {
			rr.setState(1);
			rr.setMessage("email可使用");
		}

		return rr;
	}

	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		/**
		 * 調用業務層方法checkphone方法
		 */
		if (userservice.checkphone(phone)) {
			rr.setState(0);
			rr.setMessage("該電話已存在");
		} else {
			rr.setState(1);
			rr.setMessage("該電話可以使用");
		}
		return rr;
	}

	/**
	 * 註冊
	 * 
	 * @param username
	 * @param password
	 * @param email
	 * @param phone
	 * @return
	 */
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(@RequestParam("uname") String username, @RequestParam("upwd") String password,
			String email, String phone) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		try {
			userservice.register(user);// 沒判斷到
			rr.setState(1);
		} catch (UserNameAlreadyExsitException e) {
			rr.setState(0);
			rr.setMessage("用戶名已存在");
		}

		return rr;
	}

	/**
	 * 登入的業務功能
	 * 
	 * @param username
	 * @param password
	 * @return rr
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username, String password, HttpSession session) {
		ResponseResult<Void> rr = new ResponseResult<Void>();

		try {
			User user = userservice.login(username, password);
			/**
			 * 把user(註冊訊息)存到session裡面 實際頁面功能:登陸成功後把user存到session當中
			 */
			session.setAttribute("user", user);
			rr.setState(1);
			rr.setMessage("登錄成功");
		} catch (Exception e) {
			// 只能捕獲一個，從業務層獲取的異常訊息
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		return rr;
	}

	/**
	 * 退出功能
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/exit.do")
	public String exit(HttpSession session) {
		// 讓session失效
		session.invalidate();
		// 重定向
		return "redirect:../main/showIndex.do";
	}

	/**
	 * 修改密碼
	 * 
	 * @param session
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	@RequestMapping("/password.do")
	@ResponseBody
	public ResponseResult<Void> password(HttpSession session, String oldPwd, String newPwd) {
		// 1.创建对象 rr
		ResponseResult<Void> rr = new ResponseResult<Void>();
		try {
			// 2.调用业务层方法 changePassword()

			userservice.changePassword(this.getId(session), oldPwd, newPwd);
			// 3.1,密码修改成功
			rr.setState(1);
			rr.setMessage("密码修改成功");
		} catch (Exception e) {
			// 4.0，e.getMessage()
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		return rr;
	}

}
