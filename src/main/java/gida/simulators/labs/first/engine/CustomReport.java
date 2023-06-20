package gida.simulators.labs.first.engine;

import java.util.List;

import gida.simulators.labs.first.resources.Server;

public class CustomReport implements Reportable {
    private double totalWaitingTime;
    private double maxWaitingTime;
    private double totalTransitTime;
    private double maxTransitTime;
    private double[] totalIdleTime = new double[10];
    private double[] maxIdleTime = new double[10];
    private int contPlane;
    private int[] maxSize = new int[10];
    private int contQueue;
    
    public int getContQueue() {
        return contQueue;
    }

    public void setContQueue(int contQueue) {
        this.contQueue = contQueue;
    }

    public int getMaxSize(int id) {
        return maxSize[id];
    }

    public void setMaxSize(int maxSize,int id) {
        this.maxSize[id] = maxSize;
    }
    
    public int getContPlane() {
        return contPlane;
    }

    public void setContPlane(int contPlane) {
        this.contPlane = contPlane;
    }

    public double getTotalWaitingTime() {
        return totalWaitingTime;
    }

    public void setTotalWaitingTime(double totalWaitingTime) {
        this.totalWaitingTime = totalWaitingTime;
    }

    public double getMaxWaitingTime() {
        return maxWaitingTime;
    }

    public void setMaxWaitingTime(double maxWaitingTime) {
        this.maxWaitingTime = maxWaitingTime;
    }

    public double getTotalTransitTime() {
        return totalTransitTime;
    }

    public void setTotalTransitTime(double totalTransitTime) {
        this.totalTransitTime = totalTransitTime;
    }

    public double getMaxTransitTime() {
        return maxTransitTime;
    }

    public void setMaxTransitTime(double maxTransitTime) {
        this.maxTransitTime = maxTransitTime;
    }

    public double getTotalIdleTime(int id) {
        return totalIdleTime[id];
    }

    public void setTotalIdleTime(double totalIdleTime, int id) {
        this.totalIdleTime[id] = totalIdleTime;
    }

    public double getMaxIdleTime(int id) {
        return maxIdleTime[id];
    }

    public void setMaxIdleTime(double maxIdleTime, int id) {
        this.maxIdleTime[id] = maxIdleTime;
    }

    @Override
    public void generateReport(List<Server> servers){ 
        System.out.println("Valores");
        System.out.println("Cantidad de aeronaves que aterrizaron:"+this.getContPlane());
        System.out.println("Tiempo total de espera en cola:"+this.getTotalWaitingTime());
        System.out.println("Tiempo maximo de espera en cola:"+this.getMaxWaitingTime());
        System.out.println("Tiempo medio de espera en cola:"+(this.getTotalWaitingTime()/this.getContQueue()));
        System.out.println("Tiempo total de transito:"+ this.getTotalTransitTime());
        System.out.println("Tiempo maximo de transito:"+ this.getMaxTransitTime());
        System.out.println("Tiempo medio de transito: "+(this.getTotalTransitTime()/this.getContPlane()));
        for(int i=1;i<servers.size();i++){
            System.out.println("Tiempo total de ocio pista "+i+":"+ this.getTotalIdleTime(servers.get(i).getId()));
            System.out.println("Porcentaje del tiempo total de ocio con respecto al tiempo de simulacion pista "+i+":"+((this.getTotalIdleTime(servers.get(i).getId())*100)/40320)+" %");
            System.out.println("Tiempo maximo de ocio pista "+i+":"+ this.getMaxIdleTime(servers.get(i).getId()));
            System.out.println("Porcentaje del tiempo maximo de ocio con respecto al tiempo total de ocio pista "+i+":"+((this.getMaxIdleTime(servers.get(i).getId())*100)/this.getTotalIdleTime(servers.get(i).getId()))+" %");
            System.out.println("Tamaño maximo de la cola de espera para el servidor pista "+i+":"+this.getMaxSize(servers.get(i).getId()));
        }
    }
}
