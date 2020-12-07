package algoritmocyk;

import java.util.ArrayList;
import java.util.List;

public class Algoritmo {

    private String[][] matrizRegistros;
    private Gramatica gramatica;

    public Algoritmo() {
        this.gramatica = new Gramatica();
    }

    public boolean ValidarPalavra(String palavra) {

        this.matrizRegistros = new String[palavra.length()][palavra.length()];

        for (int i = 0; i < palavra.length(); i++) {

            InicializarColunasDaMatriz(i);

            String simboloTerminal = String.valueOf(palavra.charAt(i));
            List<String> simbolosNaoTerminal = this.gramatica.ObterNaoTerminalQueGera(simboloTerminal);

            this.matrizRegistros[i][i] = ToString(simbolosNaoTerminal);
        }

        ExecutarEtapas(palavra);

        return ValidarResultado(palavra);
    }

    public String[][] LerMatriz() {
        return this.matrizRegistros;
    }

    private void ExecutarEtapas(String palavra) {

        int etapa = 1;

        while (etapa < palavra.length()) {

            for (int indice = 0; indice < (palavra.length() - etapa); indice++) {
                ManipularSimbolos(etapa, indice);
            }

            etapa += 1;
        }
    }

    private void ManipularSimbolos(int passo, int indice) {

        int linhaFatorEsquerdo = indice;
        int colunaFatorEsquerdo = indice;

        int linhaFatorDireito = (indice + 1);
        int colunaFatorDireito = (passo + indice);

        while (passo > 0) {

            String simboloFatorEsquerdo = this.matrizRegistros[linhaFatorEsquerdo][colunaFatorEsquerdo];
            String simboloFatorDireito = this.matrizRegistros[linhaFatorDireito][colunaFatorDireito];

            List<String> naoTerminais = AplicarDistributiva(simboloFatorEsquerdo, simboloFatorDireito);

            Registrar(indice, colunaFatorDireito, naoTerminais);

            passo -= 1;

            colunaFatorEsquerdo += 1;
            linhaFatorDireito += 1;
        }
    }

    private List<String> AplicarDistributiva(String fatorEsquerdo, String fatorDireito) {

        List<String> simbolos = new ArrayList<>();

        for (int i = 0; i < fatorEsquerdo.length(); i++) {
            for (int j = 0; j < fatorDireito.length(); j++) {

                String simboloGerado = String.valueOf(fatorEsquerdo.charAt(i)).concat(String.valueOf(fatorDireito.charAt(j)));
                String naoTerminais = ToString(this.gramatica.ObterNaoTerminalQueGera(simboloGerado));

                simbolos.add(naoTerminais);
            }
        }

        return simbolos;
    }

    private void InicializarColunasDaMatriz(int linha) {

        for (int j = linha; j < this.matrizRegistros[linha].length; j++) {
            this.matrizRegistros[linha][j] = "";
        }
    }

    private void Registrar(int linha, int coluna, List<String> simbolos) {

        for (String simbolo : simbolos) {

            int i = 0;

            while (true) {

                String simboloChar = "";

                try {
                    simboloChar = String.valueOf(simbolo.charAt(i));
                } catch (Exception ex) {
                }

                if (!this.matrizRegistros[linha][coluna].contains(simboloChar)) {
                    this.matrizRegistros[linha][coluna] = this.matrizRegistros[linha][coluna].concat(simboloChar);
                }

                if ((i += 1) >= simbolo.length()) {
                    break;
                }
            }
        }
    }

    private boolean ValidarResultado(String palavra) {
        if (this.matrizRegistros[0][palavra.length() - 1].contains(this.gramatica.ObterSimboloInicial())) {
            return true;
        }
        return false;
    }

    private String ToString(List<String> lista) {
        String result = "";

        if (lista != null) {
            for (String valor : lista) {
                result = result.concat(valor);
            }

        }
        return result;
    }
}
