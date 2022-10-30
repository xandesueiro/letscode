package br.com.letscode.bejv002.desafios.classes;

import java.util.ArrayList;

public class ListProducts {

    private ArrayList<Product> list;

    public void add(Product prod){
        if ( null == list){
            list = new ArrayList<>();
        }
        list.add(prod);
    }

    private Product maxPrice(){
        Product prodMax = new Product("", 0.0);
        for (Product prod: this.list  ) {
            if (prod.getPrice() > prodMax.getPrice()) prodMax = prod;
        }
        return prodMax;
    }

    private Product minPrice(){
        Product prodMin = new Product("", 9999999999.0);
        for (Product prod : this.list  ) {
            if (prod.getPrice() < prodMin.getPrice()) prodMin = prod;
        }
        return prodMin;
    }

    public void print(){
        if (null == list){
            System.out.println("There aren't registered products!");
        } else {
            System.out.println("\n=================================================");
            System.out.println("Total products => " + list.size() + "\n");
            System.out.println("List of products...:");
            for (Product prod : this.list) {
                System.out.println("==> " + prod.toString());
            }

            System.out.println("\nThe product most expansive is " + maxPrice().toString());
            System.out.println("The cheapest product is " + minPrice().toString());
            System.out.println("=================================================");
        }

    }
}
