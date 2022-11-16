package br.com.letscode.utilitarios;

public class UtilitarioString {

    public static String converterPrimeiraLetraParaMaiuscula(String frase){
        String fraseFormatada = frase.substring(0,1).toUpperCase().concat(frase.substring(1));
        return fraseFormatada;
    }

    public static boolean contemAPalavra(String texto, String palavraProcurada){
        return texto.toLowerCase().contains(palavraProcurada.toLowerCase());
    }
}
