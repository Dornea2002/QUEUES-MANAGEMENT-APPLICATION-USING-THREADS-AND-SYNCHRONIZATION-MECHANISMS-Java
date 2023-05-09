package Frame;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JTextField clientNumberJTextField;
    private JTextField queueNumberJTextField;

    private JTextField simulationTimeJTextField;

    private JTextField minArrvialTimeJTextField;
    private JTextField minTaskTimeJTextField;

    private JTextField maxArrvialTimeJTextField;
    private JTextField maxTaskTimeJTextField;

    private JButton simulateJButton;

    private JLabel titleJLabel;

    private JLabel clientNumberJLabel;
    private JLabel queueNumberJLabel;

    private JLabel simulationTimeJLabel;

    private JLabel minArrvialTimeJLabel;
    private JLabel minTaskTimeJLabel;

    private JLabel maxArrvialTimeJLabel;
    private JLabel maxTaskTimeJLabel;

    public MainFrame() {

        Color color1=new Color(205, 199,118);
        Color color2=new Color(165, 170,82);

        this.setTitle("Main Frame");
        this.setBounds(600, 400, 600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(color1);
        this.getContentPane().setLayout(null);

        titleJLabel = new JLabel();
        titleJLabel.setText("Please fill the gaps!");
        titleJLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        titleJLabel.setBounds(220, 20, 200, 25);
        this.getContentPane().add(titleJLabel);

        clientNumberJLabel = new JLabel();
        clientNumberJLabel.setText("Number of clients: ");
        clientNumberJLabel.setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        clientNumberJLabel.setBounds(50, 100, 150, 25);
        this.getContentPane().add(clientNumberJLabel);

        queueNumberJLabel = new JLabel();
        queueNumberJLabel.setText("Number of queues: ");
        queueNumberJLabel.setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueNumberJLabel.setBounds(300, 100, 150, 25);
        this.getContentPane().add(queueNumberJLabel);

        minArrvialTimeJLabel = new JLabel();
        minArrvialTimeJLabel.setText("Minimum arrival time: ");
        minArrvialTimeJLabel.setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        minArrvialTimeJLabel.setBounds(50, 175, 200, 25);
        this.getContentPane().add(minArrvialTimeJLabel);

        maxArrvialTimeJLabel = new JLabel();
        maxArrvialTimeJLabel.setText("Maximum arrival time: ");
        maxArrvialTimeJLabel.setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        maxArrvialTimeJLabel.setBounds(300, 175, 200, 25);
        this.getContentPane().add(maxArrvialTimeJLabel);

        minTaskTimeJLabel = new JLabel();
        minTaskTimeJLabel.setText("Minimum task time: ");
        minTaskTimeJLabel.setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        minTaskTimeJLabel.setBounds(50, 250, 200, 25);
        this.getContentPane().add(minTaskTimeJLabel);

        maxTaskTimeJLabel = new JLabel();
        maxTaskTimeJLabel.setText("Maximum task time: ");
        maxTaskTimeJLabel.setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        maxTaskTimeJLabel.setBounds(300, 250, 200, 25);
        this.getContentPane().add(maxTaskTimeJLabel);

        simulationTimeJLabel = new JLabel();
        simulationTimeJLabel.setText("Simulation time: ");
        simulationTimeJLabel.setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        simulationTimeJLabel.setBounds(50, 325, 200, 25);
        this.getContentPane().add(simulationTimeJLabel);

        simulateJButton = new JButton();
        simulateJButton.setText("Simulate");
        simulateJButton.setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        simulateJButton.setBounds(300, 325, 200, 25);
        simulateJButton.setBackground(color2);
        this.getContentPane().add(simulateJButton);

        clientNumberJTextField = new JTextField();
        clientNumberJTextField.setBounds(225, 105, 50, 20);
        clientNumberJTextField.setBackground(color2);
        this.getContentPane().add(clientNumberJTextField);

        queueNumberJTextField = new JTextField();
        queueNumberJTextField.setBounds(475, 105, 50, 20);
        queueNumberJTextField.setBackground(color2);
        this.getContentPane().add(queueNumberJTextField);

        minArrvialTimeJTextField = new JTextField();
        minArrvialTimeJTextField.setBounds(225, 180, 50, 20);
        minArrvialTimeJTextField.setBackground(color2);
        this.getContentPane().add(minArrvialTimeJTextField);

        maxArrvialTimeJTextField = new JTextField();
        maxArrvialTimeJTextField.setBounds(475, 180, 50, 20);
        maxArrvialTimeJTextField.setBackground(color2);
        this.getContentPane().add(maxArrvialTimeJTextField);

        minTaskTimeJTextField = new JTextField();
        minTaskTimeJTextField.setBounds(225, 255, 50, 20);
        minTaskTimeJTextField.setBackground(color2);
        this.getContentPane().add(minTaskTimeJTextField);

        maxTaskTimeJTextField = new JTextField();
        maxTaskTimeJTextField.setBounds(475, 255, 50, 20);
        maxTaskTimeJTextField.setBackground(color2);
        this.getContentPane().add(maxTaskTimeJTextField);

        simulationTimeJTextField = new JTextField();
        simulationTimeJTextField.setBounds(225, 330, 50, 20);
        simulationTimeJTextField.setBackground(color2);
        this.getContentPane().add(simulationTimeJTextField);

        this.setVisible(true);
    }

    public int getClientNumberJTextField() {
        return Integer.parseInt(clientNumberJTextField.getText());
    }

    public int getQueueNumberJTextField() {
        return Integer.parseInt(queueNumberJTextField.getText());
    }

    public int getSimulationTimeJTextField() {
        return Integer.parseInt(simulationTimeJTextField.getText());
    }

    public int getMinArrvialTimeJTextField() {
        return Integer.parseInt(minArrvialTimeJTextField.getText());
    }

    public int getMinTaskTimeJTextField() {
        return Integer.parseInt(minTaskTimeJTextField.getText());
    }

    public int getMaxArrvialTimeJTextField() {
        return Integer.parseInt(maxArrvialTimeJTextField.getText());
    }

    public int getMaxTaskTimeJTextField() {
        return Integer.parseInt(maxTaskTimeJTextField.getText());
    }

    public void addSimulateButtonListener(ActionListener listener){
        simulateJButton.addActionListener(listener);
    }

    public void errorMessage(String string){
        JOptionPane.showMessageDialog(this, string, "Error", JOptionPane.PLAIN_MESSAGE);
    }
}
