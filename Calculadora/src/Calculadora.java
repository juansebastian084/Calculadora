import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculadora extends JFrame implements ActionListener {

    JTextField display;
    JButton[] botones;
    String[] etiquetas = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "+"
    };
    private JButton botonLimpiar;
    private JButton botonBorrar;
    private JButton botonResultado;
    private String operador = "";
    private double primerNumero = 0;
    private double segundoNumero = 0;
    private boolean nuevoNumero = true;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4));

        botones = new JButton[16];
        for (int i = 0; i < 16; i++) {
            botones[i] = new JButton(etiquetas[i]);
            botones[i].addActionListener(this);
            panelBotones.add(botones[i]);
        }

        add(panelBotones, BorderLayout.CENTER);

        botonLimpiar = new JButton("C");
        botonLimpiar.addActionListener(this);
        botonBorrar = new JButton("←");
        botonBorrar.addActionListener(this);
        botonResultado = new JButton("=");
        botonResultado.addActionListener(this);

        JPanel panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new GridLayout(1, 3));
        panelOperaciones.add(botonLimpiar);
        panelOperaciones.add(botonBorrar);
        panelOperaciones.add(botonResultado);

        add(panelOperaciones, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if ("0123456789.".contains(comando)) {
            if (nuevoNumero) {
                display.setText(comando);
                nuevoNumero = false;
            } else {
                display.setText(display.getText() + comando);
            }
        } else if ("+-*/".contains(comando)) {
            operador = comando;
            primerNumero = Double.parseDouble(display.getText());
            nuevoNumero = true;
        } else if ("=".equals(comando)) {
            segundoNumero = Double.parseDouble(display.getText());
            switch (operador) {
                case "+":
                    display.setText(String.valueOf(primerNumero + segundoNumero));
                    break;
                case "-":
                    display.setText(String.valueOf(primerNumero - segundoNumero));
                    break;
                case "*":
                    display.setText(String.valueOf(primerNumero * segundoNumero));
                    break;
                case "/":
                    if (segundoNumero != 0) {
                        display.setText(String.valueOf(primerNumero / segundoNumero));
                    } else {
                        display.setText("Error");
                    }
                    break;
            }
            nuevoNumero = true;
        } else if ("C".equals(comando)) {
            display.setText("");
            nuevoNumero = true;
        } else if ("←".equals(comando)) {
            String texto = display.getText();
            if (texto.length() > 0) {
                texto = texto.substring(0, texto.length() - 1);
                display.setText(texto);
            }
        }
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        calc.setVisible(true);
    }
}
    

   




