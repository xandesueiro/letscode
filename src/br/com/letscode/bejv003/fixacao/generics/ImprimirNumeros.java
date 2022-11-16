package br.com.letscode.bejv003.fixacao.generics;

public class ImprimirNumeros {

    public static void main(String[] args) {

        Imprimir<Double> imprimir = new Imprimir<>();
        imprimir.imprimir(1.1, 1.1);

        Imprimir<Integer> imprimirInt = new Imprimir<>();
        imprimirInt.imprimir(1, 1);

        /*Imprimir<String> imprimirStr = new Imprimir<>();
        imprimirStr.imprimir("1", "1");*/

    }

}
