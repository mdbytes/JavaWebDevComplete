package com.mdbytes.bbc.utils;

import com.mdbytes.bbc.dao.alert.AlertDAO;
import com.mdbytes.bbc.dao.product.ProductDAO;
import com.mdbytes.bbc.dao.user.UserDAO;
import com.mdbytes.bbc.entity.Alert;
import com.mdbytes.bbc.entity.Product;
import com.mdbytes.bbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlertUtils implements Utils {

    private UserDAO userDAO;
    private ProductDAO productDAO;
    private AlertDAO alertDAO;

    @Autowired
    public AlertUtils(UserDAO userDAO, ProductDAO productDAO, AlertDAO alertDAO) {
        this.userDAO = userDAO;
        this.productDAO = productDAO;
        this.alertDAO = alertDAO;
    }

    @Override
    public void createManyGetAll() {
        User user = userDAO.get(1);
        Product product = productDAO.get(1);
        Alert alert = new Alert();
        alert.setUser(user);
        alert.setProduct(product);
        alert.setAlertPrice(0.0);

        Alert alertTwo = new Alert();
        alertTwo.setUser(user);
        alertTwo.setProduct(product);
        alertTwo.setAlertPrice(50.0);

        alertDAO.save(alert);
        alertDAO.save(alertTwo);

        List<Alert> alerts = alertDAO.getAll();

        System.out.println("Printing all alerts");
        for (Alert currentAlert : alerts) {
            System.out.println(currentAlert.toString());
        }
    }

    @Override
    public void updateOne() {
        Alert alert = alertDAO.get(1);
        System.out.println(alert.toString());

        alert.setAlertPrice(25.0);
        alertDAO.update(alert);

        Alert revisedAlert = alertDAO.get(1);

        System.out.println("Revised from DB:");
        System.out.println(revisedAlert.toString());

    }

    @Override
    public void deleteOne() {
        System.out.println("Deleting alert 2 ...");
        alertDAO.delete(2);
        System.out.println("Alert 2 deleted");
    }

    @Override
    public void deleteAll() {
        System.out.println("Deleting all alerts");
        alertDAO.deleteAll();
        System.out.println("All alerts deleted.");
    }
}
