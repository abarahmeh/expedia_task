package com.expedia.bean;

import com.expedia.bean.userinfo.Persona;
/**
 * This provides methods to set & get the information for User
 * 
 * @author Abdullah Barahmeh
 * @version 2017-3-11
 */
public class UserInfo {
    private String userId;
    private Persona persona;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }
}
