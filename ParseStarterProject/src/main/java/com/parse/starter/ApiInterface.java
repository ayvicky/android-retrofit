package com.parse.starter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by lucky on 5/28/19.
 */

public interface ApiInterface {

    @POST("readcontacts.php")
    Call<List<Contact>> getContacts();
}
