package com.mdbytes.bbc.utils;

import com.mdbytes.bbc.dao.system.SystemDAO;
import com.mdbytes.bbc.entity.SystemUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
public class SystemUtils implements Utils {

    private SystemDAO systemDAO;

    @Autowired
    public SystemUtils(SystemDAO systemDAO) {
        this.systemDAO = systemDAO;
    }

    @Override
    public void createManyGetAll() {
        SystemUpdate updateOne = new SystemUpdate(Date.valueOf(LocalDate.now()), "Updated prices");
        SystemUpdate updateTwo = new SystemUpdate(Date.valueOf(LocalDate.now()), "Sent email notifications");

        systemDAO.save(updateOne);
        systemDAO.save(updateTwo);

        List<SystemUpdate> updates = systemDAO.getAll();

        System.out.println("Printing updates");
        for (SystemUpdate update : updates) {
            System.out.println(update.toString());
        }
    }

    @Override
    public void updateOne() {
        SystemUpdate update = systemDAO.get(1);
        System.out.println(update.toString());
        update.setUpdateDescription("Updated prices AGAIN!");
        systemDAO.update(update);
        SystemUpdate revisedUpdate = systemDAO.get(1);
        System.out.println("revised from db");
        System.out.println(revisedUpdate.toString());
    }

    @Override
    public void deleteOne() {
        System.out.println("Deleting update 2...");
        systemDAO.delete(2);
        System.out.println("Update 2 deleted");
    }

    @Override
    public void deleteAll() {
        System.out.println("Deleting all updates...");
        systemDAO.deleteAll();
        System.out.println("All updates deleted.");
    }
}
