package gida.simulators.labs.first.engine;

import java.util.List;

import gida.simulators.labs.first.resources.Server;

public class CustomReport implements Reportable {
    private double totalWaitingTime;
    private double maxWaitingTime;
    private double totalTransitTime;
    private double maxTransitTime;
    private double totalIdleTime;
    private double maxIdleTime;
    private int contPlane;
    private int maxSize;
    private int contQueue;

    
    public int getContQueue() {
        return contQueue;
    }

    public void setContQueue(int contQueue) {
        this.contQueue = contQueue;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
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

    public double getTotalIdleTime(Server server) {
        return totalIdleTime;
    }

    public void setTotalIdleTime(double totalIdleTime, Server server) {
        this.totalIdleTime = totalIdleTime;
    }

    public double getMaxIdleTime(Server server) {
        return maxIdleTime;
    }


    public void setMaxIdleTime(double maxIdleTime, Server server) {
        this.maxIdleTime = maxIdleTime;
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
        for(int i=0;i<10;i++){
            System.out.println("Tiempo total de ocio pista: "+ i+":"+ this.getTotalIdleTime(servers.get(i)));
            System.out.println("Porcentaje del tiempo total de ocio con respecto al tiempo de simulacion pista "+i+":"+((this.getTotalIdleTime(servers.get(i))*100)/40320)+" %");
            System.out.println("Tiempo maximo de ocio pista "+i+":"+ this.getMaxIdleTime(servers.get(i)));
            System.out.println("Porcentaje del tiempo maximo de ocio con respecto al tiempo total de ocio pista "+i+":"+((this.getMaxIdleTime(servers.get(i))*100)/this.getTotalIdleTime(servers.get(i)))+" %");
            System.out.println("Tamaño maximo de la cola de espera para el servidor pista"+i+":"+this.getMaxSize());
        }
    }
}
