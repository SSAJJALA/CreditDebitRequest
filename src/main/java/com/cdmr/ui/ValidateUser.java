package com.cdmr.ui;

import com.cdmr.entity.CdmrUsers;
import com.cdmr.persistence.CdmrUsersDao;
import org.apache.log4j.Logger;

/**
 * Created by student on 9/22/16.
 */
public class ValidateUser {

    private final Logger logger = Logger.getLogger(this.getClass());

    public String validate(String userID, String passWord) {
        String message = null;
        CdmrUsersDao userDao = new CdmrUsersDao();
        CdmrUsers user = userDao.getUser(userID);
        if (user == null) {
            message = "Invalid user id";
            logger.error(message);
        } else if (passWord.equals(user.getPassWord())) {
            message = "User authenticated";
            logger.info(message);

        } else  {
            message = "Password is incorrect!";
            logger.error(message);
        }

        return message;


    }
}
