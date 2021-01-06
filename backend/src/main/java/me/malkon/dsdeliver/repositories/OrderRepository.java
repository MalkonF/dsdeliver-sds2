package me.malkon.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.malkon.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
