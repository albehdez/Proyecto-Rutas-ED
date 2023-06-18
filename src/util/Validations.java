package util;

public class Validations {

    public static String validateBus(String tuition) {
        if (tuition.equalsIgnoreCase("") || tuition == null)
            throw new IllegalArgumentException("El numero de la matricula debe ser introducido");
        if (tuition.length() == 6)
            tuition = "B" + " " + tuition.substring(0, 3) + " " + tuition.substring(3, 6);
        else
            throw new IllegalArgumentException("El numero de  la matricula debe tener 6 digitos");
        return tuition;
    }
}
