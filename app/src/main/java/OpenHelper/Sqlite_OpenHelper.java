package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlite_OpenHelper extends SQLiteOpenHelper {


    public Sqlite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "create table usuario(_Id Integer primary key autoincrement,Correo text,Contraseña text)";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void abrir()
    {
        this.getWritableDatabase();
    }

    public void cerrar()
    {
        this.close();
    }

    public void insertarRegistro(String Correo,String Contraseña)
    {
        ContentValues datosingresados = new ContentValues();
        datosingresados.put("Correo",Correo);
        datosingresados.put("Contraseña",Contraseña);
        this.getWritableDatabase().insert("usuario",null,datosingresados);
    }

    public Cursor Consultar(String correo, String contraseña) throws SQLiteException
    {
        Cursor mcursor = null;
        mcursor = this.getReadableDatabase().query("usuarios",new String[]{"_Id","Correo","Contraseña"},"Correo like'"+correo+"'" +
                "and Contraseña like'"+contraseña +"'",null, null,null, null);
        return mcursor;
    }
}
