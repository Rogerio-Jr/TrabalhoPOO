package com.example.validade.helper;

import com.example.validade.model.Animal;

import java.util.List;

public interface IAnimalDAO {

    public boolean salvar(Animal animal);
    public boolean atualizar(Animal animal);
    public boolean deletar(Animal animal);
    public List<Animal> listar();

}
