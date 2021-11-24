package org.query.calc;

import org.junit.jupiter.api.Test;
import org.query.model.entity.T1;
import org.query.repository.T1Repository;
import org.query.repository.T2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QueryTestTaskApplicationTests {
	
	@Autowired
	@Qualifier("t1Repository")
	private T1Repository t1Repository;
	
	@Autowired
	@Qualifier("t2Repository")
	private T2Repository t2Repository;

	@Test
	void contextLoads() {
		
		System.out.println("test");
		T1 t1 = new T1();
		t1Repository.save(t1);
		System.out.println("test dopo ");
	}

}
