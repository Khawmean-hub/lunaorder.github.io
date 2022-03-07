package com.kosign.luna;

import com.kosign.luna.repository.OrderRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
class LunaApplicationTests {

	@Autowired
	OrderRepository OrderRepository;

	@Test
	void contextLoads() {
		Pageable pageable = PageRequest.of(0, 10);
		OrderRepository.findByPage("",pageable).forEach(x->System.err.println(x.customrName()));
		//OrderRepository.findByPage(name, pageable)
	}

}
