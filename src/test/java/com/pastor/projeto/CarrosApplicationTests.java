package com.pastor.projeto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pastor.projeto.CarrosApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CarrosApplication.class)
@WebAppConfiguration
public class CarrosApplicationTests {

	@Test
	public void contextLoads() {
	}

}
