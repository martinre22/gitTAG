package com.example.apploginmvp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.apploginmvp.Model.User.UserModel;

import java.util.ArrayList;

public class BaseDatosSQLite extends SQLiteOpenHelper {
    private Context context;
    public BaseDatosSQLite(Context context) {
        super(context, ConstantsDB.DATA_BASE_NAME, null, ConstantsDB.DATA_BASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_create_table_users = "create table " + ConstantsDB.TABLE_USER + " ("
                        + ConstantsDB.TABLE_USUARIO_USERNAME + " char, "
                        + ConstantsDB.TABLE_USUARIO_PASSWORD + " char "
                        +")";

        db.execSQL(query_create_table_users);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<UserModel> getsUsers()
    {
        ArrayList<UserModel> users = new ArrayList<>();
        String query = "Select * from " + ConstantsDB.TABLE_USER;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext())
        {
            UserModel userActual = new UserModel();
            userActual.setUser_name(registros.getString(0));
            userActual.setPassword(registros.getString(1));
            users.add(userActual);
        }

        db.close();
        return users;
    }

    public void insertUser(ContentValues values)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantsDB.TABLE_USER, null, values);
        db.close();

    }
}
