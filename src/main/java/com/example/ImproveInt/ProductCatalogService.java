package com.example.ImproveInt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCatalogService {
	private static Map<String, Product> productCatalog = new HashMap<>();

	@GetMapping("/product/{id}")
	public Product sendDetails(@PathVariable String id) {
		Product ok = new Product();
		return productCatalog.getOrDefault(id, ok);
	}

	@PostMapping("/product")
	public String addProduct(@RequestBody Product product) {
		productCatalog.put(product.getId(), product);
		return "Done";
	}

	@GetMapping("/product")
	public List<Product> getProductList() {
		return new ArrayList<Product>(productCatalog.values());
	}

	@PutMapping("/product")
	public String updateProduct(@RequestBody Product product) {
		productCatalog.put(product.getId(), product);
		return "product updated successfully";
	}

	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable String id) {
		productCatalog.remove(id);
		return "product deleted successfully";
	}
}
