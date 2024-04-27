import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaDivisa consulta = new ConsultaDivisa();
        Scanner lectura2 = new Scanner(System.in);
        ConsultaDivisa consulta2 = new ConsultaDivisa();
        Scanner lectura3 = new Scanner(System.in);
        ConsultaDivisa consulta3 = new ConsultaDivisa();


        System.out.println("****************************************************************");
        System.out.println("Sea bienvenido al Conversor Universal: \nAnote en mayuscula, el codigo de divisa  de los paises a convertir, asi tambien la monto de dinero: " +
                "\n\nEjemplo:USA Dolares= USD a Colones de Costa Rica= CRC, Monto= 90 Dolares" +
                "\nEjemplo:Costa Rica= CRC a  USA Dolares= USD,  Monto= 90.8 Colones" +"\n\nCodigos de Divisa mas comunes:"+"\nDolar Americano= USD " +"\nColon de Costa Rica= CRC"+ "\nReal Brazileno= BRL " +
                "\nPeso Cubano= CUP" + "\nPeso Argentino= ARS " + "\nPeso Chileno= CLP " + "\nPeso Colombiano= COP " + "\nEspaña= EUR " );

        System.out.println("\n**************************************************************");


        Divisa divisa = null;
        try {
            System.out.println("Ingresa el primer Codigo de divisa");
            var code = lectura.nextLine();
            System.out.println("Ingresa el segundo Codigo de divisa");
            var base_code = lectura2.nextLine();
            System.out.println("Ingresa el monto numerico  de tu divisa");
            var monto = Double.parseDouble(lectura3.nextLine());

            double tasaConversion = consulta3.consultaDivisa(code).conversion_rates().get(base_code);


            double montoConvertido = monto * tasaConversion;

            System.out.println("Monto convertido: " + montoConvertido + " "+ base_code);



        } catch (NumberFormatException e) {
            System.out.println("Error: Por favor, ingrese un monto válido.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println("Se suspende la conversion");
        }
    }
}
