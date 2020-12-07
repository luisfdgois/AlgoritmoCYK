package algoritmocyk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Gramatica {

    private Map<String, List<String>> componentes;
    private String SimboloInicial;

    public Gramatica() {
        this.componentes = new HashMap();
        ProcessarArquivoDaGramatica();
    }
    
    public List<String> ObterNaoTerminalQueGera(String simboloAlcancado){
        return this.componentes.get(simboloAlcancado);
    }
    
    public String ObterSimboloInicial(){
        return this.SimboloInicial;
    }

    private void ProcessarArquivoDaGramatica() {

        List<String> regras = Arquivo.ler();

        for (String regra : regras) {
            String simboloEsquerdo = ObterSimboloEsquerdo(regra);
            String[] simbolosDireito = ObterSimbolosDireito(regra);

            if(this.SimboloInicial == null){
                this.SimboloInicial = simboloEsquerdo;
            }
            
            for (String simbolo : simbolosDireito) {
                Adicionar(simbolo, simboloEsquerdo);
            }
        }
    }

    private String ObterSimboloEsquerdo(String regra) {

        String[] simbolos = Split(regra);
        String simboloEsquerdo = simbolos[0];

        return simboloEsquerdo;
    }

    private String[] ObterSimbolosDireito(String regra) {

        String[] simbolos = Split(regra);
        String[] simbolosDireito = simbolos[1].split("\\|");

        return simbolosDireito;
    }

    private String[] Split(String regra) {

        String[] simbolos = regra.replace(" ", "").split("=>");
        return simbolos;
    }

    private void Adicionar(String gerado, String gerador) {

        if (!this.componentes.containsKey(gerado)) {
            this.componentes.put(gerado, new ArrayList());
        }

        this.componentes.get(gerado).add(gerador);
    }
}
