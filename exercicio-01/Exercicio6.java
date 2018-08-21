import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Diogo
 */
public class Exercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        JOptionPane.showMessageDialog(null,"Digite 10 valores: ");
        int []vet = new int [12];
        for(int i = 0; i < 10; i++){
            String numero_em_texto;
            int b = i + 1;
            numero_em_texto = JOptionPane.showInputDialog("valor["+b+"]= ");
            int numero = Integer.parseInt(numero_em_texto);
            vet[i] = numero;
        }
        int soma = 0;
        for(int i = 0; i < 10; i++){
            soma += vet[i];
        }
        float media = soma / 10;
        
        int maior=-9999, menor = 999999;
        for(int i = 0; i < 10; i++){
            if(vet[i] > maior)
                maior = vet[i];
            if(vet[i] < menor)
                menor = vet[i];
        }
        System.out.println("soma dos numeros e: " +soma);
        System.out.println("media dos numeros e: " +media);
        System.out.println("maior numero e: " +maior);
        System.out.println("menor numero e: " +menor);
    }
    
    
}