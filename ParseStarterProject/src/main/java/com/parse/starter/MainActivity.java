/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


  private RecyclerView recyclerView;
  private RecyclerView.LayoutManager layoutManager;
  private  RecyclerAdapter recyclerAdapter;
  private List<Contact> contactList;
  private  ApiInterface apiInterface;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setHasFixedSize(true);

    apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
    retrofit2.Call<List<Contact>> call = apiInterface.getContacts();

    call.enqueue(new Callback<List<Contact>>() {
      @Override
      public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
        contactList = response.body();
        recyclerAdapter = new RecyclerAdapter(contactList);
        recyclerView.setAdapter(recyclerAdapter);
      }

      @Override
      public void onFailure(Call<List<Contact>> call, Throwable t) {

      }
    });

    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}