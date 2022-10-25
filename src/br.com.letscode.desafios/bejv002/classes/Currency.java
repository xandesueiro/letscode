package br.com.letscode.desafios.bejv002.classes;

public abstract class Currency {
    protected double dailyQuote;
    protected double valueToBeConverted;

    public final String COUNTRY_BR = "BR";
    public final String COUNTRY_EUR = "EUR";

    public Currency(double paramDailyQuote, double paramValueToBeConverted){
        this.dailyQuote = paramDailyQuote;
        this.valueToBeConverted = paramValueToBeConverted;
    }

    public abstract double convertTo(String country);
    public abstract String print(String country, double paramConvertedValue);

    public double getDailyQuote(){
        return this.dailyQuote;
    }

    public double getValueToBeConverted() {
        return valueToBeConverted;
    }
}
