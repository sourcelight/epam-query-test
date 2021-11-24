package org.query.repository;

import java.util.List;

import org.query.model.entity.T1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("t1Repository")
public interface T1Repository extends JpaRepository<T1, Long> {
	
	@Query(value="SELECT u1.a a, COALESCE(sum(u1.x * d.y * d.z ),0) s  FROM t1 u1 "			
			+ "LEFT OUTER JOIN  "
			+ "(select u2.b ,u2.y, u3.c,u3.z from t2 u2, t3 u3) d "
			+ "on (u1.a < d.b + d.c) "
			+ "where ROWNUM <= 10  "
			+ "group BY u1.a  "
			+ "ORDER BY s DESC" , nativeQuery = true)
	List <Projection>extractResults();
	
	
	public interface Projection{
		
		public Double getA();
		public Double getS() ;
	}
	

}
