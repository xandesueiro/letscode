package br.com.letscode.desafios.bejv002.run;

import br.com.letscode.desafios.bejv002.classes.Form;
import br.com.letscode.desafios.bejv002.classes.ListProducts;

public class RunProductList {
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

