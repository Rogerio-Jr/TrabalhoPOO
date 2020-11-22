package com.example.validade;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.google.android.material.textfield.TextInputEditText;

public class CadastroActivity extends AppCompatActivity {

    private TextInputEditText editNome;
    private TextInputEditText editIdade;
    private TextInputEditText editRaca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        editNome = findViewById(R.id.editNome);
        editIdade = findViewById(R.id.editIdade);
        editRaca = findViewById(R.id.editRaca);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_animal, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){

            case R.id.Salvar:

            AnimaisDAO animaisDAO = new AnimaisDAO(getApplicationContext());

            String nomeAnimal = editNome.getText().toString();
            String idadeAnimal = editIdade.getText().toString();
            String racaAnmal = editRaca.getText().toString();

            Animal animal = new Animal();
            animal.setNomeAnimal(nomeAnimal);
            animal.setIdadeAnimal(idadeAnimal);
            animal.setRacaAnimal(racaAnmal);
            animaisDAO.salvar( animal );
            finish();
            break;
        }

        return super.onOptionsItemSelected(item);
    }


}