import java.util.Scanner;

/**
 *
 * @author Diogo
 */
public class Exercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        System.out.println("Digite um numero da semana para que vejamos o dia: ");
        int dia = s.nextInt();
        if(dia == 1){
            System.out.println("Domingo");
        }else if(dia == 2){
            System.out.println("segunda-feira");
        }else if(dia == 3){
            System.out.println("terca-feira");
        }else if(dia == 4){
            System.out.println("quarta-feira");
        }else if(dia == 5){
            System.out.println("quinta-feira");
        }else if(dia == 6){
            System.out.println("sexta-feira");
        }else if(dia == 7){
            System.out.println("sabado");
        }else{
            System.out.println("dia invalido");
        }
        
    }
}
