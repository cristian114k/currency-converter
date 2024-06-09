package com.alura.conversor.model;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class ExchangeRateResponse {
    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;
    @SerializedName("error-type")
    private String error_type;

    // Getters and setters
    public String getResult() {
        return result;
    }

    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversionRates() {
        return conversion_rates;
    }

    public String getErrorType() {
        return error_type;
    }

}
