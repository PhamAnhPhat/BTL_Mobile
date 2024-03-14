package com.example.oucinema;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.oucinema.model.Role;
import com.example.oucinema.model.User;

public class RegisterCustomer extends AppCompatActivity {

    Button btnRegist;
    EditText hoTenKH,sdtKH,emailKH,username,password;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_customer);
        dbHelper = new DBHelper(RegisterCustomer.this);

        // Nơi gọi biến
        ImageView btnReturnDangNhap= findViewById(R.id.btnquaylaidangnhap);
        btnRegist = findViewById(R.id.btnXacNhanDangKy);
        hoTenKH = findViewById(R.id.textHoTenKhachHangDangKy);
        sdtKH = findViewById(R.id.textSDTDangKy);
        emailKH = findViewById(R.id.textEmail);
        username = findViewById(R.id.textTaiKhoanDangKy);
        password = findViewById(R.id.textMatKhauDangKy);


        // Tạo Intent
        Intent intent = new Intent(this, MainActivity.class);

        // Quay về trang chủ
        btnReturnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User  u = null;
                Role r = new Role(-1,"1");
                try {
                   u = new User(-1,hoTenKH.getText().toString(),sdtKH.getText().toString(),emailKH.getText().toString(),username.getText().toString(),password.getText().toString(),r);
                }
                catch (Exception e){
                    Toast.makeText(RegisterCustomer.this,"ERROR",Toast.LENGTH_LONG).show();
                }
                dbHelper = new DBHelper(RegisterCustomer.this);
                boolean b = dbHelper.addUser(u);

            }
        });

    }
}