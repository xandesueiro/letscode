package br.com.letscode.desafios.bejv002.classes;

public class Product {

    private String name;
    private double price;

    public Product(String parName, double parPrice){
        this.name = parName;
        this.price = parPrice;
    }

    @Override
    public String toString() {
        return this.name.toUpperCase() + " : R$" + this.price;
    }

    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
}
