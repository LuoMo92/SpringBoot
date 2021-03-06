package com.luomo.study.spring.boot;

import com.google.gson.Gson;
import com.luomo.study.spring.boot.chapter3.repository.UserRepository;
import com.luomo.study.spring.boot.chapter3.service.UserService;
import com.luomo.study.spring.boot.chapter3.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setUp() {
		// 准备，清空user表
		userService.deleteAllUsers();
	}

	@Test
	public void test() throws Exception {
		// 插入5个用户
		userService.create("a", 1);
		userService.create("b", 2);
		userService.create("c", 3);
		userService.create("d", 4);
		userService.create("e", 5);
		// 查数据库，应该有5个用户
		Assert.assertEquals(5, userService.getAllUsers().intValue());
		// 删除两个用户
		userService.deleteByName("a");
		userService.deleteByName("e");
		// 查数据库，应该有5个用户
		Assert.assertEquals(3, userService.getAllUsers().intValue());
	}

	@Test
	public void test2() throws Exception {
		// 创建10条记录
		userRepository.save(new User("AAA", 10));
		userRepository.save(new User("BBB", 20));
		userRepository.save(new User("CCC", 30));
		userRepository.save(new User("DDD", 40));
		userRepository.save(new User("EEE", 50));
		userRepository.save(new User("FFF", 60));
		userRepository.save(new User("GGG", 70));
		userRepository.save(new User("HHH", 80));
		userRepository.save(new User("III", 90));
		userRepository.save(new User("JJJ", 100));

		// 测试findAll, 查询所有记录
		Assert.assertEquals(10, userRepository.findAll().size());

		// 测试findByName, 查询姓名为FFF的User
		Assert.assertTrue(userRepository.findByName("FFF").getAge()==60);

		Gson gson = new Gson();

		System.out.println(gson.toJson(userRepository.findAge("FFF")));

		// 测试findAge, 查询姓名为FFF的User
		Assert.assertTrue(userRepository.findAge("FFF") == 60);

		// 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
		Assert.assertEquals("FFF",userRepository.findByNameAndAge("FFF", 60).getName());

		// 测试删除姓名为AAA的User
		userRepository.delete(userRepository.findByName("AAA"));

		// 测试findAll, 查询所有记录, 验证上面的删除是否成功
		Assert.assertEquals(9, userRepository.findAll().size());
	}
}
