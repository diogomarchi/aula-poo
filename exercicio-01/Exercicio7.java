import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Diogo
 */
public class Exercicio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        String nome;
        nome = JOptionPane.showInputDialog("Digite seu nome");
        
        JOptionPane.showMessageDialog(null,"Agora voce digitara as suas 3 notas de media");
   
        
        String numero_em_texto1 = JOptionPane.showInputDialog("Digite a nota da m1: ");
        float m1 = Float.parseFloat(numero_em_texto1);
        String numero_em_texto2 = JOptionPane.showInputDialog("Digite a nota da m2: ");
        float m2 = Float.parseFloat(numero_em_texto2);
        String numero_em_texto3 = JOptionPane.showInputDialog("Digite a nota da m3: ");
        float m3 = Float.parseFloat(numero_em_texto3);
        float media = (m1+m2+m3)/3;
        if(media > 5.75){
            JOptionPane.showMessageDialog(null,"\n\nNOME: " +nome+"\nMEDIA: "+media +"\nSITUACAO: APROVADO");
        }else{
            JOptionPane.showMessageDialog(null,"\n\nNOME: " +nome+"\nMEDIA: "+media +"\nSITUACAO: REPROVADO");
        }
    }
    
}