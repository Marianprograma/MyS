package gida.simulators.labs.first.engine;

//import java.text.DecimalFormat;
import java.util.List;

import gida.simulators.labs.first.resources.AirstripH;
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
    //
    private double maxtL, maxtM, maxtH, totaltL,totaltM,totaltH,maxwL,maxwM,maxwH;
    private double totalwL,totalwM,totalwH,contpL,contpM,contpH,contqL,contqM,contqH, contPlaneTotal;


    public double getContPlaneTotal() {
        return contPlaneTotal;
    }

    private double[]serverTotalIdleTime = new double[5]; 
    private double[]serverTotalMaxIdleTime = new double[5];
    private double[]serverMaxQueueWaitingTime = new double[5]; 
    private double[]serverDurability= new double[5];
    private List<Server> serverss;

    public void resetCustom (){
        for(int i=0; i<10; i++){
            totalWaitingTime[i]=0;
            maxWaitingTime[i]=0;
            totalTransitTime[i]=0;
            maxTransitTime[i]=0;
            totalIdleTime[i]=0;
            maxIdleTime[i]=0;
            contPlane[i]=0;
            maxSize[i]=0;
            contQueue[i]=0;
            remainingWear[i]=0;
        }

        for (int i = 0; i < 3; i++) {
            serverTotalIdleTime[i]=0;
            serverTotalMaxIdleTime[i]=0;
            serverMaxQueueWaitingTime[i]=0;
            serverDurability[i]=0;
        }

        maxtL=0;
        maxtM=0;
        maxtH=0;
        totaltL=0;
        totaltM=0;
        totaltH=0;
        maxwL=0;
        maxwM=0;
        maxwH=0;
        totalwL=0;
        totalwM=0;
        totalwH=0;
        contpL=0;
        contpM=0;
        contpH=0;
        contqL=0;
        contqM=0;
        contqH=0;
    }

    public double getServerTotalIdleTime(int index) {
        return serverTotalIdleTime[index];
    }

    public double getServerTotalMaxIdleTime(int index) {
        return serverTotalMaxIdleTime[index];
    }

    public double getServerMaxQueueWaitingTime(int index) {
        return serverMaxQueueWaitingTime[index];
    }

    public double getServerDurability(int index) {
        return serverDurability[index];
    }

    public double getMaxtL() {
        return maxtL;
    }

    public double getMaxtM() {
        return maxtM;
    }

    public double getMaxtH() {
        return maxtH;
    }

    public double getTotaltL() {
        return totaltL;
    }

    public double getTotaltM() {
        return totaltM;
    }

    public double getTotaltH() {
        return totaltH;
    }

    public double getMaxwL() {
        return maxwL;
    }

    public double getMaxwM() {
        return maxwM;
    }

    public double getMaxwH() {
        return maxwH;
    }

    public double getTotalwL() {
        return totalwL;
    }

    public double getTotalwM() {
        return totalwM;
    }

    public double getTotalwH() {
        return totalwH;
    }

    public double getContpL() {
        return contpL;
    }

    public double getContpM() {
        return contpM;
    }

    public double getContpH() {
        return contpH;
    }

    public double getContqL() {
        return contqL;
    }

    public double getContqM() {
        return contqM;
    }

    public double getContqH() {
        return contqH;
    }

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

    public void generateReportTotal(CustomReport report){
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
        serverss = servers;
        for (int i = 1; i < servers.size() ; i++) {
            if (servers.get(i).getClass() == AirstripL.class) {
                maxtL = (getMaxTransitTime(servers.get(i).getId())); 
                totaltL += (getTotalTransitTime(servers.get(i).getId())); 
                maxwL = (getMaxWaitingTime(servers.get(i).getId()));
                totalwL += (getTotalWaitingTime(servers.get(i).getId()));
                contpL += (getContPlane(servers.get(i).getId()));
                contqL += (getContQueue(servers.get(i).getId()));
            } else if(servers.get(i).getClass() == AirstripM.class){
                maxtM = (getMaxTransitTime(servers.get(i).getId()));
                totaltM += (getTotalTransitTime(servers.get(i).getId()));
                maxwM = (getMaxWaitingTime(servers.get(i).getId()));
                totalwM += (getTotalWaitingTime(servers.get(i).getId()));
                contpM += (getContPlane(servers.get(i).getId()));
                contqM += (getContQueue(servers.get(i).getId()));
            } else if (servers.get(i).getClass() == AirstripH.class){
                maxtH = (getMaxTransitTime(servers.get(i).getId()));
                totaltH += (getTotalTransitTime(servers.get(i).getId()));
                maxwH = (getMaxWaitingTime(servers.get(i).getId()));
                totalwH += (getTotalWaitingTime(servers.get(i).getId()));
                contpH += (getContPlane(servers.get(i).getId()));
                contqH += (getContQueue(servers.get(i).getId()));
            }
        }
        contPlaneTotal= contpL+contpM+contpH;
        //DecimalFormat formato1 = new DecimalFormat("#0.00");
        //MEDIAS DE LOS VALORES DEL REPORTE
/* 
        System.out.println("Cantidad de aviones que aterrizaron");
        System.out.println("Livianos: " + formato1.format(contpL));
        System.out.println("Medianos: " + formato1.format(contpM));
        System.out.println("Pesados: " + formato1.format(contpH));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Maximo tiempo de espera");
        System.out.println("Livianos: " + formato1.format(maxwL/60));
        System.out.println("Medianos: " + formato1.format(maxwM/60));
        System.out.println("Pesados: " + formato1.format(maxwH/60));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Media tiempo de espera");
        System.out.println("Livianos: " + formato1.format((totalwL / contqL)/60));
        System.out.println("Medianos: " + formato1.format((totalwM / contqM)/60));
        System.out.println("Pesados: " + formato1.format((totalwH / contqH)/60));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Tiempo total de transito");
        System.out.println("Livianos: " + formato1.format(totaltL));
        System.out.println("Medianos: " + formato1.format(totaltM));
        System.out.println("Pesados: " + formato1.format(totaltH));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Maximo tiempo de transito");
        System.out.println("Livianos: " + formato1.format(maxtL/60));
        System.out.println("Medianos: " + formato1.format(maxtM/60));
        System.out.println("Pesados: " + formato1.format(maxtH/60));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Media tiempo de transito");
        System.out.println("Livianos: " + formato1.format((totaltL / contpL)));
        System.out.println("Medianos: " + formato1.format((totaltM / contpM)));
        System.out.println("Pesados: " + formato1.format((totaltH / contpH)));
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Tiempo total de espera");
        System.out.println("Livianos: " + formato1.format(totalwL/60));
        System.out.println("Medianos: " + formato1.format(totalwM/60));
        System.out.println("Pesados: " + formato1.format(totalwH/60));
        System.out.println("--------------------------------------------------------------------------------");

*/
    }

    public List<Server> getServers(){
        return serverss;
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
        //DecimalFormat formato1 = new DecimalFormat("#0.00");
        valores(servers);
        //System.out.println("Valores");
        for(int i=1;i<servers.size();i++){
            serverTotalIdleTime[i-1] = this.getTotalIdleTime(servers.get(i).getId());
            serverTotalMaxIdleTime[i-1]=this.getMaxIdleTime(servers.get(i).getId());
            serverMaxQueueWaitingTime[i-1]=this.getMaxSize(servers.get(i).getId());
            serverDurability[i-1]=this.getRemainingWear(servers.get(i).getId());
            /* 
            System.out.println("Pista: " + i);
            System.out.println("Tiempo total de ocio: "+ formato1.format(serverTotalIdleTime[i-1]/60));
            System.out.println("Porcentaje del tiempo total de ocio con respecto al tiempo de simulacion: "+((serverTotalIdleTime[i-1]*100)/40320)+" %");
            System.out.println("Tiempo maximo de ocio: "+ formato1.format(serverTotalMaxIdleTime[i-1]/60));
            System.out.println("Porcentaje del tiempo maximo de ocio con respecto al tiempo total de ocio: "+(serverTotalMaxIdleTime[i-1]*100)/this.getTotalIdleTime(servers.get(i).getId())+" %");
            System.out.println("Tamaño maximo de la cola de espera para el servidor: "+formato1.format(serverMaxQueueWaitingTime[i-1]/60));
            System.out.println("Durabilidad del suelo restante: " + formato1.format(serverDurability[i-1]));
            System.out.println("--------------------------------------------------------------------------------");
            */
        }
    }
}
