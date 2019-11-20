package com.ncbx.app;

import com.personal.business.BusinessApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusinessApplication.class)
public class OrderInputServiceTest {

	static {
		System.setProperty("es.set.netty.runtime.available.processors", "false");
	}

	@Test
    public void inputDate(){
	    long startTime = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - startTime);
    }

}
