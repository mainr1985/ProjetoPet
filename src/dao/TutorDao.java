/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Tutor;

/**
 *
 * @author Maíra
 */
public interface TutorDao {
    void insert(Tutor obj);
    void update (Tutor obj);
    void deletePorId(Integer id);
    Tutor buscarPorId(Integer id);
    List<Tutor>findAll();
}
