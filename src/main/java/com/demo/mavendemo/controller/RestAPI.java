package com.demo.mavendemo.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mavendemo.domain.User;
import com.demo.mavendemo.mapper.UserRepository;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

// @RestController 会为该控制器所有处理方法应用消息转换功能
@RestController
//@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
public class RestAPI {

	// @RequestMapping("posts")
	@RequestMapping(value = "posts", method = RequestMethod.GET, produces = "application/json")
	public List<Greeting> greeting(@RequestParam(value = "page", defaultValue = "1") int page) {
		ArrayList<Greeting> list = new ArrayList<Greeting>();
		list.add(new Greeting(1, "hello"));
		return list;
	}

	@Resource
	UserRepository userRepository;

	// @GetMapping
	@RequestMapping(value = "user", method = RequestMethod.GET, produces = "application/json")
	@Transactional(readOnly = true)
	public Page get(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "20") int size, HttpServletResponse response) {
		// 分页并查询
		Page<User> pageInfo = PageHelper.startPage(page, size);
		List<User> users = userRepository.listUser();

		System.out.println("page is:" + page + " size is:" + size);
		// 获取分页信息演示, 实际项目中一般会封装为自己的返回体。
		int pageNum = pageInfo.getPageNum();
		int pageSize = pageInfo.getPageSize();
		long total = pageInfo.getTotal();
		List<User> result = pageInfo.getResult();// 和上面的users结果相同

		response.setIntHeader("X-Total-Page", (int)total);

		return pageInfo;
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json")
	public User getUser(@PathVariable Long id) {

		User user = userRepository.findUserById(id);
		System.out.println(user.getName());
		System.out.println(user.getAddressId());
		System.out.println(user);

		// Map<String, Object> map = new HashMap<>();
		// map.put("name", 6666);
		// map.put("addressId", 1);
		// System.out.println(userRepository.insertUser(map));
		System.out.println("-----------------");
		// User u = new User("insertByUser", 1);
		// System.out.println(userRepository.insertByUser(u));
		// System.out.println(u.getId());

		return user;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User createUser(@RequestParam(value = "name", required = true) String name,
			               @RequestParam(value = "age", required = true) Integer age ) {
		System.out.println("-----------------");
		 User u = new User(name, age);
		 System.out.println(userRepository.insertByUser(u));
		 System.out.println(u.getId());

		return u;
	}

	class Greeting {
		private int id;
		private String content;

		public Greeting(int id, String content) {
			this.id = id;
			this.content = content;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}

}
