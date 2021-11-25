package org.query.repository;

import java.util.List;

import org.query.model.entity.T1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("t1Repository")
public interface T1Repository extends JpaRepository<T1, Long> {
	
	@Query(value="select a , s from "
			+ "(select r.a a, r.s s from "
			+ "(SELECT  p.a a, COALESCE(sum(p.x * p.y * p.z ),0) s  FROM "
			+ "(select * from t1 u1 LEFT OUTER JOIN  (select u2.b ,u2.y, u3.c,u3.z from t2 u2, t3 u3) d  "
			+ "on (u1.a < d.b + d.c) ) p group BY p.a ) r "
			+ "ORDER BY s DESC) ex  "
			+ "where rownum <=10 " , nativeQuery = true)
	List <Projection>extractResults();
	
	
	public interface Projection{		
		public Double getA();
		public Double getS() ;
	}
	

}
