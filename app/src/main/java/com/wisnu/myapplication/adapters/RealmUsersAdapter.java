package com.wisnu.myapplication.adapters;

import android.content.Context;

import com.wisnu.myapplication.model.User;

import io.realm.RealmResults;

/**
 * Created by private on 05/06/2016.
 */
public class RealmUsersAdapter extends RealmModelAdapter<User> {
    public RealmUsersAdapter(Context context, RealmResults<User> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }
}
