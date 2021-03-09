package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@Autowired private JdbcTemplate jdbcTemplate;

	@RequestMapping("/")
	public String index() {
		int result = jdbcTemplate.queryForObject("select count(*) from information_schema.tables", Integer.class);
		return "Greetings from Spring Boot! table_count = " + result;
	}

}
