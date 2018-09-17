package com.xutaotao.leancloud;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVUser;

@AVClassName("_User")
public class User extends AVUser {

    public boolean getAdmin() {
        return getBoolean("admin");
    }
}
