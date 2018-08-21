import java.util.Scanner;

/**
 *
 * @author Diogo
 */
public class Exercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        System.out.println("Digite quantos dias voce trabalhou: ");
        int dias = s.nextInt();
        
        System.out.println("Digite quanto e seu salario integral: ");
        float salario_integral = s.nextFloat();

        float salario = dias*salario_integral/22;
        
       System.out.println("Seu salario final e: " +salario);
    }
}