package br.com.letscode.bejv002.desafios.main;

import br.com.letscode.bejv002.desafios.classes.Form;
import br.com.letscode.bejv002.desafios.classes.ListProducts;

public class ProductListMain {
    public static void main(String[] args) {
        try {
            ListProducts lp = new Form().run();
            lp.print();
        }catch (Exception e){
            System.out.println("ERROR!!!");
            System.out.println(e.toString() + " - Error Message: " + e.getMessage());
        }
    }

}

