package com.revature.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.entities.Status;

public interface StatusRepo  extends JpaRepository<Status, Integer>{
	Status findBystatusId(int id);
	Status deleteBystatusId(int id);

}
