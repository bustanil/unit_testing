package com.skyworx.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

import com.skyworx.shop.model.Product;

public class TestCollection {
	public static void main(String[] args) {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(3L, "test3", 12d, 1));
		products.add(new Product(1L, "test1", 13d, 1));
		products.add(new Product(2L, "test2", 15d, 1));
		products.add(new Product(5L, "test5", 81d, 1));
		products.add(new Product(4L, "test4", 13d, 1));
		products.add(new Product(7L, "test7", 12d, 1));
		products.add(new Product(8L, "test8", 15d, 1));
		products.add(new Product(6L, "test6", 110d, 1));
		
		Comparator<Product> byPrice = new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				return o1.getPrice().compareTo(o2.getPrice());
			}
		};
		
		Collections.sort(products, byPrice);
		
		for (Product product : products) {
			System.out.println(product.getId() + " " + product.getPrice());
		}
	}
	
	
}

class MoreThanFive implements Predicate {

	@Override
	public boolean evaluate(Object object) {
		Integer i = (Integer) object;
		return i > 5;
	}
	
}
