package com.wisnu.myapplication.activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;

import com.wisnu.myapplication.R;
import com.wisnu.myapplication.adapters.RealmUsersAdapter;
import com.wisnu.myapplication.adapters.UsersAdapter;
import com.wisnu.myapplication.app.Prefs;
import com.wisnu.myapplication.model.User;
import com.wisnu.myapplication.realm.RealmController;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private UsersAdapter adapter;
    private Realm realm;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = (RecyclerView) findViewById(R.id.recycler);

        this.realm = RealmController.with(this).getRealm();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupRecycler();

        if (!Prefs.with(this).getPreLoad()) {
            setRealmData();
        }

        RealmController.with(this).refresh();
        setRealmAdapter(RealmController.with(this).getUsers());

    }

    public void setRealmAdapter(RealmResults<User> books) {
        RealmUsersAdapter realmAdapter = new RealmUsersAdapter(this.getApplicationContext(), books, true);
        adapter.setRealmAdapter(realmAdapter);
        adapter.notifyDataSetChanged();
    }



    private void setRealmData() {

        ArrayList<User> users = new ArrayList<>();

        User user = new User();
        user.setId(1+System.currentTimeMillis());
        user.setNama("wisnu");
        user.setAhli("bangunan");
        user.setDaerah("sleman");
        user.setNoHp("082151155541");
        users.add(user);

        user = new User();
        user.setId(2+System.currentTimeMillis());
        user.setNama("andi");
        user.setAhli("listrik");
        user.setDaerah("kulonprogo");
        user.setNoHp("04132323222");
        users.add(user);

        user = new User();
        user.setId(3+System.currentTimeMillis());
        user.setNama("andi");
        user.setAhli("listrik");
        user.setDaerah("kulonprogo");
        user.setNoHp("04132323222");
        users.add(user);

        user = new User();
        user.setId(4+System.currentTimeMillis());
        user.setNama("andi");
        user.setAhli("listrik");
        user.setDaerah("kulonprogo");
        user.setNoHp("04132323222");
        users.add(user);

        user = new User();
        user.setId(5+System.currentTimeMillis());
        user.setNama("andi");
        user.setAhli("listrik");
        user.setDaerah("kulonprogo");
        user.setNoHp("04132323222");
        users.add(user);

        user = new User();
        user.setId(6+System.currentTimeMillis());
        user.setNama("andi");
        user.setAhli("listrik");
        user.setDaerah("kulonprogo");
        user.setNoHp("04132323222");
        users.add(user);

        user = new User();
        user.setId(7+System.currentTimeMillis());
        user.setNama("andi");
        user.setAhli("listrik");
        user.setDaerah("kulonprogo");
        user.setNoHp("04132323222");
        users.add(user);

        user = new User();
        user.setId(8+System.currentTimeMillis());
        user.setNama("andi");
        user.setAhli("listrik");
        user.setDaerah("kulonprogo");
        user.setNoHp("04132323222");
        users.add(user);

        user = new User();
        user.setId(9+System.currentTimeMillis());
        user.setNama("andi");
        user.setAhli("listrik");
        user.setDaerah("kulonprogo");
        user.setNoHp("04132323222");
        users.add(user);

        user = new User();
        user.setId(10+System.currentTimeMillis());
        user.setNama("andi");
        user.setAhli("listrik");
        user.setDaerah("kulonprogo");
        user.setNoHp("04132323222");
        users.add(user);

        user = new User();
        user.setId(11+System.currentTimeMillis());
        user.setNama("andi");
        user.setAhli("listrik");
        user.setDaerah("kulonprogo");
        user.setNoHp("04132323222");
        users.add(user);

        for (User b : users) {
            realm.beginTransaction();
            realm.copyToRealm(b);
            realm.commitTransaction();
        }
        Prefs.with(this).setPreLoad(true);
    }

    private void setupRecycler() {
        recycler.setHasFixedSize(true);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(layoutManager);

        adapter = new UsersAdapter(this);
        recycler.setAdapter(adapter);
    }


}
