package com.example.validade;

import java.util.List;

public interface IAnimalDAO {

    public boolean salvar(Animal animal);
    public boolean atualizar(Animal animal);
    public boolean deletar(Animal animal);
    public List<Animal> listar();

}
