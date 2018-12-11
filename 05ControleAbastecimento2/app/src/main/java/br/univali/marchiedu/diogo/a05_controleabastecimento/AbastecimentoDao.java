package br.univali.marchiedu.diogo.a05_controleabastecimento;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AbastecimentoDao {

    private static ArrayList<Abastecimento> AL_CACHE = new ArrayList<>();//acho que tem que ter abastecimentos no array

    private static final String NOME_ARQUIVO = "Abastecimento14.txt";

    public static boolean salvar(Context c, Abastecimento aSerSalva){
        AL_CACHE.add(aSerSalva);

        String avEmString = "";
        avEmString += aSerSalva.getQuilometragem() + ";";
        avEmString += aSerSalva.getLitro() + ";";
        avEmString += aSerSalva.getNomePosto() + ";";
        avEmString += aSerSalva.getData() + ";";
        avEmString += aSerSalva.getLatitude() + ";";
        avEmString += aSerSalva.getLongitude() + ";"  + "\n";


        File refArquivo = new File( c.getFilesDir().getPath() + NOME_ARQUIVO );
        try {
            FileWriter escritor = new FileWriter(refArquivo, true);
            escritor.write( avEmString );
            escritor.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Abastecimento> getLista(Context c){
        AL_CACHE = new ArrayList<Abastecimento>();

        DbHelper DataBase = new DbHelper(c);
        SQLiteDatabase db = DataBase.getReadableDatabase();

        String SQLBuscaRegistros = "SELECT posto, data, distancia, litros, latitude, longitude, id FROM cadastros";
        Cursor ponteiro = db.rawQuery(SQLBuscaRegistros, null);

        while (ponteiro.moveToNext()){
            Abastecimento item = new Abastecimento();
            item.setNomePosto(ponteiro.getString(0));
            item.setData(ponteiro.getString(1));
            item.setQuilometragem(ponteiro.getFloat(2));
            item.setLitro(ponteiro.getFloat(3));
            item.setLatitude(ponteiro.getDouble(4));
            item.setLongitude(ponteiro.getDouble(5));
            item.setId(ponteiro.getLong(6));
            AL_CACHE.add(item);
        }
        return AL_CACHE;
    }
}