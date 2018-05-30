package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.service.DictService;
import cn.tedu.store.service.IDictService;

public class TestDict {
	@Test
	public void TestSelectPrivince(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		DictMapper dm=ac.getBean("dictMapper",DictMapper.class);
		System.out.println(dm.selectProvince());
}
@Test
public void TestgetPrivince(){
	ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
	IDictService Hm=ac.getBean("dictService",DictService.class);
	
	System.out.println(Hm.getProvince());
	
}
	
	
	
	
	
	
	
}