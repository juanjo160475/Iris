package com.vasallo.iris.modelo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface UsuarioDao {
    @Query("SELECT * FROM usuario")
    List<Usuario> getAll();

    @Query("SELECT * FROM Usuario WHERE id IN (:userIds)")
    List<Usuario> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM Usuario WHERE nombre LIKE :nombre AND " +
            "apellido LIKE :apellido LIMIT 1")
    Usuario findByName(String nombre, String apellido);

    @Insert
    void insertAll(Usuario... users);

    @Delete
    void delete(Usuario user);
}
