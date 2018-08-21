import java.util.Scanner;

/**
 *
 * @author Diogo
 */
public class Exercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        
        System.out.println("Digite seu peso");
        int peso = s.nextInt();
        
        System.out.println("Digite sua altura");
        float altura = s.nextFloat();
        
        float peso_ideal = 0;
        peso_ideal = peso/(altura*altura);
        System.out.println("Seu peso ideal e: " +peso_ideal);
        
        
        
        
    }
    
}