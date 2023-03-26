/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Afericao;

/**
 *
 * @author Maíra
 */
public interface AfericaoDao {
    
    void insert(Afericao obj);
    void update (Afericao obj);
    void deletePorId(Integer id);
    Afericao buscarPorId(Integer id);
    List<Afericao>findAll();
}

