package com.se2.easypc.dataAccess.repository;

import com.se2.easypc.dataAccess.model.CPU;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//CPURepository inherits from JpaRepository for communication with database
@Repository
public interface CPURepository extends JpaRepository<CPU, Long> {

}
