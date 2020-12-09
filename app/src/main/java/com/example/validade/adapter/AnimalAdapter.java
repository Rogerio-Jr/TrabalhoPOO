package com.example.validade.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.validade.R;
import com.example.validade.model.Animal;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.MyViewHolder> {

    private List<Animal> listaAnimal;

    public AnimalAdapter(List<Animal> lista ) {
        this.listaAnimal = lista;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_animal_adapter, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

       Animal animal = listaAnimal.get(position);
        holder.nome.setText( animal.getNomeAnimal() );
        holder.idade.setText(animal.getIdadeAnimal());
        holder.raca.setText(animal.getRacaAnimal());


    }

    @Override
    public int getItemCount() {
        return this.listaAnimal.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nome;
        TextView idade;
        TextView raca;

        public MyViewHolder(View itemView) {
            super(itemView);

            nome = itemView.findViewById(R.id.nome);
            idade = itemView.findViewById(R.id.idade);
            raca = itemView.findViewById(R.id.raca);

        }
    }

}

