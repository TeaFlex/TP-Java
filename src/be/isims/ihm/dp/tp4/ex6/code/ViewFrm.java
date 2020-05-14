package be.isims.ihm.dp.tp4.ex6.code;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class ViewFrm extends JFrame implements Observer {

    private AbstractController controller;
    private JTextField temperature = new JTextField();
    private JButton controls[] = {new JButton("-"), new JButton("+"), new JButton("Valider")};
    private Display display = new Display();
    private Font font = new Font("Comic sans Ms", 1, 40);

    public ViewFrm(AbstractController controller) {
        this.controller = controller;
        this.setTitle("TP4 ex6");
        this.setMinimumSize(new Dimension(200, 200));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initUI();
        this.setVisible(true);
    }

    public void initUI() {
        JPanel base = new JPanel();
        JPanel lines[] = {new JPanel(), new JPanel(), new JPanel()};
        JLabel label = new JLabel("°C");
        ButtonListener l = new ButtonListener();

        this.temperature.setFont(font);
        this.temperature.setPreferredSize(new Dimension(80, 50));
        lines[0].add(this.temperature);
        label.setFont(font);
        lines[0].add(label);

        lines[1].add(controls[0]);
        lines[1].add(controls[1]);

        lines[2].add(controls[2]);

        for (JPanel line : lines) base.add(line);
        for (JButton button : controls) button.addActionListener(l); ;

        base.setLayout(new BoxLayout(base, BoxLayout.PAGE_AXIS));
        this.setContentPane(base);
    }

    public void update(String value, String operation) {
        if(operation.equals("Valider")){
            this.display.setContent(value);
            this.display.setVisible(true);
        }
        else{
            this.temperature.setText(value);
        }
    }

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            controller.notification(temperature.getText(), ((JButton)e.getSource()).getText());
        }
    }

    class Display extends JFrame{

        private JLabel temperatureDisplay = new JLabel();

        public Display() {
        this.setTitle("AFFICHAGE");
            this.setMinimumSize(new Dimension(250, 250));
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            this.initUI();
            this.setVisible(false);
        }

        public void initUI() {
            JPanel base = new JPanel();
            this.setContent("0");
            this.temperatureDisplay.setFont(new Font("Comic sans Ms", 1, 80));
            base.add(this.temperatureDisplay);
            this.setContentPane(base);
        }

        public void setContent(String value) {
            this.temperatureDisplay.setText(value+ "°C");
        }
    }
}
