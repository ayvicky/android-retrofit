package com.parse.starter;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lucky on 5/28/19.
 */

public class Contact {

    @SerializedName("name")
    private String Name;

    @SerializedName("email")
    private String Email;

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }
}
