package com.example.validade.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.validade.helper.DbHelper;
import com.example.validade.helper.IAnimalDAO;
import com.example.validade.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimaisDAO implements IAnimalDAO {

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public AnimaisDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Animal animal) {

        ContentValues cv = new ContentValues();
        cv.put("nome", animal.getNomeAnimal());
        cv.put("idade", animal.getIdadeAnimal());
        cv.put("raca", animal.getRacaAnimal());

        try{
            escreve.insert(DbHelper.TABELA_ANIMAIS, null, cv);
            Log.i("INFO", "Animal salvo com sucesso");
        }catch (Exception e){
            Log.i("INFO", "Animal errooooo");

            return false;

        }

        return true;
    }

    @Override
    public boolean atualizar(Animal animal) {
        return false;
    }

    @Override
    public boolean deletar(Animal animal) {
        return false;
    }

    @Override
    public List<Animal> listar() {


        List<Animal> animais = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_ANIMAIS + " ;";
        Cursor c = le.rawQuery(sql, null);

        while (c.moveToNext()){
            Animal animal = new Animal();

            Long id = c.getLong(c.getColumnIndex("id"));
            String nomeAnimal = c.getString(c.getColumnIndex("nome"));
            String idadeAnimal = c.getString(c.getColumnIndex("idade"));
            String racaAnimal = c.getString(c.getColumnIndex("raca"));

            animal.setId(id);
            animal.setNomeAnimal(nomeAnimal);
            animal.setIdadeAnimal(idadeAnimal);
            animal.setRacaAnimal(racaAnimal);

            animais.add(animal);

        }
        return animais;
    }
}
