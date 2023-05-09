package Entities;

public class Clients implements Comparable<Clients>{

    private int idClient;
    private final int arrivalTime;
    private int taskTime;

    public Clients(int arrivalTime, int taskTime) {
        this.arrivalTime = arrivalTime;
        this.taskTime = taskTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getTaskTime() {
        return taskTime;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void decreaseTaskTime(){ //decrease the task time of every client when get to the front of the queue
        this.taskTime--;
    }

    @Override
    public int compareTo(Clients o) { //get the client with the minimum arrival time
        if(this.arrivalTime<o.arrivalTime)
            return -1;
        else if(this.arrivalTime>o.arrivalTime)
            return 1;
        return 0;
    }
}
