package util;

import Application.Scene2;
import javafx.scene.input.KeyEvent;

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

    // public void keyTyped1(KeyEvent evt) {
    // int key = evt.getKeyChar();

    // boolean mayusculas = key >= 65 && key <= 90;
    // boolean minusculas = key >= 97 && key <= 122;
    // boolean espacio = key == 32;

    // if (!(minusculas || mayusculas || espacio)) {
    // evt.consume();
    // }
    // }

    // public void keyTyped2(KeyEvent e) {
    // int limite = 6;
    // if (MatriculaTextField.getText().length() == limite) {
    // e.consume();
    // }
    // int key = e.getKeyChar();

    // boolean numeros = key >= 48 && key <= 57;

    // if (!numeros) {
    // e.consume();
    // }
    // }

    // public void keyTyped3(KeyEvent e) {
    // int limite = 20;
    // if (TermianlTextField.getText().length() == limite) {
    // e.consume();
    // }
    // int key = e.getKeyChar();

    // boolean numeros = key >= 48 && key <= 57;

    // if (!numeros) {
    // e.consume();
    // }
    // }

    // public void keyTyped4(KeyEvent e) {
    // int limite = 20;
    // if (TermianlTextField.getText().length() == limite) {
    // e.consume();
    // }
    // int key = e.getKeyChar();

    // boolean numeros = key >= 48 && key <= 57;

    // if (!numeros) {
    // e.consume();
    // }
    // }

}
