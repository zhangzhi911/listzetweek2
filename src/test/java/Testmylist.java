import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhangzhi.myUtil.RandomUtil;
import com.zhangzhi.myUtil.StreamUtil;
import com.zhangzhi.myUtil.StringUtil;
import com.zhangzhi.senior2.week2.domain.Goods;

/**
 * 
 */

/**
 * @author zhangzhi
 *2019年10月14日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class Testmylist {

	@Autowired
	RedisTemplate r;
	
	@Test
	public void testmy() throws Exception {
		File file = new File("D:\\pro.txt");	
		List<String> list = StreamUtil.readTest(file);
		for (String str: list) {
			String[] strs = str.split("==");
			Goods good = new Goods();
			for (int i = 0; i < strs.length; i++) {
				
				good.setId(Integer.parseInt(strs[0].trim()));
				
				if(StringUtil.isnumber(strs[0].trim())) {
					good.setId(Integer.parseInt(strs[0].trim()));  //id
				}
				if(StringUtil.hasText(strs[1].trim())) {
					good.setName(strs[1].trim());					//name
				}
				if(StringUtil.hasText(strs[2].trim())) {
					good.setFen(strs[2].trim().replace("¥", ""));
					//在set中  BigDecimal已经经过处理了所以这里 直接放就行
				}
				if(StringUtil.hasText(strs[3].trim())) {
					good.setBai(Integer.parseInt(strs[3].trim().replace("%", "")));
				}
				
			}
			r.opsForList().leftPush("goods_list", good);
//			System.out.println(good);
			
		}
	}
	
	@Test
	public void testset() throws Exception {
		File file = new File("D:\\pro.txt");	
		List<String> list = StreamUtil.readTest(file);
		for (String str: list) {
			String[] strs = str.split("==");
			Goods good = new Goods();
			for (int i = 0; i < strs.length; i++) {
				
				good.setId(Integer.parseInt(strs[0].trim()));
				
				if(StringUtil.isnumber(strs[0].trim())) {
					good.setId(Integer.parseInt(strs[0].trim()));  //id
				}
				if(StringUtil.hasText(strs[1].trim())) {
					good.setName(strs[1].trim());					//name
				}
				if(StringUtil.hasText(strs[2].trim())) {
//					System.out.println(strs[2].trim().replace("¥", "").replace("\\u4e00-\\u9fa5", ""));
					good.setFen(strs[2].trim().replace("¥", ""));
					//在set中  BigDecimal已经经过处理了所以这里 直接放就行
				}
				if(StringUtil.hasText(strs[3].trim())) {
					good.setBai(Integer.parseInt(strs[3].trim().replace("%", "")));
				}
				
			}
			r.opsForZSet().add("goods_zset", good, good.getBai());
//			System.out.println(good);
		}
	}
	
	@Test
	public void teestqu() {
		
		Set set = r.opsForZSet().reverseRange("goods_zset", 0, -1);
		
		for (Object object : set) {
			System.out.println(object);
		}
		
	}
	
	@Test
	public void teestlistqu() {
		
		List list = r.opsForList().range("goods_list", 0, -1);
		for (Object object : list) {
			System.out.println(object);
		}
		
	}
	
	
}
