package com.kafka.kafkaDemoProj.Repo;

import com.kafka.kafkaDemoProj.Model.UserExt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserExtRepo extends JpaRepository<UserExt,Integer> {
}
