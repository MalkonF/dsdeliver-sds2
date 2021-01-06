package me.malkon.dsdeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import me.malkon.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products "
			+ "WHERE obj.status = 0 ORDER BY obj.moment ASC")
	List<Order> findOrdersWithProducts();
}
/*
 * Busca pedidos pendentes do mais antigo para o mais recente. A query é feita
 * usando jpql, linguagem de consulta do JPA. obj é o apelido(alias). Order é a
 * classe. JOIN FETCH faz o inner join. obj.products - products é a lista de
 * prod que está na classe Order.
 */
