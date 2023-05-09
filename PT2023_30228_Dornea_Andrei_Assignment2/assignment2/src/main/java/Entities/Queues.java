package Entities;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Queues implements Runnable{

    private int waitingTime;
    private BlockingQueue<Clients> clientsList;
    private boolean listIsOpen;

    public Queues() {
        this.waitingTime = 0;
        this.clientsList = new ArrayBlockingQueue<>(1000);
        this.listIsOpen = true;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public boolean isListIsOpen() {
        return listIsOpen;
    }

    public int getClientsNumber(){
        return clientsList.size();
    }

    public void addClient(Clients c){ //add client to queue
        clientsList.add(c);
        waitingTime+=c.getTaskTime();
    }

    public void closeList(){ //close queue if we don't have clients in it
        if(getClientsNumber()==0){
            listIsOpen=false;
        }
    }

    @Override
    public void run() {
        while(listIsOpen){ //if queue is opened
            if(getClientsNumber()>0){ //if we have clients in the queue
                Clients c=clientsList.peek(); //take the first client of the queue
                assert c != null;
                c.decreaseTaskTime(); //decrease the task time

                if(c.getTaskTime()==0){ //if the client finishes the task we remove him
                    clientsList.remove();
                }
                waitingTime--;

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.setStackTrace(null);
                }
            }
        }
    }

    @Override
    public String toString() {
        if(getClientsNumber()==0){
            return "The queue is closed!";
        }
        String string="";
        for(Clients c:clientsList){
            string+=String.format("[%d, %d, %d]", c.getIdClient(), c.getArrivalTime(), c.getTaskTime());
        }
        return string;
    }
}
