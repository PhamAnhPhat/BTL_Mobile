package com.example.oucinema;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.oucinema.adapter.SeatAdapter;
import com.example.oucinema.adapter.UserAdapter;
import com.example.oucinema.model.Ghe;
import com.example.oucinema.model.User;

import java.util.ArrayList;


public class ManageUser extends AppCompatActivity {
    DBHelper dbHelper;
    ListView lvUser;
    SearchView tk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_user);
        dbHelper = new DBHelper(ManageUser.this);
        tk= findViewById(R.id.manage_search_user);
        lvUser = findViewById(R.id.listViewUser);
        String user_id = getIntent().getStringExtra("user_id");
        String user_name = getIntent().getStringExtra("user_name");
        if(user_id !=null)
            Log.d("test","user id from ticket "+user_id);
        else
            Log.d("test","error ");
        ArrayList<User> listUser = dbHelper.getAllUser();

        UserAdapter userAdapter = new UserAdapter(this,R.layout.list_user,listUser);
        lvUser.setAdapter(userAdapter);

        tk.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("MyActivity", "Before filtering: " + listUser.size() + " items");
                userAdapter.getFilter().filter(newText);
                Log.d("MyActivity", "After filtering: " + userAdapter.getCount() + " items");
                return true;
            }
        });
        // Nơi gọi biến
        ImageView btnMenuList= findViewById(R.id.menu_list);
        ImageView btnAddUser= findViewById(R.id.manage_add_user);
        // Tạo Intent
        Intent intent = new Intent(this, NavBarManager.class);
        Intent intentAddUser = new Intent(this, ManageAddUser.class);

        // Quay về trang navbar
        btnMenuList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("user_name",user_name);
                intent.putExtra("user_id",user_id);
                startActivity(intent);
            }
        });
        // Mở trang thêm sửa phim
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentAddUser.putExtra("user_id",user_id);
                intentAddUser.putExtra("user_name",user_name);
                startActivity(intentAddUser);
            }
        });

        lvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User u = listUser.get(i);
                int id = u.getId();
                String name = u.getHoTen();
                String phone = u.getPhoneNumber();
                String email = u.getEmail();
                int role = u.getRoleID().getId();
                intentAddUser.putExtra("user_names",user_name);
                Log.d("MyActivity", "Before filtering: " +user_name);
                intentAddUser.putExtra("user_id",user_id);
                intentAddUser.putExtra("user_id2",id);
                intentAddUser.putExtra("user_name",name);
                intentAddUser.putExtra("user_phone",phone);
                intentAddUser.putExtra("user_email",email);
                intentAddUser.putExtra("user_role",role);
                intentAddUser.putExtra("user_username",u.getUsername());
                intentAddUser.putExtra("user_pwd",u.getPassword());
                startActivity(intentAddUser);
            }
        });

        BottomNavigationView btnavigation = findViewById(R.id.bottomNavigationView);
        // Bottom Navigtaion View
        btnavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_manager_Film:
                        Intent intent = new Intent(ManageUser.this, ManageFilm.class);
                        intent.putExtra("user_name",user_name);
                        intent.putExtra("user_id",user_id);
                        startActivity(intent);
                        break;
                    case R.id.nav_manager_t:
                        Intent intent_ticket = new Intent(ManageUser.this, ManageTicket.class);
                        intent_ticket.putExtra("user_name",user_name);
                        intent_ticket.putExtra("user_id",user_id);
                        startActivity(intent_ticket);
                        break;

                    case R.id.nav_manager_static:
                        Intent intent_setfilm = new Intent(ManageUser.this, Statis.class);
                        intent_setfilm.putExtra("user_id",user_id);
                        intent_setfilm.putExtra("user_name",user_name);
                        startActivity(intent_setfilm);
                        break;

                    case R.id.nav_manager_user:
                        Intent intent_user = new Intent(ManageUser.this, ManageUser.class);
                        intent_user.putExtra("user_id",user_id);
                        intent_user.putExtra("user_name",user_name);
                        startActivity(intent_user);

                }
                return false;
            }
        });

    }
}
