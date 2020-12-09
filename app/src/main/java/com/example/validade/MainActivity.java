package com.example.validade;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
    }

    public void consultar(View view){
        Intent i = new Intent(this, ConsultaActivity.class);
        startActivity(i);
    }

    public void cadastrar(View view){
        Intent i = new Intent(this, CadastroActivity.class);
        startActivity(i);
    }
}