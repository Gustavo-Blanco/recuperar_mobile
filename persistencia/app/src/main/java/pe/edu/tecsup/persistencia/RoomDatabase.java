package pe.edu.tecsup.persistencia;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

import pe.edu.tecsup.persistencia.dao.PersonaDao;
import pe.edu.tecsup.persistencia.entity.PersonaEntity;

@Database(entities = PersonaEntity.class, version = 1)
public abstract class RoomDatabase extends androidx.room.RoomDatabase {
    private static final String NOMBRE_DB = "room_database";

    private static RoomDatabase instance;

    public static synchronized RoomDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), RoomDatabase.class, NOMBRE_DB)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;

    }

    public abstract PersonaDao personaDao();

}
