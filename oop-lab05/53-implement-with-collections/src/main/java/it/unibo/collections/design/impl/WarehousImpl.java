package it.unibo.collections.design.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import it.unibo.collections.design.api.Product;
import it.unibo.collections.design.api.Warehouse;

public class WarehousImpl implements Warehouse {

    private final Set<Product> products = new LinkedHashSet<>();

    @Override
    public void addProduct(Product p) {
        products.add(p);
    }

    @Override
    public Set<String> allNames() {
        final Set<String> prods = new LinkedHashSet<>();
        for(final Product i : products){
            prods.add(i.getName());
        }
        return prods;
    }

    @Override
    public Set<Product> allProducts() {
        return Set.copyOf(products);
    }

    @Override
    public boolean containsProduct(Product p) {
        return products.contains(p);
    }

    @Override
    public double getQuantity(String name) {
        for(final Product i : products){
            if(i.getName().equals(name)){
                return i.getQuantity();
            }
        }
        return 0;
    }
    
}
