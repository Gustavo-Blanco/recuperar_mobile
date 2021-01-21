package pe.edu.tecsup.persistencia.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import pe.edu.tecsup.persistencia.entity.PersonaEntity;

@Dao
public interface PersonaDao {

    @Query("select * from persona")
    List<PersonaEntity> selectAll();

    @Insert
    void insert(PersonaEntity personaEntity);

    @Update
    void update(PersonaEntity personaEntity);

    @Delete
    void delete(PersonaEntity personaEntity);
}
