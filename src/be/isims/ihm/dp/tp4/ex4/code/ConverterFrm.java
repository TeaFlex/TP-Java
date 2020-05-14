package be.isims.ihm.dp.tp4.ex4.code;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterFrm extends JFrame implements Observer {

    private JPanel container = new JPanel();
    private JTextField field1 = new JTextField();
    private JLabel f1Label = new JLabel("EUR");
    private JTextField field2 = new JTextField();
    private JLabel f2Label = new JLabel("USD");
    private JTextField rate = new JTextField();
    private JRadioButton convert = new JRadioButton();
    private JRadioButton taxes = new JRadioButton();
    private AbstractController controler;

    public ConverterFrm(AbstractController c) {
        this.controler = c;
        this.setTitle("TP4 ex4 Convertisseur de devise");
        this.setMinimumSize(new Dimension(500, 100));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initUI();
        this.setContentPane(container);
        this.setVisible(true);
    }

    private void initUI() {
        this.container.setLayout(new BoxLayout(this.container, BoxLayout.PAGE_AXIS));
        JPanel line1 = new JPanel();
        line1.setLayout(new BoxLayout(line1, BoxLayout.LINE_AXIS));
        JPanel line2 = new JPanel();
        line2.setLayout(new BoxLayout(line2, BoxLayout.LINE_AXIS));

        TextListener t = new TextListener();
        this.field1.getDocument().addDocumentListener(t);
        this.field2.getDocument().addDocumentListener(t);

        line1.add(this.field1);
        line1.add(this.f1Label);
        ButtonGroup group = new ButtonGroup();
        group.add(this.convert);
        group.add(this.taxes);
        RadioListener r = new RadioListener();
        this.convert.setSelected(true);
        this.convert.addActionListener(r);
        this.taxes.addActionListener(r);
        line1.add(this.convert);
        line1.add(new JLabel("Montant"));
        line1.add(this.taxes);
        line1.add(new JLabel("Taxe"));

        line2.add(this.field2);
        line2.add(this.f2Label);
        this.rate.setText("21");
        this.rate.getDocument().addDocumentListener(t);
        this.rate.setEditable(false);
        line2.add(this.rate);
        line2.add(new JLabel("%"));

        this.container.add(line1);
        this.container.add(line2);

    }

    public void update(String value, String target, String rate){
        if(target.equals("USD") || target.equals("TTC")){
            this.field2.setText(value);
        }
        else if(target.equals("EUR") || target.equals("HT")) {
            this.field1.setText(value);
        }
    }

    class RadioListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(convert.isSelected()){
                rate.setEditable(false);
                f1Label.setText("EUR");
                f2Label.setText("USD");
                rate.setText(rate.getText().equals("") ? "21" : rate.getText());
                clearFields();
            }
            else{
                rate.setEditable(true);
                f1Label.setText("HT");
                f2Label.setText("TTC");
                clearFields();
            }
        }

        public void clearFields(){
            field1.setText("");
            field2.setText("");
        }
    }

    class TextListener implements DocumentListener {
        public void changedUpdate(DocumentEvent e){
        }

        public void removeUpdate(DocumentEvent e){
            calculate(e);
        }

        public void insertUpdate(DocumentEvent e){
            calculate(e);
        }

        public void calculate(DocumentEvent e) {
            if(convert.isSelected()){
                if(field1.hasFocus())
                    controler.setValue(field1.getText(), "USD");
                else if(field2.hasFocus())
                    controler.setValue(field2.getText(), "EUR");
            }
            else{
                if(field1.hasFocus())
                    controler.setValue(field1.getText(), "TTC", rate.getText());
                else if(field2.hasFocus())
                    controler.setValue(field2.getText(), "HT", rate.getText());
                else if(rate.hasFocus()){
                    if(field1.getText().equals("")){
                        controler.setValue(field2.getText(), "HT", rate.getText());
                    }
                    else if(field2.getText().equals("")){
                        controler.setValue(field1.getText(), "TTC", rate.getText());
                    }
                }
            }
        }
    }
}
