package me.malkon.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.malkon.dsdeliver.dto.ProductDto;
import me.malkon.dsdeliver.entities.Product;
import me.malkon.dsdeliver.repositories.ProductRepository;

@Service // registra o componente para ser injetado pelo Spring
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true) // app não vai fazer o locking no bd. Operações ficam mais rápidas
	public List<ProductDto> findAll() {
		List<Product> list = repository.findAllByOrderByNameAsc();
		return list.stream().map(x -> new ProductDto(x)).collect(Collectors.toList());
		// transforma list em stream para fazer operação map. A cada produto na lista
		// instancie como produto dto depois converta para lista

	}

}