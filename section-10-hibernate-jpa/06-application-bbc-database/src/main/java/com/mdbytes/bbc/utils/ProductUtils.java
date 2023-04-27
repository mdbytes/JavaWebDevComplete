package com.mdbytes.bbc.utils;

import com.mdbytes.bbc.dao.product.ProductDAO;
import com.mdbytes.bbc.dao.store.StoreDAO;
import com.mdbytes.bbc.entity.Product;
import com.mdbytes.bbc.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductUtils implements Utils {

    private ProductDAO productDAO;
    private StoreDAO storeDAO;

    @Autowired
    public ProductUtils(ProductDAO productDAO, StoreDAO storeDAO) {
        this.productDAO = productDAO;
        this.storeDAO = storeDAO;
    }

    @Override
    public void createManyGetAll() {
        Store store = storeDAO.get(1);
        System.out.println("Creating product objects...");

        Product productOne = new Product("https://webscraper.io/test-sites/e-commerce/allinone/product/566", "Acer Aspire ES1-572 Black, 15.6\" HD, Core i5-7200U, 4GB, 500GB, Linux");
        productOne.setStore(store);

        Product productTwo = new Product("https://webscraper.io/test-sites/e-commerce/allinone/product/508", "IPS, Dual-Core 1.2GHz, 8GB, Android 4.3");
        productTwo.setStore(store);

        Product productThree = new Product("https://webscraper.io/test-sites/e-commerce/allinone/product/579", "Lenovo ThinkPad L460, 14\" FHD IPS, Core i7-6600U, 8GB, 256GB SSD, Windows 10 Pro");
        productThree.setStore(store);

        Product productFour = new Product("https://webscraper.io/test-sites/e-commerce/allinone/product/544", "Asus ROG Strix SCAR Edition GL503VM-ED115T, 15.6\" FHD 120Hz, Core i7-7700HQ, 16GB, 256GB");
        productFour.setStore(store);

        System.out.println("Saving...");
        productDAO.save(productOne);
        productDAO.save(productTwo);
        productDAO.save(productThree);
        productDAO.save(productFour);

        List<Product> products = productDAO.getAll();

        System.out.println("Retrieved products");
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    @Override
    public void updateOne() {
        Product product = productDAO.get(1);
        System.out.println(product.toString());

        product.setProductName("Pickles");
        productDAO.update(product);

        Product revisedProduct = productDAO.get(1);

        System.out.println("Revised from DB:");
        System.out.println(revisedProduct.toString());

    }

    @Override
    public void deleteOne() {
        System.out.println("Deleting product 2 ...");
        productDAO.delete(2);
        System.out.println("Product 2 deleted");
    }

    @Override
    public void deleteAll() {
        System.out.println("Deleting all products");
        productDAO.deleteAll();
        System.out.println("All products deleted.");
    }
}
