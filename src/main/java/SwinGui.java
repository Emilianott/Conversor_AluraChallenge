import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SwinGui extends JFrame {
    private String textoIngresado;
    private JPanel MainPanel;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JTextField inputFiled;
    private JLabel resultado;
    private JButton convertir;
    private JLabel resultadoLabel;
    private String divisa1;
    private String divisa2;
    private JLabel text1;

    public SwinGui() {


        setContentPane(MainPanel);
        setLayout(null);
        setTitle("Conversor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);


        text1 = new JLabel("Introduce cantidad que deceas convertir y luego seleciona las Monedas");
        text1.setHorizontalAlignment(JLabel.CENTER);
        text1.setVerticalAlignment(JLabel.CENTER);
        text1.setBounds(0, 25, 500, 20);

        //Drop down 1

        String[] options = {"Divisas","Dolar", "Euro", "Libras Esterlina", "Yen Japones", "Won Sur Coreano", "Pesos Dominicano"};
        comboBox1 = new JComboBox<>(options);
        comboBox1.setBounds(60, 100, 120, 20);


        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el valor seleccionado del JComboBox
                 divisa1 = (String) comboBox1.getSelectedItem();



            }
        });

        //dropdown 2

        comboBox2 = new JComboBox<>(options);
        comboBox2.setBounds(300, 100, 120, 20);

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el valor seleccionado del JComboBox

                 divisa2 = (String) comboBox2.getSelectedItem();


            }
        });

        //input

        inputFiled = new JTextField();
        inputFiled.setBounds(190, 60, 100, 20);
        inputFiled.setHorizontalAlignment(JLabel.CENTER);




        //Boton

        convertir = new JButton("Convertir");
        convertir.setBounds(190, 200, 100, 20);

        convertir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {


                // Obtener el texto ingresado en el JTextField
                 textoIngresado = inputFiled.getText();
                Moneda moneda = new Moneda(Double.parseDouble(textoIngresado), divisa1,divisa2  );
                String monedaTexto=  moneda.convertirMoneda();
                 resultado.setText(monedaTexto);


            }
        });

        // Label Resultado

        resultado = new JLabel();
        resultado.setHorizontalAlignment(SwingConstants.CENTER);
        resultado.setVerticalAlignment(SwingConstants.CENTER);
        resultado.setOpaque(true);
        resultado.setBounds(190, 150, 100, 20);

        //Resultado Label

        resultadoLabel = new JLabel("Resultado: ");
        resultadoLabel.setBounds(120, 150, 120, 20);


        add(text1);
        add(comboBox1);
        add(comboBox2);
        add(inputFiled);
        add(resultado);
        add(convertir);
        add(resultadoLabel);


    }


    public static void main(String[] args) {
        new SwinGui();

    }

}
