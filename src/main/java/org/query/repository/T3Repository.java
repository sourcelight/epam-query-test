package org.query.repository;

import org.query.model.entity.T3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("t3Repository")
public interface T3Repository extends JpaRepository<T3, Long> {

}
