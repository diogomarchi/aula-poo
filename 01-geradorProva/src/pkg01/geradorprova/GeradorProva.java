/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * 
 * @author Diogo
 */
public class GeradorProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String nome_disc, local, data = null, peso_em_texto = null;
        Prova x = new Prova();//criando uma prova
        
        //pedindo nome da disciplina
        int chave;
        do{
            chave = 0;
            nome_disc = JOptionPane.showInputDialog("Informe o nome da disciplina: ");
            for(int i = 0; i < nome_disc.length(); i++){
                char c = nome_disc.charAt(i);
                if(c == '1'||c == '2'||c == '3'||c == '4'||c == '5'||c == '6'||c == '7'||c == '8'||c == '9'||c == '0'||c == '.'||c == ','||c == ';'||c == '-'||c == '_'){
                    JOptionPane.showMessageDialog(null,"Digite novamente, nome invalido: ");
                    chave = 1;
                    break;
                }
                else{
                    continue;
                }
            }
        }while(chave != 0);
        x.setNomeDisciplina(nome_disc);
        
        //pedindo peso da prova
        int peso = -1;
       /* while(peso < 0){
            peso_em_texto = JOptionPane.showInputDialog("Informe o peso da prova: ");
            
                }*/
        
        System.out.println("Informe o peso da prova:");
        while(!s.hasNextInt()){
            System.out.println("Erro! Digite um numero valido.");
            s.nextLine();
        }
        
        peso = s.nextInt();
        x.setPeso(peso);
        
        
        //pedindo o local
        local = JOptionPane.showInputDialog("Informe o local: ");
        x.setLocal(local);
        
        
        //pedindo a data
        chave = 1;
        while(chave != 0){
            chave = 0;
            data = JOptionPane.showInputDialog("Informe a data: ");
            for (int i = 0; i < data.length(); i++){
                char c = data.charAt(i);
                if(c == '1'||c == '2'||c == '3'||c == '4'||c == '5'||c == '6'||c == '7'||c == '8'||c == '9'||c == '0'||c == '/'){
                    continue;
                }else{
                    chave = 1;
                    JOptionPane.showMessageDialog(null, "Digite novamente, data invalida: ");
                    break;
                }
            }
        }
        x.setData(data);
        
        
        
        //montando as perguntas discrusivas
        
        
        Discursiva d = new Discursiva();
            System.out.println("informe o peso da pergunta: ");
            while(!s.hasNextInt()){
                 System.out.println("Erro! Digite um numero valido.");
                 s.nextLine();
            }
            peso = s.nextInt();
            d.setPeso(peso);//gravando o peso da pergunta
            //pedindo a pergunta
            String pergunta = JOptionPane.showInputDialog("Qual é a pergunta: ");
            d.setPergunta(pergunta);//gravando a pergunta
            //pedindo o criterio
            String criterio = JOptionPane.showInputDialog("Qual é o critério de correção da pergunta: ");
            d.setCriteriosCorrecao(criterio);//gravando o criterio de correção
        x.inserelista(d);//gravando no vetor de questões, a questão
        
        
        
        
        
        
        
        
        
        
        
        Objetivas o = new Objetivas();
        
        
            //pedindo o peso da questao
            chave = 1;
            String peso_em_textoqo = "0";
            while(chave == 1){
                chave = 0;
                peso_em_textoqo = JOptionPane.showInputDialog("Qual é o peso da pergunta: ");
                for(int j = 0; j < qtdo.length(); j++){
                    char c = peso_em_textoqo.charAt(j);
                    if(c == '1'||c == '2'||c == '3'||c == '4'||c == '5'||c == '6'||c == '7'||c == '8'||c == '9'||c == '0'){
                        continue;
                    }else{
                        chave = 1;
                        JOptionPane.showMessageDialog(null, "Digite novamente, nome invalido: ");
                        break;
                    }
                }
            }
            float pesoqo = Float.parseFloat(peso_em_textoqo);
            o[i].setPeso(pesoqo);//grava o peso da questao
            
            //pede a pergunta
            String pergunta = null;
            int key;
            do{
                key = 1;
                pergunta = JOptionPane.showInputDialog("Qual é a pergunta: ");
                if(pergunta == "." || pergunta =="," || pergunta == ""){
                    key = 0;
                    JOptionPane.showMessageDialog(null, "caracter indisponivel, digite novamente");
                }
            }while(key == 0);
            o[i].setPergunta(pergunta);//grava a pergunta
            
            //pede os opcoes
            String[] opcoes = new String[5];//cria vetor de 5 alternativas
            for(int j = 0; j < 5; j++){
                String alternativa = null;
                //pedindo as opcoes de assinalar
                key = 1;
                while(key == 1){
                    key = 0;
                    alternativa = JOptionPane.showInputDialog("(" + (j+1) + ") = " );
                    for(int k = 0; k < alternativa.length(); k++){
                        char c = alternativa.charAt(k);
                        if(c == '@' || c =='#' || c == '&'){
                            key = 1;
                            JOptionPane.showMessageDialog(null, "caracter indisponivel, digite novamente");
                            break;
                        }else{
                            continue;
                        }
                    }
                }
                opcoes[j] = alternativa;//preenchendo o vetor de alternativas
            }
            o[i].setOpcoes(opcoes);//grava o vetor de opcoes 
            //pedindo resposta correta
            String respostaCorreta = null;
             key = 1;
            while(key == 1){
                key = 0;
                respostaCorreta = JOptionPane.showInputDialog("Qual é a resposta: ");
                for(int j = 0; j < respostaCorreta.length(); j++){
                    char c = respostaCorreta.charAt(j);
                    if(c == '1'||c == '2'||c == '3'||c == '4'||c == '5'){
                        continue;
                    }else{
                        key = 1;
                        JOptionPane.showMessageDialog(null, "Digite novamente, nome invalido: ");
                        break;
                    }
                }
            }
            o[i].setRespostaCorreta(Integer.parseInt(respostaCorreta));//grava a resposta correta
        }
        x.setQuestaoObjetiva(o);//grava a pergunta objetiva
        
        JOptionPane.showMessageDialog(null,x.imprimir(quantidadeDiscursiva, quantidadeObjetivas
        ));
        
    }
    
           
}
