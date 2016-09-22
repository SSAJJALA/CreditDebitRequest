package com.cdmr.ui;

import com.cdmr.entity.CdmrUsers;
import com.cdmr.persistence.CdmrUsersDao;

/**
 * Created by student on 9/22/16.
 */
public class ValidateUser {
    public String validate(String userID, String passWord) {
        String message = null;
        CdmrUsersDao userDao = new CdmrUsersDao();
        CdmrUsers user = userDao.getUser(userID);
        if (user == null) {
            message = "Invalid user id";
        } else if (passWord.equals(user.getPassWord())) {
            message = "User authenticated";

        } else  {
            message = "Password is incorrect!";
        }

        return message;


    }
}
