package com.vasallo.iris.modelo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Usuario.class}, version = 1)
public abstract  class DbSqlLite extends RoomDatabase {
    public abstract UsuarioDao userDao();

/*
private static  final  int DATABASE_VERSION =1;
private static final String DATABASE_NOMBRE = "irisSqlLite.db";
private static final String TABLE_USURIOS ="t_usuarios";

    public DbSqlLite(@Nullable Context context) {
        super(context, DATABASE_NOMBRE,null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE " +TABLE_USURIOS+"(" +
                    "id INTEGER primary Key autoincrement," +
                    "nombre TEXT not null," +
                    "apellido TEXT not null," +
                    "email TEXT not null," +
                    "telefono not null," +
                    "sexo TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }*/
}
