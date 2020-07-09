package GUI;

import Resposta.TratamentoArquivos;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainWindow {
    public JPanel generalPanel;
    private JButton importarGabaritoButton;
    private JTextField gabaritoPath;
    private JButton importarVestibulandosButton;
    private JTextField vestibulandosPath;
    private JButton processarButton;
    private JPanel GabaritoPanel;
    private JPanel VestibulandoPanel;

    public MainWindow() {
        importarGabaritoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame = new JFrame();
                JFileChooser importFile = new JFileChooser();
                FileNameExtensionFilter filtroTxt = new FileNameExtensionFilter("Arquivos TXT", "txt");
                importFile.setDialogTitle("Importar Gabarito");
                importFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
                importFile.setFileFilter(filtroTxt);
                int val = importFile.showOpenDialog(frame);
                if(val == JFileChooser.APPROVE_OPTION){
                    File file = importFile.getSelectedFile();
                    gabaritoPath.setText(file.getPath());
                    importarVestibulandosButton.setEnabled(true);
                }
            }
        });
        importarVestibulandosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame = new JFrame();
                JFileChooser importFile = new JFileChooser();
                FileNameExtensionFilter filtroTxt = new FileNameExtensionFilter("Arquivos TXT", "txt");
                importFile.setDialogTitle("Importar Resposta dos Vestibulandos");
                importFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
                importFile.setFileFilter(filtroTxt);
                int val = importFile.showOpenDialog(frame);
                if(val == JFileChooser.APPROVE_OPTION){
                    File file = importFile.getSelectedFile();
                    vestibulandosPath.setText(file.getPath());
                    processarButton.setEnabled(true);
                }
            }
        });
        processarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    TratamentoArquivos.lerGabarito(gabaritoPath.getText());
                }catch (IOException e){
                    System.out.println("Algo esta errado com o arquivo de gabarito");
                }
                try {
                    TratamentoArquivos.lerRespostas(vestibulandosPath.getText());
                } catch (IOException err){
                    System.out.println("Algo esta errado com o arquivo de respostas");
                }
                Dialog exibirResultados = new Dialog();
                exibirResultados.setTextArea(TratamentoArquivos.showAll());
                JFrame dialog = new JFrame("Resultados dos Vestibulandos");
                dialog.setContentPane(exibirResultados.getContentPane());
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);


                TratamentoArquivos.showAll();
            }
        });
    }
}
