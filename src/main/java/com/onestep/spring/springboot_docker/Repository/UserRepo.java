package com.onestep.spring.springboot_docker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onestep.spring.springboot_docker.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
    
}
