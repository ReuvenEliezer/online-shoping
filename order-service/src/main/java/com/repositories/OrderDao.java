package com.repositories;

import com.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Long> {

    @Query("SELECT u FROM #{#entityName} u WHERE u.userId = ?1")
    List<Order> getByUserId(Long userId);

}
