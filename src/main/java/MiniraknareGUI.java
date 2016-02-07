import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.beans.ExceptionListener;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Field;

/**
 * Created by robin on 2016-02-07.
 */
public class MiniraknareGUI implements ActionListener {
    private JPanel jPanel;
    private JTextField calcInput;
    private JButton eqButton;
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    private JButton sqrtButton;
    private JButton piButton;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a0Button;
    private JButton decButton;
    private JButton clrButton;
    private JButton prevButton;
    private JButton nextButton;
    private Miniraknare miniraknare = new Miniraknare();
    private boolean calculated = true;

    public static void main(String[] args) {
        new MiniraknareGUI();
    }

    public MiniraknareGUI() {
        JFrame jFrame = new JFrame(miniraknare.getName() + " " + miniraknare.getVersion());
        jFrame.setContentPane(this.jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

        //Addera ActionListener på alla Jbuttons och JTextFields.
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                if (field.get(this).getClass() == JButton.class) {
                    ((JButton) field.get(this)).addActionListener(this);
                } else if (field.get(this).getClass() == JTextField.class) {
                    ((JTextField) field.get(this)).addActionListener(this);
                }
            } catch (Exception e) {

            }
        }
    }

    private void calculate() {
        if (!calcInput.getText().equals("")) {
            calcInput.setText(miniraknare.parseString(calcInput.getText()));
            calculated = true;
        }
    }

    private void calculateSqrt() {
        String result = miniraknare.parseString(calcInput.getText());
        try {
            calcInput.setText("" + miniraknare.kvadratroten(Double.valueOf(result)));
        } catch (Exception e){

        }
        calculate();
    }

    private void addSymbol(String s) {
        if (calculated && ! miniraknare.checkValidRaknesatt(s)) {
            clear();
        }
        calcInput.setText(calcInput.getText() + s);
        calculated = false;
    }

    private void clear() {
        calcInput.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Fulhackat eftersom jag inte orkar ta reda på hur Idea vill att jag ska skapa knapparna.
        //Borde titta på eventet i stället. Detta skulle fungera väldigt dåligt t.ex. vid översättning av knapparna.
        if (e.getSource().getClass() == JButton.class) {
            String key = ((JButton) e.getSource()).getText();
            if (key.equals("=")) {
                calculate();
            } else if (key.equals("sqrt")) {
                calculateSqrt();
            } else if (key.equals("C")) {
                clear();
            } else if (key.equals("prev")) {
                calcInput.setText(miniraknare.getPrevHistory());
            } else if (key.equals("next")) {
                calcInput.setText(miniraknare.getNextHistory());
            } else {
                addSymbol(key);
            }
        } else if (e.getSource().getClass() == JTextField.class) {
            calculate();
        }
    }
}
