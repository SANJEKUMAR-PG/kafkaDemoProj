package com.kafka.kafkaDemoProj.Repo;

import com.kafka.kafkaDemoProj.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByVname(String vname);


    List<User> findByIage(int iAge);
}
