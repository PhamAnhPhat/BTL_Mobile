package com.example.oucinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.oucinema.model.RapPhim;

import java.util.List;


public class ManageTheater extends AppCompatActivity {

    DBHelper dbHelper;
    ListView lvRap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_theater);
        dbHelper = new DBHelper(ManageTheater.this);

//        lvRap = findViewById(R.id.listViewRapPhim);
//        List<RapPhim> listRap = dbHelper.getRapPhim();
//        ArrayAdapter theaterArrayAdapter = new ArrayAdapter<RapPhim>(ManageTheater.this,R.layout.manage_theater,listRap);
//        lvRap.setAdapter(theaterArrayAdapter);

        // Nơi gọi biến
        ImageView btnMenuList= findViewById(R.id.menu_list);
        ImageView btnAddFilm= findViewById(R.id.manage_add_theater);
        // Tạo Intent
        Intent intent = new Intent(this, NavBarManager.class);
        Intent intentAddTheater = new Intent(this, ManageAddTheater.class);

        // Quay về trang navbar
        btnMenuList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        // Mở trang thêm sửa phim
        btnAddFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentAddTheater);
            }
        });

    }
}
