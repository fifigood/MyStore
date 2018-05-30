package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IDictService;

@RequestMapping("/dict")
@Controller
public class DictController extends BaseController{
@Resource
private IDictService dictservice;
	
	
	
@RequestMapping("/showProvince.do")
@ResponseBody
public ResponseResult<List<Province>>showProvince(){
	//創建rr對象
	ResponseResult<List<Province>>rr=new ResponseResult<List<Province>>();
	//調用業務層方法返回集合List<Province> 
	List<Province> list=dictservice.getProvince();
	//把集合設置道rr對象中
	rr.setData(list);
	
	return rr;
}
	
	
}
