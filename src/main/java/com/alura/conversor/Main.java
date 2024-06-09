package com.alura.conversor;

import java.util.Scanner;

import com.alura.conversor.api.CurrencyApiService;
import com.alura.conversor.model.Currency;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyApiService apiService = new CurrencyApiService();

        int option = 0;

        while (option != 7) {
            System.out.println("*********************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("*********************************************");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("*********************************************");
            System.out.print("Elija una opción válida: ");

            option = scanner.nextInt();

            if (option >= 1 && option <= 6) {
                System.out.print("Ingrese el valor que desea convertir: ");
                double amount = scanner.nextDouble();
                String fromCurrency = "";
                String toCurrency = "";

                switch (option) {
                    case 1:
                        fromCurrency = "USD";
                        toCurrency = "ARS";
                        break;
                    case 2:
                        fromCurrency = "ARS";
                        toCurrency = "USD";
                        break;
                    case 3:
                        fromCurrency = "USD";
                        toCurrency = "BRL";
                        break;
                    case 4:
                        fromCurrency = "BRL";
                        toCurrency = "USD";
                        break;
                    case 5:
                        fromCurrency = "USD";
                        toCurrency = "COP";
                        break;
                    case 6:
                        fromCurrency = "COP";
                        toCurrency = "USD";
                        break;
                }

                Currency currency = apiService.getCurrencyRate(fromCurrency, toCurrency);
                if (currency != null) {
                    double convertedAmount = amount * currency.getTargetCurrencyValue();
                    System.out.println(amount + " " + fromCurrency + " = " + convertedAmount + " " + toCurrency+"\n");
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Error al obtener la tasa de cambio.");
                }
            } else if (option == 7) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción no válida. Por favor, elija una opción del 1 al 7.");
            }
        }

        scanner.close();
    }
}
