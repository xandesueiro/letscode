package br.com.letscode.bejv002.desafios.main;


import br.com.letscode.bejv002.desafios.classes.Currency;
import br.com.letscode.bejv002.desafios.classes.Dollar;

import java.util.Scanner;

public class QuoteMain {

    public static void main(String[] args) {
        QuoteMain runQuote= new QuoteMain();
        Scanner answer = new Scanner(System.in);
        String currencyType;
        double dailyQuote;
        double valueToBeConverted;

        System.out.printf("Type the currency type -> BR | EUR: ");
        currencyType = answer.next();

        System.out.printf("Type a dollar daily quote $: ");
        dailyQuote = answer.nextDouble();

        System.out.printf("Type a value to be converted $: ");
        valueToBeConverted = answer.nextDouble();

        runQuote.printConvertedValue(currencyType.toUpperCase(), dailyQuote, valueToBeConverted);
    }

    public void printConvertedValue(String currencyType, double dailyQuote, double valueToBeConverted){

        Currency dollar = new Dollar(dailyQuote, valueToBeConverted);
        double convertedValue = dollar.convertTo(currencyType);
        System.out.println(
                dollar.print(currencyType, convertedValue)
        );
    }
}
