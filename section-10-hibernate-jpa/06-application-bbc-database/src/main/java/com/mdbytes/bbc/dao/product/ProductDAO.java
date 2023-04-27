package com.mdbytes.bbc.dao.product;

import com.mdbytes.bbc.dao.DAO;
import com.mdbytes.bbc.entity.Product;

public interface ProductDAO extends DAO<Product> {
    boolean updateProductPrice(Product product);

    boolean updateProductName(String productUrl);
}
