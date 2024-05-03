/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.*;
import org.junit.*;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class CalculadoraTest {

    private Calculadora calculadora;

    @Before
    public void setUp() {
        calculadora = new Calculadora();
        calculadora.setVisible(true); // Hacer visible para permitir la interacción con los botones
    }

    @Test
    public void testSuma() {
        // Simular entrada de números y operación
        presionarBotones("1", "2", "+", "3", "=");
        assertEquals("15.0", calculadora.display.getText());
    }

    @Test
    public void testResta() {
        // Simular entrada de números y operación
        presionarBotones("5", "2", "-", "3", "=");
        assertEquals("49.0", calculadora.display.getText());
    }

    @Test
    public void testMultiplicacion() {
        // Simular entrada de números y operación
        presionarBotones("8", "*", "6", "=");
        assertEquals("48.0", calculadora.display.getText());
    }

    @Test
    public void testDivision() {
        // Simular entrada de números y operación
        presionarBotones("9", "/", "3", "=");
        assertEquals("3.0", calculadora.display.getText());
    }

    @Test
    public void testDivisionPorCero() {
        // Simular entrada de números y operación
        presionarBotones("8", "/", "0", "=");
        assertEquals("Error", calculadora.display.getText());
    }

    @Test
    public void testBorrado() {
        // Simular entrada y borrado
        presionarBotones("1", "2", "3", "4", "5", "←");
        assertEquals("1234", calculadora.display.getText());
    }

    @Test
    public void testLimpiar() {
        // Simular entrada y limpieza
        presionarBotones("1", "2", "C");
        assertEquals("", calculadora.display.getText());
    }

    private void presionarBotones(String... botones) {
        for (String boton : botones) {
            for (JButton btn : calculadora.botones) {
                if (btn.getText().equals(boton)) {
                    ActionEvent evento = new ActionEvent(btn, ActionEvent.ACTION_PERFORMED, boton);
                    btn.getActionListeners()[0].actionPerformed(evento);
                    break;
                }
            }
        }
    }
}



