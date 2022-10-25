package br.com.letscode.desafios.bejv002.classes;

public class Dollar extends Currency {

    public Dollar(double paramDailyQuote, double paramValueToBeConverted) {
        super(paramDailyQuote, paramValueToBeConverted);
    }

    @Override
    public double convertTo(String country) {
        double convertedValue;

        switch (country){
            case COUNTRY_BR:
                return dollarToBRL();
            case COUNTRY_EUR:
                return dollarToEUR();
            default:
                convertedValue = 0.0;
        }
        return convertedValue;
    }

    private double dollarToBRL(){
        return getDailyQuote() * getValueToBeConverted();
    }

    private double dollarToEUR(){
        return getDailyQuote() * getValueToBeConverted();
    }

    public String print(String country, double paramConvertedValue){
        String msg = "The value $" + getValueToBeConverted() + " dollars converted in ";
        switch (country) {
            case COUNTRY_BR -> msg += "Reals is equal R$" + paramConvertedValue;
            case COUNTRY_EUR -> msg += "Euros is equal €" + paramConvertedValue;
            default -> msg = "Error in the currency conversion";
        }
        return msg;
    }

}
