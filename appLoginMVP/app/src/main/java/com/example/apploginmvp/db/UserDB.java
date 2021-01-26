package com.example.apploginmvp.db;


//COMUNMENTE LLAMADO INTERACTOR
//CLASE CLAVE
//CLASE INTERMEDIA QUE CONSULTA CON LA FUENTE DE DATOS O BASE DE DATOS

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.apploginmvp.Model.User.UserModel;

import java.util.ArrayList;

public class UserDB {
    private Context context;
    private BaseDatosSQLite db;

    public UserDB(Context context) {
        this.context = context;
    }

    //primer standard los datos siempre deben venir en un arraylist
    public ArrayList<UserModel> getsUsers ()
    {
        ArrayList<UserModel> users = new ArrayList<>();
        BaseDatosSQLite db = new BaseDatosSQLite(context);

        users = db.getsUsers();

        return users;

    }

    //insertar usuarios registros
    public void insertUser(UserModel user)
    {
        UserModel user_model = new UserModel();
        user_model = user;

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantsDB.TABLE_USUARIO_USERNAME, user_model.get_username());
        contentValues.put(ConstantsDB.TABLE_USUARIO_PASSWORD, user_model.get_password());
        db.insertUser(contentValues);
    }



}
