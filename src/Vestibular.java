import GUI.MainWindow;
import Resposta.Vestibulando;

import javax.swing.*;

public class Vestibular{
    public static void main(String[] args)  {
        System.out.println("Ok lets go");
        JFrame frame = new JFrame("Corretor de Prova de Vestibular");
        frame.setContentPane(new MainWindow().generalPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
