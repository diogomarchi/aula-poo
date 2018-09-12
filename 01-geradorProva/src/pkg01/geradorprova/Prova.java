/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import com.sun.xml.internal.ws.api.message.MessageHeaders;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Diogo
 */
public class Prova {

    private String nomeDisciplina;
    private int peso;
    private String local;
    private String data;
    private ArrayList<Questao>lista;
    
    //construtor
    public Prova() {
        ArrayList<Questao> lista = new ArrayList<>();
    }
    
    public void inserelista(Questao d){
        getLista().add(d);
    }
    
 
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    //metodo
    public String cabeçalho() {
        String retorno = "";
        retorno = retorno + "Nome: " + this.getNomeDisciplina() + "\n";
        retorno = retorno + "Peso: " + this.getPeso() + "\n";
        retorno = retorno + "Local: " + this.getLocal() + "\n";
        retorno = retorno + "Data: " + this.getData() + "\n";
        return retorno;
    }
    
    public String imprimir(){
        String retorno = cabeçalho();
        for(int i = 0; i < getLista().size(); i ++){
            retorno += this.getLista().get(i).seImprime();
        }
        return retorno;
    }

    /**
     * @return the lista
     */
    public ArrayList<Questao> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ArrayList<Questao> lista) {
        this.lista = lista;
    }
}
