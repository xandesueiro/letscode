package br.com.letscode.bejv002.desafios.classes;

import java.util.Scanner;

public class Form {

    public ListProducts run(){
        Scanner response = new Scanner(System.in);
        boolean exit = true;
        String productName;
        double productValue;

        ListProducts listProducts = new ListProducts();
        while (exit){
            System.out.printf("Type the PRODUCT NAME or X to exit: ");
            productName = response.next();
            if ("".equals(productName) || "X".equals(productName.toUpperCase())){
                System.out.println("\n====== Product registration closed! ====== ");
                exit = false;
            }else {
                System.out.printf("Type the PRODUCT PRICE (e.g. 99,00): ");
                productValue = response.nextDouble();

                Product product = new Product(productName, productValue);
                listProducts.add(product);
            }
        }

        return listProducts;
    }
}
