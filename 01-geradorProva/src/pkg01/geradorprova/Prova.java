/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import com.sun.xml.internal.ws.api.message.MessageHeaders;
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
    
    private Discursiva[] questaoDiscursiva; 
    private Objetivas[] questaoObjetiva; 
    
    
    public int alocaD(int tam){
        questaoDiscursiva = new Discursiva[tam];
        for(int i = 0; i < tam; i++){
            questaoDiscursiva[i] = new Discursiva();
            
        }
        return 0;
    }
    
    public int alocaO(int tam){
        questaoObjetiva = new Objetivas[tam];
        for(int i = 0; i < tam; i++){
            questaoObjetiva[i] = new Objetivas();
        }
        return 0;
    }
    
    
    //construtor
    public Prova() {
        
    }
    
    public Discursiva[] getQuestaoDiscursiva() {
        return questaoDiscursiva;
    }
    public void setQuestaoDiscursiva(Discursiva[] questaoDiscursiva) {
        this.questaoDiscursiva = questaoDiscursiva;
    }
    public Objetivas[] getQuestaoObjetiva() {
        return questaoObjetiva;
    }
    public void setQuestaoObjetiva(Objetivas[] questaoObjetiva) {
        this.questaoObjetiva = questaoObjetiva;
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
    
    public String imprimir(int tamd, int tamo){
        String retorno = "";
        for(int i = 0; i < tamd; i ++){
            retorno = retorno + "(" + this.questaoDiscursiva[i].getPeso() + ")";
            retorno = retorno + this.questaoDiscursiva[i].getPergunta() + "\n";
            retorno = retorno + this.questaoDiscursiva[i].getCriteriosCorrecao() + "\n";
        }
        for(int i = 0; i < tamo; i ++){
            retorno += "(" + this.questaoObjetiva[i].getPeso() + ")";
            retorno += this.questaoObjetiva[i].getPergunta() + "\n";
            for(int j = 0; j < 5; j++){
                retorno += "(" + (j+1)+ ")" + this.questaoObjetiva[i].getOpcoes()[j]+ "\n";
            }
            retorno += "Resposta correta é: " + this.questaoObjetiva[i].getRespostaCorreta() + "\n";
        }
        return retorno;
    }
}
