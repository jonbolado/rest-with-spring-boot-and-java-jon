package com.curso.erudio.rest_spring_aws.repositories;

import com.curso.erudio.rest_spring_aws.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.userName =:userName")
    //User findByUsername(@Param("userName") String userName);
    Optional<User> findByUsername(@Param("userName") String userName);

}
