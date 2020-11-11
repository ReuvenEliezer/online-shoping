package com.repositories;

import com.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {

    @Query("SELECT u FROM #{#entityName} u WHERE u.account.id = ?1")
    List<User> getByAccountId(Long accountId);
}
