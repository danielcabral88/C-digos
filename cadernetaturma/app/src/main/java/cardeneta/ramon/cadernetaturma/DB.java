package cardeneta.ramon.cadernetaturma;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramon on 29/05/2015.
 */
public class DB {


    private SQLiteDatabase bd;

    public DB(Context context){
        DBCore auxBd = new DBCore(context);
        bd = auxBd.getWritableDatabase();
    }


    public void inserirEscola(Escola escola){
        ContentValues valores = new ContentValues();
        valores.put("nome", escola.getNome());

        bd.insert("escola", null, valores);
    }

    public void inserirTurma(Turma turma){
        ContentValues valores = new ContentValues();
        valores.put("descricao", turma.getDescricao());

        valores.put("turno", turma.getTurno());
        valores.put("ano", turma.getAno());
        valores.put("fk_idEscola", turma.getEscola());
        bd.insert("turma", null, valores);
    }


    public void atualizar(Turma turma){
        ContentValues valores = new ContentValues();
        valores.put("descricao", turma.getDescricao());
        valores.put("turno", turma.getTurno());
        valores.put("ano", turma.getAno());
        valores.put("fk_idEscola", turma.getEscola());

        bd.update("turma", valores, "_id = ?", new String[]{"" + turma.getId()});
    }


    public void deletar(Turma turma){
        bd.delete("turma", "_id ="+turma.getId(), null);
    }

    public void deletar(int turma){
        bd.delete("turma", "_id ="+turma, null);
    }

    public List<Escola> buscarEscola(){
        List<Escola> list = new ArrayList<Escola>();
        String[] colunas = new String[]{"_id", "nome"};

        Cursor cursor = bd.query("escola", colunas, null, null, null, null, "nome ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{

                Escola u = new Escola();
                u.setIdEscola(cursor.getInt(0));
                u.setNome(cursor.getString(1));
                list.add(u);

            }while(cursor.moveToNext());
        }

        return(list);
    }

    public List<Turma> buscarTurma(){
        List<Turma> list = new ArrayList<Turma>();
        String[] colunas = new String[]{"_id", "descricao","turno","ano","fk_idEscola"};

        Cursor cursor = bd.query("turma", colunas, null, null, null, null, "descricao ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{

                Turma u = new Turma();
                u.setId(cursor.getInt(0));
                u.setDescricao(cursor.getString(1));
                u.setTurno(cursor.getString(2));
                u.setAno(cursor.getInt(3));
                u.setEscola(cursor.getInt(4));
                list.add(u);

            }while(cursor.moveToNext());
        }

        return(list);
    }


    public void inserirEscolar(){

        List<Escola> escolas = new ArrayList<Escola>();
        Escola us1 = new Escola();
        us1.setNome("Sousandrade");
        escolas.add(us1);
        Escola us2 = new Escola();
        us2.setNome("IFMA");

        escolas.add(us2);


        for (int i = 0; i < escolas.size(); i++) {

            inserirEscola(escolas.get(i));
        }

    }


    public void inserirTurma(){

        List<Turma> turmas = new ArrayList<Turma>();
        Turma us1 = new Turma();
        us1.setDescricao("sala 101");
        us1.setTurno("matutino");
        us1.setAno(2015);
        us1.setEscola(1);
        turmas.add(us1);
        Turma us2 = new Turma();
        us2.setDescricao("sala 202");
        us2.setTurno("vespertino");
        us2.setAno(2015);
        us2.setEscola(1);

        turmas.add(us2);


        for (int i = 0; i < turmas.size(); i++) {

            inserirTurma(turmas.get(i));
        }

    }
}