import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) throws Exception {
        ConversorMonedas conversorMonedas = new ConversorMonedas();

        JFrame frame = new JFrame("Conversor Divisas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel inputLabel = new JLabel("Monto:");
        inputLabel.setBounds(50, 50, 100, 30);
        JLabel flechaLabel = new JLabel(">");
        flechaLabel.setBounds(195, 100, 100, 30);

        JTextField inputMonto = new JTextField();
        inputMonto.setBounds(100, 50, 200, 30);

        JTextField inputResultado = new JTextField();
        inputResultado.setBounds(100, 200, 200, 30);
        inputResultado.setHorizontalAlignment(JTextField.CENTER);
        inputResultado.setEditable(false);

        ArrayList<String> divisas = conversorMonedas.getCurrencies();
        JComboBox<String> comboboxOrigen = new JComboBox<>(divisas.toArray(new String[0]));
        comboboxOrigen.setBounds(100, 100, 70, 25);
        JComboBox<String> comboboxObjetivo = new JComboBox<>(divisas.toArray(new String[0]));
        comboboxObjetivo.setBounds(230, 100, 70, 25);

        JButton buttonConvertir = new JButton("Convertir");
        buttonConvertir.setBounds(150, 150, 100, 25);

        panel.add(buttonConvertir);
        panel.add(comboboxOrigen);
        panel.add(comboboxObjetivo);
        panel.add(inputLabel);
        panel.add(inputResultado);
        panel.add(flechaLabel);
        panel.add(inputMonto);
        frame.add(panel);
        frame.setVisible(true);

        // Actions

        buttonConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valorTexto = inputMonto.getText();
                try {
                    // Intentar convertir el valor a Double y establecerlo en la instancia de
                    // ConversorMonedas
                    double valor = Double.parseDouble(valorTexto);
                    conversorMonedas.setMonto(valor);

                    //valor del comboboxOrigen
                    String valorDivisaOrigen = (String) comboboxOrigen.getSelectedItem();
                    conversorMonedas.setFuente(valorDivisaOrigen);
                    //Valor del comboboxObjetivo
                    String valorDivisaObjetivo = (String) comboboxObjetivo.getSelectedItem();
                    conversorMonedas.setObjetivo(valorDivisaObjetivo);

                    //Resultado
                    double obtenerResultado = conversorMonedas.ConversorMonedas();
                    String resultado = String.valueOf(obtenerResultado);
                    inputResultado.setText(resultado);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Valor no válido. Ingrese un número válido.");
                }
            }
        });

    }
}
