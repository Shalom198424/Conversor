# Conversor

CurrencyConverterApp es una aplicación de consola en Java que permite convertir monedas entre el dólar estadounidense y varias monedas latinoamericanas (peso argentino, peso chileno y real brasileño) usando las tasas de cambio actuales obtenidas de una API externa.

## Características

- Conversión de USD a ARS, CLP, y BRL y viceversa.
- Interfaz de consola fácil de usar.
- Obtención automática de las tasas de cambio actualizadas mediante una API de Exchange Rate.

## Tecnologías utilizadas

- Java: Proyecto escrito en Java SE.
- API de Exchange Rate: Utiliza ExchangeRate API para obtener tasas de cambio en tiempo real.
- org.json: Biblioteca para el manejo de objetos JSON.

## Prerrequisitos
- Java 11 o superior.
- Conexión a Internet para acceder a las tasas de cambio actuales mediante la API.

## Instalación
1. Clona este repositorio en tu máquina local:
   ```bash
   git clone https://github.com/tu-usuario/tu-repositorio.git
   cd tu-repositorio

2. Asegúrate de tener Java instalado en tu sistema. Puedes verificar la instalación ejecutando:
   ```bash 
   java -version

3. Incluye la biblioteca org.json en tu proyecto. Puedes descargar el JAR desde Maven Repository.

## Configuración
1. En el archivo CurrencyConverterApp.java, reemplaza API_URL con tu clave de API obtenida de ExchangeRate API.

    ```java
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/TU_CLAVE_DE_API/latest/USD";
   
2. Asegúrate de que la clave de API sea válida y esté activa. Esto es necesario para obtener las tasas de cambio.

## Uso
1. Compila el programa:

   ```bash
    javac CurrencyConverterApp.java
   
2. Ejecuta el programa:

    ```bash
    java CurrencyConverterApp
    
3. En la consola, selecciona la opción de conversión que deseas realizar y proporciona la cantidad a convertir.

    ```plaintext
    --- Bienvenido al Conversor de Monedas ---
    1. Convertir de Dólar a Peso Argentino
    2. Convertir de Peso Argentino a Dólar
    3. Convertir de Dólar a Peso Chileno
    4. Convertir de Peso Chileno a Dólar
    5. Convertir de Dólar a Real Brasileño
    6. Convertir de Real Brasileño a Dólar
    7. Salir
   
4. Ingresa la cantidad y el programa mostrará el resultado de la conversión.

## Ejemplo de uso
Supón que deseas convertir 100 USD a ARS:

      Seleccione una opción: 1
      Ingrese la cantidad: 100
      La cantidad convertida es: 10000.00 ARS

## Posibles errores
- Error al obtener las tasas de cambio: Puede ocurrir si la conexión a Internet falla o si la clave de API es inválida o está caducada.
- Moneda no disponible: Si el tipo de moneda seleccionado no está en la respuesta de la API, se mostrará este mensaje.

## Contribuciones
Las contribuciones son bienvenidas. Si tienes ideas o mejoras, crea un pull request o abre un issue.

## Licencia
Este proyecto está bajo la Licencia MIT. Para más detalles, revisa el archivo LICENSE.
