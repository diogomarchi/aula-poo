/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

/**
 *
 * @author Diogo
 */
final class Objetivas extends Questao{ 
    private String[] opcoes;
    private int respostaCorreta;
    
    //construtor para inicializar o vetor, é uma melhor pratica de programação 
    public Objetivas(){
        this.opcoes = new String[5];
    }
    
    public String seImprime(){
        String retorno = "";
        retorno += "###################################\n";
        retorno += "(" + this.getPeso() + ") ";
        retorno += this.getPergunta() + "\n";
        for(int j = 0; j < 5; j++){
            retorno += "(" + (j+1)+ ") " + this.getOpcoes()[j]+ "\n";
        }
        retorno += "Resposta correta é: " + this.getRespostaCorreta() + "\n";
        return retorno;
    } 

    /**
     * @return the opcoes
     */
    public String[] getOpcoes() {
        return opcoes;
    }

    /**
     * @param opcoes the opcoes to set
     */
    public void setOpcoes(String[] opcoes) {
        this.opcoes = opcoes;
    }

    /**
     * @return the respostaCorreta
     */
    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    /**
     * @param respostaCorreta the respostaCorreta to set
     */
    public void setRespostaCorreta(int respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }
    
    
}
