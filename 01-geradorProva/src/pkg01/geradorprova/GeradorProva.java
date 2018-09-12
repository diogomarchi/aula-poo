/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.util.ArrayList;
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
        
        
        ArrayList <Questao> asf = new ArrayList <Questao>();
        //montando as perguntas discrusivas
        int opcao = 0;
        while(true){
            try{
                String opcao_em_texto = JOptionPane.showInputDialog("Digite 1 para questoes discursivas\nDigite 2 para questoes objetivas");
                opcao = Integer.parseInt(opcao_em_texto);
                if(opcao < 1 || opcao > 2)
                    throw new Exception();
                break;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Informe um valor correto, por favor");
            }
        }
        
        if ( opcao == 1){
            
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
        }
        
        
        
        
        if(opcao == 2){
            Objetivas o = new Objetivas();

//            while(true){
//                try{
//                    S
//                }
//            }
            
            
            
            System.out.println("informe o peso da pergunta: ");
            while(!s.hasNextInt()){
                 System.out.println("Erro! Digite um numero valido.");
                 s.nextLine();
            }
            int pesoo = s.nextInt();
            o.setPeso(pesoo);//grava o peso da questao



            //pede a pergunta
            String perguntao = null;
            perguntao = JOptionPane.showInputDialog("Digite a Pergunta: ");
            o.setPergunta(perguntao);//grava a pergunta



            //pede os opcoes
            String[] opcoes = new String[5];//cria vetor de 5 alternativas
            for(int j = 0; j < 5; j++){
                String alternativa = null;
                alternativa = JOptionPane.showInputDialog("informe a alternativa: ");
                opcoes[j] = alternativa;//preenchendo o vetor de alternativas
            }
            o.setOpcoes(opcoes);//grava o vetor de opcoes 


            //pedindo resposta correta
            int resposta = 0;
            while(true){
                try{
                    String resposta_em_texto = JOptionPane.showInputDialog("Digite a resposta correta: ");
                    resposta = Integer.parseInt(resposta_em_texto);
                    if(resposta < 1 || resposta > 5)
                        throw new Exception();
                    break;
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Digite uma resposta correta, por favor");
                }
            }
            o.setRespostaCorreta(resposta);//grava a resposta correta

            x.inserelista(o);//grava a pergunta objetiva
        }
        //JOptionPane.showMessageDialog(null);
    }
}
    
