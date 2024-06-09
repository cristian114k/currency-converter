package com.alura.conversor.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.alura.conversor.model.Currency;
import com.alura.conversor.utils.GsonUtil;
import com.alura.conversor.model.ExchangeRateResponse;

public class CurrencyApiService {

    public Currency getCurrencyRate(String currency,String currencyToFind) {

        URI api_url = URI.create("https://v6.exchangerate-api.com/v6/e9eed86c522b2166bfc2a491/latest/"+currency); 

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(api_url)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ExchangeRateResponse exchangeRateResponse = GsonUtil.getGson().fromJson(response.body(), ExchangeRateResponse.class);

            if (exchangeRateResponse.getResult().equals("success")) {
                double targetCurrencyValue = exchangeRateResponse.getConversionRates().get(currencyToFind);
                return new Currency(exchangeRateResponse.getBase_code(), currencyToFind, targetCurrencyValue);
            } else {
                System.out.println("Error: " + exchangeRateResponse.getErrorType());
                return null;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
