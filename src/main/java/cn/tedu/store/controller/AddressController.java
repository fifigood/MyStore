package cn.tedu.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/address")
@Controller
public class AddressController extends BaseController{
	/**
	 * ��ܦa�}����
	 * @return addressAdmin.jsp (view)
	 */
@RequestMapping("/showaddress.do")
	public String ShowAddress(){
		
		return "addressAdmin";
	}	
	
}
