package com.business.user.repository;

import com.business.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,String> {

    @Query(value="Select email from user  where  email = ?1 ",nativeQuery = true)
    String findByEmail(String email);

    @Query(value="Select * from user  where name = ?1 ",nativeQuery = true)
    User findByUser(String name);

}
