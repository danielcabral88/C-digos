package cardeneta.ramon.cadernetaturma;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ramon on 29/05/2015.
 */
public class DBCore extends SQLiteOpenHelper{


    private static final String NOME_BD = "caderneta1";
    private static final int VERSAO_BD =351;


    public DBCore(Context ctx){

        super(ctx, NOME_BD, null, VERSAO_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase bd) {

        try {
            bd.execSQL("create table if not exists escola(_id integer primary key autoincrement, nome text not null);");
            bd.execSQL("create table if not exists turma(_id integer primary key autoincrement, descricao text not null, turno text not null, ano integer not null, fk_idEscola CONSTRAINT fk_idEscola REFERENCES escola(_id));");
        } catch (Exception e)
        {
            Log.e("ERROR", e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
        bd.execSQL("drop table if exists turma");
        bd.execSQL("drop table if exists escola");

        onCreate(bd);
    }
}
