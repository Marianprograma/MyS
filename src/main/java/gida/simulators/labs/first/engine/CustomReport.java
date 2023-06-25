package gida.simulators.labs.first.engine;

import java.text.DecimalFormat;
import java.util.List;

import gida.simulators.labs.first.resources.AirstripL;
import gida.simulators.labs.first.resources.AirstripM;
import gida.simulators.labs.first.resources.Server;

public class CustomReport implements Reportable {
    private double[] totalWaitingTime = new double[10];
    private double[] maxWaitingTime = new double[10];
    private double[] totalTransitTime = new double[10];
    private double[] maxTransitTime = new double[10];
    private double[] totalIdleTime = new double[10];
    private double[] maxIdleTime = new double[10];
    private int[] contPlane = new int[10];
    private int[] maxSize = new int[10];
    private int[] contQueue = new int[10];
    private double[] remainingWear = new double[10];
    
    
    public double getRemainingWear(int id) {
        return remainingWear[id];
    }

    public void setRemainingWear(double remainingWear,int id) {
        this.remainingWear[id] = remainingWear;
    }

    public int getContQueue(int id) {
        return contQueue[id];
    }

    public void setContQueue(int contQueue, int id) {
        this.contQueue[id] = contQueue;
    }

    public int getMaxSize(int id) {
        return maxSize[id];
    }

    public void setMaxSize(int maxSize,int id) {
        this.maxSize[id] = maxSize;
    }
    
    public int getContPlane(int id) {
        return contPlane[id];
    }

    public void setContPlane(int contPlane,int id) {
        this.contPlane[id] = contPlane;
    }

    public double getTotalWaitingTime(int id) {
        return totalWaitingTime[id];
    }

    public void setTotalWaitingTime(double totalWaitingTime,int id) {
        this.totalWaitingTime[id] = totalWaitingTime;
    }

    public double getMaxWaitingTime(int id) {
        return maxWaitingTime[id];
    }

    public void setMaxWaitingTime(double maxWaitingTime,int id) {
        this.maxWaitingTime[id] = maxWaitingTime;
    }

    public double getTotalTransitTime(int id) {
        return totalTransitTime[id];
    }

    public void setTotalTransitTime(double totalTransitTime,int id) {
        this.totalTransitTime[id] = totalTransitTime;
    }

    public double getMaxTransitTime(int id) {
        return maxTransitTime[id];
    }

    public void setMaxTransitTime(double maxTransitTime, int id) {
        this.maxTransitTime[id] = maxTransitTime;
    }

    public void valores(List<Server> servers){
        double maxtL=0, maxtM=0, maxtH=0, totaltL=0,totaltM=0,totaltH=0,maxwL=0,maxwM=0,maxwH=0;
        double totalwL=0,totalwM=0,totalwH=0,contpL=0,contpM=0,contpH=0,contqL=0,contqM=0,contqH=0;
        for (int i = 1; i < servers.size() ; i++) {
            if (servers.get(i).getClass() == AirstripL.class) {
                maxtL += (getMaxTransitTime(servers.get(i).getId())); 
                totaltL += (getTotalTransitTime(servers.get(i).getId())); 
                maxwL += (getMaxWaitingTime(servers.get(i).getId()));
                totalwL += (getTotalWaitingTime(servers.get(i).getId()));
                contpL += (getContPlane(servers.get(i).getId()));
                contqL += (getContQueue(servers.get(i).getId()));
            } else if(servers.get(i).getClass() == AirstripM.class){
                maxtM += (getMaxTransitTime(servers.get(i).getId()));
                totaltM += (getTotalTransitTime(servers.get(i).getId()));
                maxwM += (getMaxWaitingTime(servers.get(i).getId()));
                totalwM += (getTotalWaitingTime(servers.get(i).getId()));
                contpM += (getContPlane(servers.get(i).getId()));
                contqM += (getContQueue(servers.get(i).getId()));
            } else{
                maxtH += (getMaxTransitTime(servers.get(i).getId()));
                totaltH += (getTotalTransitTime(servers.get(i).getId()));
                maxwH += (getMaxWaitingTime(servers.get(i).getId()));
                totalwH += (getTotalWaitingTime(servers.get(i).getId()));
                contpH += (getContPlane(servers.get(i).getId()));
                contqH += (getContQueue(servers.get(i).getId()));
            }
        }
        DecimalFormat formato1 = new DecimalFormat("#0.00");
        System.out.println("Cantidad de aviones que aterrizaron");
        System.out.println("Livianos: " + formato1.format(contpL));
        System.out.println("Medianos: " + formato1.format(contpM));
        System.out.println("Pesados: " + formato1.format(contpH));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Maximo tiempo de espera");
        System.out.println("Livianos: " + formato1.format(maxwL));
        System.out.println("Medianos: " + formato1.format(maxwM));
        System.out.println("Pesados: " + formato1.format(maxwH));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Media tiempo de espera");
        System.out.println("Livianos: " + formato1.format(maxwL / contqL));
        System.out.println("Medianos: " + formato1.format(maxwM / contqM));
        System.out.println("Pesados: " + formato1.format(maxwH / contqH));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Tiempo total de transito");
        System.out.println("Livianos: " + formato1.format(totaltL));
        System.out.println("Medianos: " + formato1.format(totaltM));
        System.out.println("Pesados: " + formato1.format(totaltH));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Maximo tiempo de transito");
        System.out.println("Livianos: " + formato1.format(maxtL));
        System.out.println("Medianos: " + formato1.format(maxtM));
        System.out.println("Pesados: " + formato1.format(maxtH));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Media tiempo de transito");
        System.out.println("Livianos: " + formato1.format(maxtL / contpL));
        System.out.println("Medianos: " + formato1.format(maxtM / contpM));
        System.out.println("Pesados: " + formato1.format(maxtH / contpH));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Tiempo total de espera");
        System.out.println("Livianos: " + formato1.format(totalwL));
        System.out.println("Medianos: " + formato1.format(totalwM));
        System.out.println("Pesados: " + formato1.format(totalwH));
        System.out.println("--------------------------------------------------------------------------------");


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
        DecimalFormat formato1 = new DecimalFormat("#0.00");
        valores(servers);
        for(int i=1;i<servers.size();i++){
            System.out.println("Pista: " + i);
            System.out.println("Tiempo total de ocio: "+ formato1.format(this.getTotalIdleTime(servers.get(i).getId())));
            System.out.println("Porcentaje del tiempo total de ocio con respecto al tiempo de simulacion: "+formato1.format(((this.getTotalIdleTime(servers.get(i).getId())*100)/40320))+" %");
            System.out.println("Tiempo maximo de ocio: "+ formato1.format(this.getMaxIdleTime(servers.get(i).getId())));
            System.out.println("Porcentaje del tiempo maximo de ocio con respecto al tiempo total de ocio: "+formato1.format(((this.getMaxIdleTime(servers.get(i).getId())*100)/this.getTotalIdleTime(servers.get(i).getId())))+" %");
            System.out.println("Tamaño maximo de la cola de espera para el servidor: "+formato1.format(this.getMaxSize(servers.get(i).getId())));
            System.out.println("Durabilidad del suelo restante: " + formato1.format(this.getRemainingWear(servers.get(i).getId())));
            System.out.println("--------------------------------------------------------------------------------");
        }
    }
}
