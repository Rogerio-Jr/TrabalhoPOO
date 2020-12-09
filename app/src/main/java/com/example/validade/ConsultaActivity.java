package com.example.validade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ConsultaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AnimalAdapter animalAdapter;
    private List<Animal> listaDeAnimais = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

       recyclerView = findViewById(R.id.recyclerview);



       recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Log.i("clique", "onItemClick");
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            Log.i("clique", "onlongClick");
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
       );
    }

    @Override
    protected void onStart() {

        carregarListanimais();

        super.onStart();
    }

    public void carregarListanimais(){

        AnimaisDAO animaisDAO = new AnimaisDAO(getApplicationContext());
        listaDeAnimais = animaisDAO.listar();


        animalAdapter = new AnimalAdapter(listaDeAnimais);


        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getApplicationContext() );
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter( animalAdapter);

    }
}