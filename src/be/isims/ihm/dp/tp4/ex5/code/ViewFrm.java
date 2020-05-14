package be.isims.ihm.dp.tp4.ex5.code;

import be.isims.ihm.dp.tp4.ex5.code.AbstractController;
import be.isims.ihm.dp.tp4.ex5.code.Observer;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

//VUE
public class ViewFrm extends JFrame implements Observer {

    private AbstractController controller;
    private JSlider sliders[] = {new JSlider(), new JSlider(), new JSlider()};
    private JSpinner spinners[] = {new JSpinner(), new JSpinner(), new JSpinner()};
    private JPanel lines[] = {new JPanel(), new JPanel(), new JPanel(), new JPanel()};
    private JLabel hexa = new JLabel();
    private int dec[] = {0,0,0};

    public ViewFrm(AbstractController controller) {
        this.controller = controller;
        this.setTitle("TP4 ex5");
        this.setMinimumSize(new Dimension(250, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initUI();
        this.setVisible(true);
    }

    public void initUI(){
        String colors[] = {"Red", "Green", "Blue"};
        Listener listener = new Listener();
        JPanel base = new JPanel();

        for (JPanel line : this.lines) line.setLayout(new FlowLayout());

        for(int i = 0; i<colors.length; i++) {
            lines[0].add(new JLabel(colors[i]));
            sliders[i].setOrientation(JSlider.VERTICAL);
            sliders[i].setMaximum(255);
            sliders[i].setValue(0);
            sliders[i].addChangeListener(listener);
            lines[1].add(sliders[i]);
            spinners[i].setPreferredSize(new Dimension(40, 20));
            spinners[i].addChangeListener(listener);
            lines[2].add(spinners[i]);
        }

        hexa.setText("0x000000");
        lines[3].setBackground(Color.BLACK);
        lines[3].setLayout(new FlowLayout());
        lines[3].add(this.hexa);

        base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));
        for (JPanel line : this.lines) base.add(line);
        this.setContentPane(base);
    }

    public void update(String value){
        this.hexa.setText("0x"+value);
        this.lines[3].setBackground(Color.decode("#"+value));
    }

    class Listener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            if(e.getSource().getClass().equals(JSlider.class)){
                for(int i = 0; i<sliders.length; i++) {
                    spinners[i].setValue(sliders[i].getValue());
                    dec[i] = sliders[i].getValue();
                }
            }
            else{
                for(int i = 0; i<spinners.length; i++) {
                    sliders[i].setValue(Integer.parseInt(spinners[i].getValue().toString()));
                    dec[i] = Integer.parseInt(spinners[i].getValue().toString());
                }
            }
            controller.notification(dec[0], dec[1], dec[2]);
        }
    }
}
