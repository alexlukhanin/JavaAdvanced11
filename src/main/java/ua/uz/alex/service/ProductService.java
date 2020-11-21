package ua.uz.alex.service;

import ua.uz.alex.domain.Product;
import ua.uz.alex.shared.AbstractCRUD;

import java.util.Map;

public interface ProductService extends AbstractCRUD<Product> {

    public Map<Integer, Product> readAllMap();

}
