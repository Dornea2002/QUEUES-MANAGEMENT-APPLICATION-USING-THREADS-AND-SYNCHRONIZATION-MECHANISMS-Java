package Simulation;

import Frame.MainFrame;
import Frame.SecondFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationMainFrame {

    private final MainFrame frame;

    public SimulationMainFrame() {
        frame = new MainFrame();
        frame.addSimulateButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int clientNumber;
                int queueNumber;
                int simulationTime;
                int minArrivalTime;
                int maxArrivalTime;
                int minTaskTime;
                int maxTaskTime;
                //get informations from main frame
                try {
                    clientNumber = frame.getClientNumberJTextField();
                    queueNumber = frame.getQueueNumberJTextField();
                    simulationTime = frame.getSimulationTimeJTextField();
                    minArrivalTime = frame.getMinArrvialTimeJTextField();
                    maxArrivalTime = frame.getMaxArrvialTimeJTextField();
                    minTaskTime = frame.getMinTaskTimeJTextField();
                    maxTaskTime = frame.getMaxTaskTimeJTextField();
                } catch (Exception exp) {
                    //show error if the user did not complete all gaps
                    frame.errorMessage("Please fill each gap!");
                    return;
                }

                if (queueNumber > 10) { //check if the user enterd under 10 queues
                    frame.errorMessage("You can not have more than 10 queues!");
                } else if (minArrivalTime > maxArrivalTime) {//check if the user enterd arrival time correctly
                    frame.errorMessage("Minimum arrival time can not be bigger than maximum arrival time!");
                } else if (minTaskTime > maxTaskTime) { //check if user entered task time correctly
                    frame.errorMessage("Minimum task time can not be bigger than maximum task time!");
                } //if all is ok then we create the second frame to simulate
                else
                    //create a simulation using informations from main frame
                    new SimulationSecondFrame(clientNumber, queueNumber, simulationTime, minArrivalTime, maxArrivalTime, minTaskTime, maxTaskTime);
            }
        });
    }
}

