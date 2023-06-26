package gida.simulators.labs.first.engine;

import java.util.List;

import gida.simulators.labs.first.resources.Server;

public class CustomReportTotal implements Reportable{
    private CustomReport[] reportTotal = new CustomReport[50];
    private double[] meanCantPlane = new double[3];
    private double[] meanWaitingTime = new double[3];
    private double[] meanWaitingMaxTime = new double[3];
    private double[] meanTransitTime = new double[3];
    private double[] meanTransitMaxTime = new double[3];

    private double[] meanIdleTotal = new double[10];
    private double[] meanIdleMax = new double[10];
    private double[] meanQueueSizeMax = new double[10];
    private double[] meanWear = new double[10];
    
    

    public CustomReport[] getReportTotal() {
        return reportTotal;
    }



    public void setReportTotal(CustomReport[] reportTotal) {
        this.reportTotal = reportTotal;
    }



    public double[] getMeanCantPlane() {
        return meanCantPlane;
    }



    public void setMeanCantPlane(double[] meanCantPlane) {
        this.meanCantPlane = meanCantPlane;
    }



    public double[] getMeanWaitingTime() {
        return meanWaitingTime;
    }



    public void setMeanWaitingTime(double[] meanWaitingTime) {
        this.meanWaitingTime = meanWaitingTime;
    }



    public double[] getMeanWaitingMaxTime() {
        return meanWaitingMaxTime;
    }



    public void setMeanWaitingMaxTime(double[] meanWaitingMaxTime) {
        this.meanWaitingMaxTime = meanWaitingMaxTime;
    }



    public double[] getMeanTransitTime() {
        return meanTransitTime;
    }



    public void setMeanTransitTime(double[] meanTransitTime) {
        this.meanTransitTime = meanTransitTime;
    }



    public double[] getMeanTransitMaxTime() {
        return meanTransitMaxTime;
    }



    public void setMeanTransitMaxTime(double[] meanTransitMaxTime) {
        this.meanTransitMaxTime = meanTransitMaxTime;
    }



    public double[] getMeanIdleTotal() {
        return meanIdleTotal;
    }



    public void setMeanIdleTotal(double[] meanIdleTotal) {
        this.meanIdleTotal = meanIdleTotal;
    }



    public double[] getMeanIdleMax() {
        return meanIdleMax;
    }



    public void setMeanIdleMax(double[] meanIdleMax) {
        this.meanIdleMax = meanIdleMax;
    }



    public double[] getMeanQueueSizeMax() {
        return meanQueueSizeMax;
    }



    public void setMeanQueueSizeMax(double[] meanQueueSizeMax) {
        this.meanQueueSizeMax = meanQueueSizeMax;
    }



    public double[] getMeanWear() {
        return meanWear;
    }



    public void setMeanWear(double[] meanWear) {
        this.meanWear = meanWear;
    }

    public void saveValue(CustomReport report){
        //GUARDA LOS VALORES EN LAS VARIABLES CREADAS ARRIBA
    }

    @Override
    public void generateReport(List<Server> servers) {
        
    }
}
