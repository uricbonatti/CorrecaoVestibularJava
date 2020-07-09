package GUI;

import Resposta.TratamentoArquivos;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Dialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonSave;
    private JButton buttonCancel;
    private JTextArea exibirText;

    public Dialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonSave);

        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        JFrame frame = new JFrame();
        JFileChooser saveFile = new JFileChooser();
        FileNameExtensionFilter filtroTxt = new FileNameExtensionFilter("Arquivos TXT", "txt");
        saveFile.setDialogTitle("Salvar Resultados dos Vestibulandos");
        saveFile.setFileFilter(filtroTxt);
        int val = saveFile.showSaveDialog(frame);
        if(val == JFileChooser.APPROVE_OPTION){
            try {
                TratamentoArquivos.salvarResultado(saveFile.getSelectedFile().getAbsolutePath());
            }catch (IOException e){
                System.out.println("Algo errado com o diretorio");
            }
        }



        Dialog.this.dispose();
    }

    private void onCancel() {
        // add your code here if necessary

        Dialog.this.dispose();
    }

    public static void main(String[] args) {
        Dialog dialog = new Dialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public void setTextArea(String showAll) {
        exibirText.setText(showAll);
        exibirText.repaint();
    }
}
