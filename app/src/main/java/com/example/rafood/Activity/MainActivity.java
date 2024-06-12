package com.example.rafood.Activity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.rafood.Adapter.CategoryAdapter;
import com.example.rafood.Domain.Category;
import com.example.rafood.R;
import com.example.rafood.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        initCategory();




        setContentView(binding.getRoot());



    }


    private void initCategory() {
        DatabaseReference myRef=database.getReference("Category");

        ArrayList<Category> list=new ArrayList<>();




        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {



                if(snapshot.exists()){
                    for (DataSnapshot issue:snapshot.getChildren()){
                        list.add(issue.getValue(Category.class));
                    }

                    if(list.size() > 0) {
                        binding.categoryView.setLayoutManager(new GridLayoutManager(MainActivity.this,
                                3));
                        binding.categoryView.setAdapter(new CategoryAdapter(list));
                        binding.categoryView.setHasFixedSize(true);
                        binding.pgMain.setVisibility(View.GONE);

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}