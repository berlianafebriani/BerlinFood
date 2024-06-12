package com.example.rafood.Activity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.rafood.R;
import com.google.firebase.database.FirebaseDatabase;

public class BaseActivity extends AppCompatActivity {
    FirebaseDatabase database;

    @Override

    //Brs ini memanggil metode OnCreate dari kelas induk AppCompatActivity
    //Diperlukan untuk melakukan inisialisasi dan memastikan bahwa aktivitas diatur dengan benar
    //kode kustom Anda dijalankan
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //membuat instance dari kelas 'FirebaseDatabase'
        //digunakan untuk mengakses dan mengelola db Firebase
        database = FirebaseDatabase.getInstance();

        //mendapat objek 'Window" mewakili jendela yg sedang digunakan
        Window w=getWindow();

        //flag ini memberi tahu sistem Andaroid untuk tdk membatasi layout
        //digunakan membuat aktivitas tampil secara full screen
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}