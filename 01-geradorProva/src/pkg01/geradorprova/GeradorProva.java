/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;


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
        String continuar;
        int continua;
        
        //pedindo nome da disciplina
        nome_disc = JOptionPane.showInputDialog("Informe o nome da disciplina: ");
        x.setNomeDisciplina(nome_disc);
        
        
        //pedindo peso da prova
        int peso = 0;
        while(true){
            try{
                peso_em_texto = JOptionPane.showInputDialog("Informe o peso da prova: ");
                peso = Integer.parseInt(peso_em_texto);
                if(peso < 1){
                    JOptionPane.showMessageDialog(null, "Informe peso maior que zero");
                    throw new Exception ();
                }
                break;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Informe um numero");
            }
        }
        x.setPeso(peso);
        
        
        //pedindo o local
        local = JOptionPane.showInputDialog("Informe o local: ");
        x.setLocal(local);
        
        
        //pedindo a data
        String aux;
        SimpleDateFormat sdf = new SimpleDateFormat("AA/BB/CCCC");
        while (true) {
            try{
                aux = JOptionPane.showInputDialog("Digite a data (AA/BB/CCCC):");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("AA/BB/CCCC");
                LocalDate.parse(aux, formatter);    
                sdf.parse(aux);
                break;
            }
            catch(DateTimeParseException | ParseException ex) {
                JOptionPane.showMessageDialog(null,"Digite uma data valida!");
            }
        } 
        x.setData(data);
        
        
        ArrayList <Questao> asf = new ArrayList <Questao>();
        //montando as perguntas discrusivas
        int opcao = 0;
        do{
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
                String peso_em_textoo = null;
                while(true){
                    try{
                        peso_em_textoo = JOptionPane.showInputDialog("Informe o peso da questão: ");
                        peso = Integer.parseInt(peso_em_textoo);
                        if(peso>10){
                            JOptionPane.showMessageDialog(null, "Valor acima do peso da prova");
                            throw new Exception ();
                        }
                        break;
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Informe um valor correto por favor");
                    }
                }
                o.setPeso(peso);//grava o peso da questao


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
            while(true){
                try{
                    continuar = JOptionPane.showInputDialog("Digite 1 para sair\nDigite 0 para criar outra pergunta");
                    continua = Integer.parseInt(continuar);
                    if(continua < 0 || continua > 1){
                        JOptionPane.showMessageDialog(null, "Digite um ou 0");
                        throw new Exception();
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Informe um numero válido");
                }
            }
        }while(continua == 0);
        //JOptionPane.showMessageDialog(null, x.imprimir());
        
        
        
    }
}
    
