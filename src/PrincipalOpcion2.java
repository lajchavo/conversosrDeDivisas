import java.util.Scanner;

public class PrincipalOpcion2 {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaDivisa consulta = new ConsultaDivisa();

        System.out.println("****************************************************************");
        System.out.println("Sea bienvenido al Conversor " );

        System.out.println("\n**************************************************************");

        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            System.out.println("Seleccione una opción:");
            int opcion = lectura.nextInt();
            lectura.nextLine(); // Consumir el salto de línea después de leer un entero

            switch (opcion) {
                case 1:
                    convertirDivisa("USD", "ARS", consulta, lectura);
                    break;
                case 2:
                    convertirDivisa("ARS", "USD", consulta, lectura);
                    break;
                case 3:
                    convertirDivisa("USD", "BRL", consulta, lectura);
                    break;
                case 4:
                    convertirDivisa("BRL", "USD", consulta, lectura);
                    break;
                case 5:
                    convertirDivisa("USD", "CRC", consulta, lectura);
                    break;
                case 6:
                    convertirDivisa("CRC", "USD", consulta, lectura);
                    break;
                case 7:
                    convertirDivisa("USD", "COP", consulta, lectura);
                    break;
                case 8:
                    convertirDivisa("COP", "USD", consulta, lectura);
                    break;
                case 9:
                    continuar = false;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del 1 al 9.");
                    break;
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1) Dólar a Peso Argentino");
        System.out.println("2) Peso Argentino a Dólar");
        System.out.println("3) Dólar a Real Brasileño");
        System.out.println("4) Real Brasileño a Dólar");
        System.out.println("5) Dólar a Colón");
        System.out.println("6) Colón a Dólar");
        System.out.println("7) Dólar a Peso Colombiano");
        System.out.println("8) Peso Colombiano a Dólar");
        System.out.println("9) Salir");
    }

    public static void convertirDivisa(String code, String base_code, ConsultaDivisa consulta, Scanner lectura) {
        System.out.println("Ingresa el monto numérico de tu divisa:");
        try {
            double monto = Double.parseDouble(lectura.nextLine());

            double tasaConversion = consulta.consultaDivisa(code).conversion_rates().get(base_code);

            double montoConvertido = monto * tasaConversion;

            System.out.println("Monto convertido: " + montoConvertido + " " + base_code);
        } catch (NumberFormatException e) {
            System.out.println("Error: Por favor, ingrese un monto válido.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Se suspende la conversión");
        }
    }
}
