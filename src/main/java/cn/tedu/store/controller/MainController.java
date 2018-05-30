package cn.tedu.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
/**
 * ≈„•‹index.jsp≠∂≠±
 * @author TEDU.TW
 *
 */
public class MainController {
@RequestMapping("/showIndex.do")
public String showIndex() {
	
	return "index";
}

}
