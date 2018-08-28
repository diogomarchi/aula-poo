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
public class GeradorProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Prova x = new Prova("POO");
        x.setLocal("LAB 3 . BLOCO B6");
        x.setData ("28/08/2018");
        
        //forma didatica
        String retornoDoMetodo = x.obtemDetalhes();
        System.out.println(retornoDoMetodo);
        
        //forma resumida
        System.out.println(x.obtemDetalhes());
        
        
        
        
        
        Discursiva d = new Discursiva();
        Objetivas o = new Objetivas();
        o.setPergunta("qual o melhor time?");
        o.setPeso(2);
        String[] opcoes = new String[5];
        opcoes[0] = "gremio";
        opcoes[1] = "flamengo";
        opcoes[2] = "inter";
        opcoes[3] = "corinthians";
        opcoes[4] = "vasco";
        
        o.setOpcoes(opcoes);
        o.setRespostaCorreta(3);
        
    }
}
