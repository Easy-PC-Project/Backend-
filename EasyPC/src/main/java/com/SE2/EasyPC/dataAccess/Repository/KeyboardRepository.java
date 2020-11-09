package com.se2.easypc.dataAccess.repository;
import com.se2.easypc.dataAccess.model.Keyboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//KeyboardRepository inherits from JpaRepository for communication with database
@Repository
public interface KeyboardRepository extends JpaRepository<Keyboard, Long> {

}