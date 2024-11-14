package org.example;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverterApp {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/56c89de0e8e32e98f90fac5b/latest/USD";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JSONObject exchangeRates = fetchExchangeRates();

        if (exchangeRates == null) {
            System.out.println("Error al obtener las tasas de cambio.");
            return;
        }

        while (true) {
            System.out.println("\n--- Bienvenido al Conversor de Monedas ---");
            System.out.println("1. Convertir de Dólar a Peso Argentino");
            System.out.println("2. Convertir de Peso Argentino a Dólar");
            System.out.println("3. Convertir de Dólar a Peso Chileno");
            System.out.println("4. Convertir de Peso Chileno a Dólar");
            System.out.println("5. Convertir de Dólar a Real Brasileño");
            System.out.println("6. Convertir de Real Brasileño a Dólar");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 7) {
                System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                break;
            }

            System.out.print("Ingrese la cantidad: ");
            double cantidad = scanner.nextDouble();

            switch (opcion) {
                case 1 -> convertAndDisplay(cantidad, "USD", "ARS", exchangeRates);
                case 2 -> convertAndDisplay(cantidad, "ARS", "USD", exchangeRates);
                case 3 -> convertAndDisplay(cantidad, "USD", "CLP", exchangeRates);
                case 4 -> convertAndDisplay(cantidad, "CLP", "USD", exchangeRates);
                case 5 -> convertAndDisplay(cantidad, "USD", "BRL", exchangeRates);
                case 6 -> convertAndDisplay(cantidad, "BRL", "USD", exchangeRates);
                default -> System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static JSONObject fetchExchangeRates() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            return jsonResponse.getJSONObject("conversion_rates");
        } catch (IOException | InterruptedException e) {
            System.out.println("Error en la conexión o en la respuesta: " + e.getMessage());
            return null;
        }
    }

    private static void convertAndDisplay(double amount, String fromCurrency, String toCurrency, JSONObject rates) {
        if (!rates.has(fromCurrency) || !rates.has(toCurrency)) {
            System.out.println("Moneda no disponible.");
            return;
        }
        double fromRate = rates.getDouble(fromCurrency);
        double toRate = rates.getDouble(toCurrency);
        double convertedAmount = amount * (toRate / fromRate);
        System.out.printf("La cantidad convertida es: %.2f %s\n", convertedAmount, toCurrency);
    }
}