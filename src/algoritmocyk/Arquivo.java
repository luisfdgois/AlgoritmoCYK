package algoritmocyk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Arquivo {

    public static ArrayList<String> ler() {
        
        ArrayList<String> arrLinha = new ArrayList<>();

        try {

            String path = new File("Arquivo.txt").getCanonicalPath();
                    
            BufferedReader buffRead = new BufferedReader(new FileReader(path));
            String linha = buffRead.readLine();

            while (linha != null) {
                arrLinha.add(linha);
                linha = buffRead.readLine();
            }

            buffRead.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrLinha;
    }
    
    public static String obterCaminho(){
        
        String caminho = "";
        
        try {
            caminho =  new File("Arquivo.txt").getCanonicalPath();
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return caminho;
    }
    
     public static void criarNovoArquivo() {
        File file = new File("Arquivo.txt");
        
        if (file.exists()) {
            file.delete();
        }

        try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
