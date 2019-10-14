/**
 * 
 */
package com.zhangzhi.senior2.week2.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhangzhi
 *2019年10月14日
 */
@Controller
public class Mycontroller {
	
	@Autowired
	RedisTemplate r;
	
	
	//注释
	@RequestMapping("df")   //打注释好累啊
	public void df() {  //这个方法没用
		System.out.println(4545);  //我测试三层架构好不好使的
	}
	
	@RequestMapping("findall")
	public String findall(Model model,@RequestParam(value = "page",defaultValue = "1") Integer num) {
		int size=10;
		List list = r.opsForList().range("goods_list", (num-1)*size, (num-1)*size+size-1);
		model.addAttribute("list", list);
		if(num!=1) {
			model.addAttribute("prepage", num-1); //如果不是第一页就可以减少
		}else {
			model.addAttribute("prepage", num);//如果是第一页就不可以减少
		}
		model.addAttribute("nextpage", num+1);//加一
		return "findadd"; //返回
	}
	
	@RequestMapping("find")
	public String find(Model model,@RequestParam(value = "page",defaultValue = "1") Integer num) {
		int size=10;
		Set set = r.opsForZSet().reverseRange("goods_zset", (num-1)*size, (num-1)*size+size-1);
		model.addAttribute("list", set);
		if(num!=1) {
			model.addAttribute("prepage", num-1);//如果不是第一页就可以减少
		}else {
			model.addAttribute("prepage", num);//如果是第一页就不可以减少
		}
		model.addAttribute("nextpage", num+1);//下一页加一
		return "find";//返回
	}
	
	
}


