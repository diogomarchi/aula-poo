import java.util.Scanner;

/**
 *
 * @author Diogo
 */
public class Exercicio3 {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner (System.in);
        String []vet = new String [12];
        vet[0] = "janeiro";
        vet[1] = "fevereiro";
        vet[2] = "marco";
        vet[3] = "abril";
        vet[4] = "maio";
        vet[5] = "junho";
        vet[6] = "julho";
        vet[7] = "agosto";
        vet[8] = "setembro";
        vet[9] = "outubro";
        vet[10] = "novembro";
        vet[11] = "dezembro";
        
        System.out.println("Digite um numero de 1 a 12 para a impressao do mes: ");
        int numero = s.nextInt();
        do{
            if(numero < 1 || numero > 12){
                System.out.println("Digite novamente: ");
                numero = s.nextInt();
            }
        }while(numero < 1 || numero > 12);
        
        System.out.println(vet[numero-1]);
    }
}
