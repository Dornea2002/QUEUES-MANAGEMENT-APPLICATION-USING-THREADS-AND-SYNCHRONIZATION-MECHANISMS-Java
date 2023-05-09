package Simulation;

import Entities.Clients;
import Entities.Queues;
import Frame.SecondFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public class SimulationSecondFrame implements Runnable { //all methods used to simulate the clients in the queues

    private final int queueNumber;
    private final int simulationTime;
    private final SecondFrame secondFrame;

    private List<Queues> queueList;
    private List<Clients> clientList;
    private FileWriter writer;
    AtomicInteger atomicSimulationTime;

    private float averageTaskTime;
    private float averageWaitingTime = 0;

    private int peakHour;
    private int maxNumberClients = 0;
    private int momentsNumber = 0;

    private final SimulationSecondFrame thisSimulation = this;

    public SimulationSecondFrame(int clientNumber, int queueNumber, int simulationTime, int minArrivalTime, int maxArrivalTime, int minTaskTime, int maxTaskTime) {

        secondFrame = new SecondFrame(queueNumber);
        //create thread for the second frame
        secondFrame.addStartButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread thread = new Thread(thisSimulation);
                thread.start();
            }
        });

        // memorate the information
        this.queueNumber = queueNumber;
        this.simulationTime = simulationTime;
        this.atomicSimulationTime = new AtomicInteger(0);
        this.queueList = new ArrayList<>();
        this.clientList = new ArrayList<>();

        //create all clients with random values
        createClients(clientNumber, minArrivalTime, maxArrivalTime, minTaskTime, maxTaskTime);

        //create all queues
        for (int i = 0; i < queueNumber; i++) {
            Queues queue = new Queues();
            queueList.add(queue);
        }

        //write in the write.txt file the result
        try {
            writer = new FileWriter("write.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //update the frame in real time
        updateFrame();
    }


    private void createClients(int clientNumber, int minArrivalTime, int maxArrivalTime, int minTaskTime, int maxTaskTime) {
        Random random = new Random();

        for (int i = 1; i <= clientNumber; i++) { //generate number of clients randomly
            int arrivalTime = random.nextInt(minArrivalTime, maxArrivalTime);
            int taskTime = random.nextInt(minTaskTime, maxTaskTime);

            clientList.add(new Clients(arrivalTime, taskTime));
        }

        Collections.sort(clientList); //sort the list ascending by arrival time

        averageTaskTime = 0;
        int id = 1;
        for (Clients c : clientList) { //set the id of the clients and calculate the average task time
            c.setIdClient(id);
            id++;
            averageTaskTime += c.getTaskTime();
        }

        averageTaskTime /= clientList.size();
    }

    private void updateFrame() {
        //update the real time
        secondFrame.setRealTime(String.format("%d", atomicSimulationTime.get()));

        //update the client list
        String waitingClientList = "";
        for (Clients client : clientList) {
            waitingClientList += String.format("[%d, %d, %d]\n", client.getIdClient(), client.getArrivalTime(), client.getTaskTime());
        }
        secondFrame.setWaitingClientsJTextArea(waitingClientList);

        //update each queue list with all the clients that are entering them
        for (int i = 0; i < queueNumber; i++) {
            String string = queueList.get(i).toString();
            secondFrame.setQueueListJTextField(i, string);
        }
    }

    //check if queues are opened or closed
    private boolean getQueueOpening() {
        for (Queues q : queueList) {
            if (q.isListIsOpen())
                return true;
        }
        return false;
    }

    //close queue method
    private void closeQueue() {
        for (Queues q : queueList) {
            q.closeList();
        }
    }

    private void distribution() {
        //distribute the clients by the arrival time
        for (int i = 0; i < clientList.size(); i++) { //iterate all client list
            int minWaitingTime = queueList.get(0).getWaitingTime();
            int queue = 0;
            for (int j = 0; j < queueList.size(); j++) { //iterate the queues list in which are clients waiting
                if (queueList.get(j).getWaitingTime() < minWaitingTime) {
                    minWaitingTime = queueList.get(j).getWaitingTime(); //find the minimum waiting time from all queues
                    queue = j;
                }
            }
            if (clientList.get(i).getArrivalTime() <= atomicSimulationTime.get()) { //if the client is ready to enter a queue
                Clients client = clientList.remove(i); //remove the client from the list
                queueList.get(queue).addClient(client); //add the client to the minimum queue found
                i--;
            }
        }
    }

    private void simulationStatus() {
        int numberOfClients = 0;
        float waitingTime = 0;

        //calculate number of clients and waiting time average
        for (Queues q : queueList) {
            numberOfClients += q.getClientsNumber();
            waitingTime += q.getWaitingTime();
        }

        //increase the moment number
        if (waitingTime != 0) {
            momentsNumber++;
        }
        //calculate the average waiting time
        averageWaitingTime += waitingTime / queueNumber;

        //calculate the peak hour by finding the time when the queues list had the maximum possible number
        if (numberOfClients > maxNumberClients) {
            maxNumberClients = numberOfClients;
            peakHour = atomicSimulationTime.get();
        }
    }

    @Override
    public void run() {
        for (Queues q : queueList) { //create thread for each queue
            Thread thread = new Thread(q);
            thread.start();
        }

        while (atomicSimulationTime.get() <= simulationTime || getQueueOpening()) { //while we still have time and the queue is opened
            updateFrame();
            if (atomicSimulationTime.get() >= simulationTime) {//if the simulation time is over the queue is closed
                closeQueue();
            }
            try {
                writer.write(toString());
                Thread.sleep(1000); //thread sleeps for 1 second
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            atomicSimulationTime.incrementAndGet(); //increase the real time
            distribution(); //add the next client to the queue
            simulationStatus(); //get status of the simulation
        }

        averageWaitingTime/=momentsNumber; //calculate the average time
        try{
            //write the end status in the write.txt file
            writer.write(String.format("\nThe average waiting time of the simulation: %.3f\nThe average task time of the simulation: %.3f\nThe peak hour of the simulation: %d\n", averageWaitingTime, averageTaskTime, peakHour));
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        //display the end status in the GUI
        secondFrame.errorMessage(String.format("\nThe average waiting time of the simulation: %.3f\nThe average task time of the simulation: %.3f\nThe peak hour of the simulation: %d\n", averageWaitingTime, averageTaskTime, peakHour));
    }

    @Override
    public String toString() { //to string method to display status in write.txt
        String string=String.format("\nReal Time: %d", atomicSimulationTime.get()); //add real time
        string+=String.format("\nWaiting clients: "); //add the still waiting clients
        for(Clients c:clientList){
            string+=String.format("[%d %d %d] ", c.getIdClient(), c.getArrivalTime(), c.getTaskTime());
        }

        for(int i=0; i<queueNumber; i++){ //add the queues with its clients
            string+=String.format("\nQueue %d: %s", i+1, queueList.get(i).toString());
        }
        string+=String.format("\r\n");
        return string;
    }
}
