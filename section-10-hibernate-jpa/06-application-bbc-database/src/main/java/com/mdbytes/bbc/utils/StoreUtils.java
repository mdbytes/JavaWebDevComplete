package com.mdbytes.bbc.utils;

import com.mdbytes.bbc.dao.store.StoreDAO;
import com.mdbytes.bbc.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StoreUtils implements Utils {

    private StoreDAO storeDAO;

    @Autowired
    public StoreUtils(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }

    @Override
    public void createManyGetAll() {
        System.out.println("Creating store objects...");
        Store storeOne = new Store("Webscraper API", "https://webscraper.io", "h4.pull-right.price", "p.description");
        Store storeTwo = new Store("Webscraper API Part Two", "https://webscraper.io", "h4.pull-right.price", "p.description");

        storeDAO.save(storeOne);
        storeDAO.save(storeTwo);

        List<Store> stores = storeDAO.getAll();

        System.out.println("Printing all stores");
        for (Store store : stores) {
            System.out.println(store.toString());
        }
    }

    @Override
    public void updateOne() {
        Store store = storeDAO.get(1);
        System.out.println(store.toString());

        store.setStoreName("Pickles API Store");
        storeDAO.update(store);

        Store revisedStore = storeDAO.get(1);

        System.out.println("Revised from DB:");
        System.out.println(revisedStore.toString());

    }

    @Override
    public void deleteOne() {
        System.out.println("Deleting store 2 ...");
        storeDAO.delete(2);
        System.out.println("Store 2 deleted");
    }

    @Override
    public void deleteAll() {
        System.out.println("Deleting all stores");
        storeDAO.deleteAll();
        System.out.println("All stores deleted.");
    }
}
