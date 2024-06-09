package com.alura.conversor.model;

public class Currency {
    private String baseCurrency;
    private String targetCurrency;
    private double targetCurrencyValue;

    public Currency(String baseCurrency, String targetCurrency, double targetCurrencyValue) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.targetCurrencyValue = targetCurrencyValue;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public double getTargetCurrencyValue() {
        return targetCurrencyValue;
    }
    
}
