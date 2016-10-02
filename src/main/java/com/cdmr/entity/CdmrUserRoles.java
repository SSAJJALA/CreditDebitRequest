package com.cdmr.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by student on 10/1/16.
 */

@Entity
@Table(name = "CDMR_USERS_ROLES")
public class CdmrUserRoles {

    @EmbeddedId
    private CdmrUserRolesPK userRoles;

    public CdmrUserRoles() {
    }

    public CdmrUserRolesPK getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(CdmrUserRolesPK userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "CdmrUserRoles{" +
                "userRoles=" + userRoles +
                '}';
    }
}
