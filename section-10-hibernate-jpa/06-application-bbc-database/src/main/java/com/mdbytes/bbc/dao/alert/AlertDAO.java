package com.mdbytes.bbc.dao.alert;

import com.mdbytes.bbc.dao.DAO;
import com.mdbytes.bbc.entity.Alert;

public interface AlertDAO extends DAO<Alert> {

    int sendAlertNotifications();
}
