import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Conversor conversor = new Conversor();

        Scanner escritura = new Scanner(System.in);
        int option = 1;

        HashMap<Integer, String> options = new HashMap<Integer, String>();
        options.put(1, "ARS");
        options.put(2, "BOB");
        options.put(3, "BRL");
        options.put(4, "CLP");
        options.put(5, "COP");
        options.put(6, "USD");
        options.put(7, "MXN");

        String countryOptions = """
                #############################
                1. ARS - Peso Argentino
                2. BOB - Boliviano boliviano
                3. BRL - Real brasileño
                4. CLP - Peso chileno
                5. COP - Peso colombiano
                6. USD - Dólar estadounidense
                7. MXN - Peso mexicano
                #############################
                """;


        while(option != 0) {
            System.out.println("\n-- Bienvenido al conversor de monedas --");
            System.out.println(countryOptions);

            try {
                System.out.println("Escribe el número del país de la moneda BASE");
                int baseCountry = escritura.nextInt();

                System.out.println("Escribe el número del país de la moneda OBJETIVO");
                int targetCountry = escritura.nextInt();

                if (!options.containsKey(baseCountry) || !options.containsKey(targetCountry)) {
                    System.out.println("ERROR: Escribe valores validos");
                    continue;
                }

                System.out.println("Escribe la cantidad a realizar la conversión: ");
                double dinero = escritura.nextDouble();

                Moneda cambio = conversor.convertirMoneda(options.get(baseCountry), options.get(targetCountry), dinero);
                System.out.println("$"+ dinero + " " + options.get(baseCountry) + " es igual a " + cambio);

                System.out.println("Escribe 1 para 'CONTINUAR' o 0 para 'SALIR'");
                option = escritura.nextInt();

            }catch (InputMismatchException e){
                System.out.println("ERROR: Debes escribir números validos");
                break;
            }

        }
        System.out.println("Cerrando el programa");
    }
}
