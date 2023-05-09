package Frame;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SecondFrame extends JFrame {

    private JLabel timeJLabel;
    private JTextField realTimeJTextField;

    private JLabel waitingClientsJlabel;
    private JScrollPane waitingClientsJScrollPane;
    private JTextArea waitingClientsJTextArea;

    private JButton startJButton;

    private List<JLabel> queueListJLabel;
    private List<JTextField> queueListJTextField;

    public SecondFrame(int queueNumber) {

        Color color1 = new Color(205, 199, 118);
        Color color2 = new Color(165, 170, 82);

        //Create the frame
        this.setTitle("Second Frame");
        this.setBounds(600, 600, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(color1);
        this.getContentPane().setLayout(null);

        //setup time simulation
        timeJLabel = new JLabel();
        timeJLabel.setText("TIME: ");
        timeJLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        timeJLabel.setBounds(250, 20, 200, 25);
        this.getContentPane().add(timeJLabel);

        realTimeJTextField = new JTextField();
        realTimeJTextField.setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        realTimeJTextField.setBounds(320, 20, 35, 25);
        realTimeJTextField.setBackground(color2);
        this.getContentPane().add(realTimeJTextField);

        //setup the waiting cient list
        waitingClientsJlabel = new JLabel();
        waitingClientsJlabel.setText("Waiting clients list ");
        waitingClientsJlabel.setBounds(20, 50, 200, 25);
        waitingClientsJlabel.setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        this.getContentPane().add(waitingClientsJlabel);

        waitingClientsJScrollPane = new JScrollPane();
        waitingClientsJScrollPane.setBounds(35, 80, 100, 400);
        waitingClientsJScrollPane.setBackground(color2);
        this.getContentPane().add(waitingClientsJScrollPane);

        waitingClientsJTextArea = new JTextArea();
        waitingClientsJScrollPane.setViewportView(waitingClientsJTextArea);
        waitingClientsJTextArea.setBackground(color2);
        waitingClientsJTextArea.setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));

        //setup the label for the 10 queues
        queueListJLabel=new ArrayList<>(10);

        queueListJLabel.add(new JLabel());
        queueListJLabel.get(0).setText("Queue 1: ");
        queueListJLabel.get(0).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJLabel.get(0).setBounds(185, 80, 100, 25);
//        this.getContentPane().add(queueListJLabel.get(0));

        queueListJLabel.add(new JLabel());
        queueListJLabel.get(1).setText("Queue 2: ");
        queueListJLabel.get(1).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJLabel.get(1).setBounds(185, 110, 100, 25);
//        this.getContentPane().add(queueListJLabel.get(1));

        queueListJLabel.add(new JLabel());
        queueListJLabel.get(2).setText("Queue 3: ");
        queueListJLabel.get(2).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJLabel.get(2).setBounds(185, 140, 100, 25);
//        this.getContentPane().add(queueListJLabel.get(2));

        queueListJLabel.add(new JLabel());
        queueListJLabel.get(3).setText("Queue 4: ");
        queueListJLabel.get(3).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJLabel.get(3).setBounds(185, 170, 100, 25);
//        this.getContentPane().add(queueListJLabel.get(3));

        queueListJLabel.add(new JLabel());
        queueListJLabel.get(4).setText("Queue 5: ");
        queueListJLabel.get(4).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJLabel.get(4).setBounds(185, 200, 100, 25);
//        this.getContentPane().add(queueListJLabel.get(4));

        queueListJLabel.add(new JLabel());
        queueListJLabel.get(5).setText("Queue 6: ");
        queueListJLabel.get(5).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJLabel.get(5).setBounds(185, 230, 100, 25);
//        this.getContentPane().add(queueListJLabel.get(5));

        queueListJLabel.add(new JLabel());
        queueListJLabel.get(6).setText("Queue 7: ");
        queueListJLabel.get(6).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJLabel.get(6).setBounds(185, 260, 100, 25);
//        this.getContentPane().add(queueListJLabel.get(6));

        queueListJLabel.add(new JLabel());
        queueListJLabel.get(7).setText("Queue 8: ");
        queueListJLabel.get(7).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJLabel.get(7).setBounds(185, 290, 100, 25);
//        this.getContentPane().add(queueListJLabel.get(7));

        queueListJLabel.add(new JLabel());
        queueListJLabel.get(8).setText("Queue 9: ");
        queueListJLabel.get(8).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJLabel.get(8).setBounds(185, 320, 100, 25);
//        this.getContentPane().add(queueListJLabel.get(8));

        queueListJLabel.add(new JLabel());
        queueListJLabel.get(9).setText("Queue 10: ");
        queueListJLabel.get(9).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJLabel.get(9).setBounds(185, 350, 100, 25);
//        this.getContentPane().add(queueListJLabel.get(9));

        //setup the text fields for the 10 queues
        queueListJTextField=new ArrayList<>(10);

        queueListJTextField.add(new JTextField());
        queueListJTextField.get(0).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJTextField.get(0).setBounds(260, 85, 300, 20);
        queueListJTextField.get(0).setColumns(10);
        queueListJTextField.get(0).setBackground(color2);
//        this.getContentPane().add(queueListJTextField.get(0));

        queueListJTextField.add(new JTextField());
        queueListJTextField.get(1).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJTextField.get(1).setBounds(260, 115, 300, 20);
        queueListJTextField.get(1).setColumns(10);
        queueListJTextField.get(1).setBackground(color2);
//        this.getContentPane().add(queueListJTextField.get(1));

        queueListJTextField.add(new JTextField());
        queueListJTextField.get(2).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJTextField.get(2).setBounds(260, 145, 300, 20);
        queueListJTextField.get(2).setColumns(10);
        queueListJTextField.get(2).setBackground(color2);
//        this.getContentPane().add(queueListJTextField.get(2));

        queueListJTextField.add(new JTextField());
        queueListJTextField.get(3).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJTextField.get(3).setBounds(260, 175, 300, 20);
        queueListJTextField.get(3).setColumns(10);
        queueListJTextField.get(3).setBackground(color2);
//        this.getContentPane().add(queueListJTextField.get(3));

        queueListJTextField.add(new JTextField());
        queueListJTextField.get(4).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJTextField.get(4).setBounds(260, 205, 300, 20);
        queueListJTextField.get(4).setColumns(10);
        queueListJTextField.get(4).setBackground(color2);
//        this.getContentPane().add(queueListJTextField.get(4));

        queueListJTextField.add(new JTextField());
        queueListJTextField.get(5).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJTextField.get(5).setBounds(260, 235, 300, 20);
        queueListJTextField.get(5).setColumns(10);
        queueListJTextField.get(5).setBackground(color2);
//        this.getContentPane().add(queueListJTextField.get(5));

        queueListJTextField.add(new JTextField());
        queueListJTextField.get(6).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJTextField.get(6).setBounds(260, 265, 300, 20);
        queueListJTextField.get(6).setColumns(10);
        queueListJTextField.get(6).setBackground(color2);
//        this.getContentPane().add(queueListJTextField.get(6));

        queueListJTextField.add(new JTextField());
        queueListJTextField.get(7).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJTextField.get(7).setBounds(260, 295, 300, 20);
        queueListJTextField.get(7).setColumns(10);
        queueListJTextField.get(7).setBackground(color2);
//        this.getContentPane().add(queueListJTextField.get(7));

        queueListJTextField.add(new JTextField());
        queueListJTextField.get(8).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJTextField.get(8).setBounds(260, 325, 300, 20);
        queueListJTextField.get(8).setColumns(10);
        queueListJTextField.get(8).setBackground(color2);
//        this.getContentPane().add(queueListJTextField.get(8));

        queueListJTextField.add(new JTextField());
        queueListJTextField.get(9).setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        queueListJTextField.get(9).setBounds(260, 355, 300, 20);
        queueListJTextField.get(9).setColumns(10);
        queueListJTextField.get(9).setBackground(color2);
//        this.getContentPane().add(queueListJTextField.get(9));

        //setup the simulation start button
        startJButton=new JButton();
        startJButton.setText("Start Simulation");
        startJButton.setFont(new Font("Tahoma", Font.TYPE1_FONT, 14));
        startJButton.setBounds(20, 500, 150, 30);
        startJButton.setBackground(color2);
        this.getContentPane().add(startJButton);

        //set visible the entered number queues
        for (int i=0; i<queueNumber; i++){
            this.getContentPane().add(queueListJLabel.get(i));
            this.getContentPane().add(queueListJTextField.get(i));
        }

        this.setVisible(true);
    }

    //update the real time in frame
    public void setRealTime(String string){
        this.realTimeJTextField.setText(string);
    }

    //update the client list waiting to join queues
    public void setWaitingClientsJTextArea(String string){
        this.waitingClientsJTextArea.setText(string);
    }

    //update each queue text field with the client who joined
    public void setQueueListJTextField(int id, String string){
        queueListJTextField.get(id).setText(string);
    }

    public void addStartButtonListener(ActionListener listener){
        startJButton.addActionListener(listener);
    }

    public void errorMessage(String string){
        JOptionPane.showMessageDialog(this, string, "Status", JOptionPane.PLAIN_MESSAGE);
    }

}
