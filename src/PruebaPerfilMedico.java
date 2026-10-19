import java.util.Scanner;
import java.time.LocalDate;

public class PruebaPerfilMedico {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int anioActual = LocalDate.now().getYear();

        System.out.println("=== SISTEMA DE REGISTRO MÉDICO COMPUTARIZADO ===");
        String nombre = leerSoloLetras(entrada, "Ingrese el primer nombre del paciente: ");
        String apellido = leerSoloLetras(entrada, "Ingrese el apellido del paciente: ");
        String sexo = leerSexo(entrada, "Ingrese el sexo del paciente (M / F): ");
        int dia = leerEnteroRango(entrada, "Ingrese el día de nacimiento (1 - 31): ", 1, 31);
        int mes = leerEnteroRango(entrada, "Ingrese el mes de nacimiento (1 - 12): ", 1, 12);
        int anio = leerEnteroRango(entrada, "Ingrese el año de nacimiento (1900 - " + anioActual + "): ", 1900, anioActual);
        double altura = leerDoubleRango(entrada, "Ingrese la altura en centímetros (30 - 260): ", 30.0, 260.0);
        double peso = leerDoubleRango(entrada, "Ingrese el peso en kilogramos (2 - 400): ", 2.0, 400.0);

        // Crear instancia de PerfilMedico
        PerfilMedico paciente = new PerfilMedico(nombre, apellido, sexo, dia, mes, anio, altura, peso);

        // Mostrar resultados en consola
        System.out.println("\n=== PERFIL MÉDICO DEL PACIENTE ===");
        System.out.printf("Nombre: %s %s%n", paciente.obtenerPrimerNombre(), paciente.obtenerApellido());
        System.out.printf("Sexo: %s%n", paciente.obtenerSexo());
        System.out.printf("Fecha de nacimiento: %d/%d/%d%n", paciente.obtenerDiaNacimiento(), paciente.obtenerMesNacimiento(), paciente.obtenerAnioNacimiento());
        System.out.printf("Altura: %.1f cm | Peso: %.1f kg%n", paciente.obtenerAltura(), paciente.obtenerPeso());

        System.out.println("\n=== CÁLCULOS MÉDICOS ===");
        System.out.printf("Edad: %d años%n", paciente.obtenerEdad());
        System.out.printf("Índice de Masa Corporal (BMI): %.2f%n", paciente.obtenerBMI());
        System.out.printf("Frecuencia cardiaca máxima: %d ppm%n", paciente.obtenerFrecuenciaCardiacaMaxima());
        System.out.printf("Frecuencia cardiaca esperada: %s%n", paciente.obtenerFrecuenciaCardiacaEsperada());

        System.out.println("\n=== VALORES DE BMI ===");
        System.out.println("Bajo peso: menos de 18.5");
        System.out.println("Normal:    entre 18.5 y 24.9");
        System.out.println("Sobrepeso: entre 25 y 29.9");
        System.out.println("Obeso:     30 o más");

        entrada.close();
    }

    public static String leerSoloLetras(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine().trim();
            if (!input.isEmpty() && input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                return input;
            }
            System.out.println("  [Error] Ingrese únicamente letras sin números ni símbolos.");
        }
    }

    public static String leerSexo(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine().trim().toUpperCase();
            if (input.equals("M") || input.equals("F") || input.equals("MASCULINO") || input.equals("FEMENINO")) {
                return input;
            }
            System.out.println("  [Error] Ingrese únicamente 'M' (Masculino) o 'F' (Femenino).");
        }
    }

    public static int leerEnteroRango(Scanner sc, String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine().trim();
            try {
                int valor = Integer.parseInt(input);
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("  [Error] El valor debe estar entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("  [Error] Debe ingresar un número entero válido (sin letras).");
            }
        }
    }

    public static double leerDoubleRango(Scanner sc, String mensaje, double min, double max) {
        while (true) {
            System.out.print(mensaje);
            String input = sc.nextLine().trim().replace(',', '.');
            try {
                double valor = Double.parseDouble(input);
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("  [Error] Ingrese un valor coherente entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("  [Error] Debe ingresar un valor numérico válido.");
            }
        }
    }
}