package test.lzb.web.boss;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.novel.web.BossServerApplication;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = BossServerApplication.class)
public class ApplicationTest {

	@Autowired
	private RestTemplate restTemplate;
	
    @Test
    public void testDataSourceTwo() {

        System.out.println(restTemplate.getForObject("http://localhost:8080/service-bank/getProperties",String.class));
 
    }
}
