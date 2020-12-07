package algoritmocyk;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AlgoritmoCYK {

    public static void main(String[] args) {

        int option = JOptionPane.showConfirmDialog(null, "Criar nova gramática?");

        if (option == 0) {

            try {
                Arquivo.criarNovoArquivo();

                Process process = Runtime.getRuntime().exec("Notepad " + Arquivo.obterCaminho());
                try {
                    process.waitFor();
                } catch (InterruptedException ex) {
                    Logger.getLogger(AlgoritmoCYK.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível criar o arquivo de leitura!\n" + ex.getMessage());
            }
        }

        if (option != 2) {

            Algoritmo algoritmo = new Algoritmo();

            String palavra = JOptionPane.showInputDialog("Informe a palavra que será processada: ");

            if (palavra != null) {
                if (algoritmo.ValidarPalavra(palavra)) {
                    JOptionPane.showMessageDialog(null, "Palavra aceita!", " ", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Palavra recusada!", " ", JOptionPane.ERROR_MESSAGE);
                }
            }

            String[][] matrizResult = algoritmo.LerMatriz();

            for (int i = 0; i < matrizResult.length; i++) {
                for (int j = 0; j < matrizResult[i].length; j++) {
                    System.out.print(matrizResult[i][j] + "\t");
                }
                System.out.println("");
            }

        }
    }
}
