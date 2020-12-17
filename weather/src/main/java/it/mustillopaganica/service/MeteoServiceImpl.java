/**
 * 
 */
package it.mustillopaganica.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import it.mustillopaganica.model.MeteoClass;

/**
 * @author rbtms
 *
 */
public class MeteoServiceImpl {
	private static Map<Integer, MeteoClass> productRepo = new HashMap<>();
		
		public MeteoServiceImpl() {
			MeteoClass honey = new MeteoClass();
			
		}
		
/*		@Override
		public void createProduct(Product product) {
			if(productRepo.containsKey(product.getId())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Existing id...");
			}
			productRepo.put(product.getId(), product);
		}

		@Override
		public Collection<Product> getProducts() {
			return productRepo.values();
		}
*/		
}
