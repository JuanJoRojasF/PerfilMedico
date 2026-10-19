import java.time.LocalDate;

public class PerfilMedico {
    private String primerNombre;
    private String apellido;
    private String sexo;
    private int diaNacimiento;
    private int mesNacimiento;
    private int anioNacimiento;
    private double altura; // en centímetros
    private double peso;   // en kilogramos

    // Constructor
    public PerfilMedico(String primerNombre, String apellido, String sexo, int diaNacimiento, int mesNacimiento, int anioNacimiento, double altura, double peso) {
        this.primerNombre = primerNombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.diaNacimiento = diaNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.anioNacimiento = anioNacimiento;
        this.altura = altura;
        this.peso = peso;
    }

    // Métodos establecer y obtener
    public void establecerPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String obtenerPrimerNombre() {
        return primerNombre;
    }

    public void establecerApellido(String apellido) {
        this.apellido = apellido;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public void establecerSexo(String sexo) {
        this.sexo = sexo;
    }

    public String obtenerSexo() {
        return sexo;
    }

    public void establecerDiaNacimiento(int diaNacimiento) {
        this.diaNacimiento = diaNacimiento;
    }

    public int obtenerDiaNacimiento() {
        return diaNacimiento;
    }

    public void establecerMesNacimiento(int mesNacimiento) {
        this.mesNacimiento = mesNacimiento;
    }

    public int obtenerMesNacimiento() {
        return mesNacimiento;
    }

    public void establecerAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public int obtenerAnioNacimiento() {
        return anioNacimiento;
    }

    public void establecerAltura(double altura) {
        this.altura = altura;
    }

    public double obtenerAltura() {
        return altura;
    }

    public void establecerPeso(double peso) {
        this.peso = peso;
    }

    public double obtenerPeso() {
        return peso;
    }

    // Calcular edad en años
    public int obtenerEdad() {
        int anioActual = LocalDate.now().getYear();
        return anioActual - anioNacimiento;
    }

    // Calcular frecuencia cardiaca máxima
    public int obtenerFrecuenciaCardiacaMaxima() {
        return 220 - obtenerEdad();
    }

    // Calcular rango de frecuencia cardiaca esperada
    public String obtenerFrecuenciaCardiacaEsperada() {
        double min = obtenerFrecuenciaCardiacaMaxima() * 0.50;
        double max = obtenerFrecuenciaCardiacaMaxima() * 0.85;
        return String.format("%.1f - %.1f ppm", min, max);
    }

    // Calcular el Índice de Masa Corporal (BMI)
    public double obtenerBMI() {
        double alturaEnMetros = altura / 100.0;
        return peso / (alturaEnMetros * alturaEnMetros);
    }
}