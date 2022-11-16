package br.com.letscode.bejv003.fixacao.generics;

public class Imprimir<T extends Number> {

    //Integer, Double, Float
    public void imprimir(T numero1, T numero2) {

        //Double num1Double = (Double) numero1;

        double soma = numero1.doubleValue() + numero2.doubleValue();

        System.out.println("1 = " + numero1);
        System.out.println("2 = " + numero2);

    }

}
