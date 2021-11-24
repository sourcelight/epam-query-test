package org.query.repository;

import java.util.List;

import org.query.model.entity.T1;
import org.query.model.entity.T2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("t2Repository")
public interface T2Repository extends JpaRepository<T2, Long> {
	
	@Query(value="select * from t2" , nativeQuery = true)
	List <T2>test();

}
