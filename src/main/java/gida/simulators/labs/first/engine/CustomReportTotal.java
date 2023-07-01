package gida.simulators.labs.first.engine;

import java.text.DecimalFormat;
import java.util.List;


import gida.simulators.labs.first.resources.Server;

public class CustomReportTotal implements Reportable{
    private CustomReport report = new CustomReport();
    private double[] meanCantPlane = new double[3];
    private double[] meanWaitingTime = new double[3];
    private double[] meanWaitingMaxTime = new double[3];
    private double[] meanTransitTime = new double[3];
    private double[] meanTransitMaxTime = new double[3];

    private double[] meanIdleTotal = new double[10];
    private double[] meanIdleMax = new double[10];
    private double[] meanQueueSizeMax = new double[10];
    private double[] meanWear = new double[10];


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public CustomReport getReport(){
        return report;
    }

    public CustomReportTotal(CustomReport report) {
        this.report = report;
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



    public double getMeanIdleTotal(int index) {
        return meanIdleTotal[index];
    }



    public void setMeanIdleTotal(double[] meanIdleTotal) {
        this.meanIdleTotal = meanIdleTotal;
    }



    public double getMeanIdleMax(int index) {
        return meanIdleMax[index];
    }



    public void setMeanIdleMax(double[] meanIdleMax) {
        this.meanIdleMax = meanIdleMax;
    }



    public double getMeanQueueSizeMax(int index) {
        return meanQueueSizeMax[index];
    }

    public void generateReport(List<Server> servers){}

    public void setMeanQueueSizeMax(double[] meanQueueSizeMax) {
        this.meanQueueSizeMax = meanQueueSizeMax;
    }



    public double getMeanWear(int index) {
        return meanWear[index];
    }



    public void setMeanWear(double[] meanWear) {
        this.meanWear = meanWear;
    }

    public void saveValue(CustomReport report){
        /** VALORES DE ARREGLO
         * 0 => LIVIANOS
         * 1 => MEDIANOS
         * 2 => PESADOS
         */
        //MEDIA DE CANTIDAD DE AVIONES
        meanCantPlane[0]+=report.getContpL();
        meanCantPlane[1]+=report.getContpM();
        meanCantPlane[2]+=report.getContpH();

        //MEDIA DE TIEMPO DE ESPERA
        meanWaitingTime[0]+=report.getTotalwL();
        meanWaitingTime[1]+=report.getTotalwM();
        meanWaitingTime[2]+=report.getTotalwH();
        
        //MEDIA DE MAXIMO TIEMPO DE ESPERA
        meanWaitingMaxTime[0]+= report.getMaxwL();
        meanWaitingMaxTime[1]+= report.getMaxwM();
        meanWaitingMaxTime[2]+= report.getMaxwH();
        
        //MEDIA DE TIEMPO DE TRANSITO
        meanTransitTime[0]+= report.getTotaltL();
        meanTransitTime[1]+= report.getTotaltM();
        meanTransitTime[2]+= report.getTotaltH();
        
        //MEDIA DE MAXIMO TIEMPO DE TRANSITO
        meanTransitMaxTime[0] += report.getMaxtL();
        meanTransitMaxTime[1] += report.getMaxtM();
        meanTransitMaxTime[2] += report.getMaxtH();

        //MEDIA DE DATOS POR PISTA
        for (int i = 0; i < 4; i++) { 
            meanIdleTotal[i]+= report.getServerTotalIdleTime(i);
            meanIdleMax[i]+=report.getServerTotalMaxIdleTime(i);
            meanQueueSizeMax[i]+= report.getServerMaxQueueWaitingTime(i);
            meanWear[i]+=report.getServerDurability(i);
        }

        
    }
    private double sCantPLane;
    private double sWaitingtime;
    private double sWaitingtimeMax;
    private double sTransitTime;
    private double sTransitTimeMax;
    private double[] xCantPlaneType = new double[3];
    private double[] xWaitingTimeType = new double[3];
    private double[] xWaitingTimeMaxType = new double[3];
    private double[] xTransitTimeType = new double[3];
    private double[] xTransitTimeMaxType = new double[3];

    private double xCantPlaneReport;
    private double xWaitingtimeReport;
    private double xWaitingtimeMaxReport;
    private double xTransitTimeReport;
    private double xTransitTimeMaxReport;
    private double[] sCantPlaneType = new double[3];
    private double[] sWaitingTimeType = new double[3];
    private double[] sWaitingTimeMaxType = new double[3];
    private double[] sTransitTimeType = new double[3];
    private double[] sTransitTimeMaxType = new double[3];

    public void calculateInterval(){
        sCantPLane += (Math.pow((report.getContPlaneTotal()-(xCantPlaneReport)),2)/49);
        sWaitingtime += (Math.pow(((report.getTotalwL()+report.getTotalwM()+report.getTotalwH())-(xWaitingtimeReport)),2)/49);
        sWaitingtimeMax += (Math.pow(((report.getMaxwL()+report.getMaxwM()+report.getMaxwH())-(xWaitingtimeMaxReport)),2)/49);
        sTransitTime += (Math.pow(((report.getTotaltL()+report.getTotaltM()+report.getTotaltH())-(xTransitTimeReport)),2)/49);
        sTransitTimeMax += (Math.pow(((report.getMaxtL()+report.getMaxtM()+report.getMaxtH())-(xTransitTimeMaxReport)),2)/49);

        for (int i = 0; i < 3; i++) {
            sCantPlaneType[i] += (meanCantPlane[i]-xCantPlaneType[i])/49;
            sWaitingTimeType[i]+= (meanWaitingTime[i]-xWaitingTimeType[i])/49;
            sWaitingTimeMaxType[i]+= (meanWaitingMaxTime[i]-xWaitingTimeMaxType[i])/49;
            sTransitTimeType[i]+= (meanTransitTime[i]-xTransitTimeType[i])/49;
            sTransitTimeMaxType[i]+=(meanTransitMaxTime[i]-xTransitTimeMaxType[i])/49;
        }
    }



    @Override
    public void generateReportTotal(CustomReport report) {
        //X y S generales
        xCantPlaneReport = (meanCantPlane[0]+meanCantPlane[1]+meanCantPlane[2])/50;
        xWaitingtimeReport = (meanWaitingTime[0]+meanWaitingTime[1]+meanWaitingTime[2])/50;
        xWaitingtimeMaxReport = (meanWaitingMaxTime[0]+meanWaitingMaxTime[1]+meanWaitingMaxTime[2])/50;
        xTransitTimeReport = (meanTransitTime[0]+meanTransitTime[1]+meanTransitTime[2])/50;
        xTransitTimeMaxReport = (meanTransitMaxTime[0]+meanTransitMaxTime[1]+meanTransitMaxTime[2])/50;

        sCantPLane = Math.sqrt(sCantPLane);
        sWaitingtime = Math.sqrt(sWaitingtime);
        sWaitingtimeMax = Math.sqrt(sWaitingtimeMax);
        sTransitTime = Math.sqrt(sTransitTime);
        sTransitTimeMax = Math.sqrt(sTransitTimeMax);

        //X y S por Tipo
        for (int i = 0; i < 3; i++) {
            xCantPlaneType[i] = (meanCantPlane[i])/50;
            xWaitingTimeType[i] = (meanWaitingTime[i])/50;
            xWaitingTimeMaxType[i] = (meanWaitingMaxTime[i])/50;
            xTransitTimeType[i] = (meanTransitTime[i])/50;
            xTransitTimeMaxType[i] = (meanTransitMaxTime[i])/50;

            sCantPlaneType[i] = Math.sqrt(sCantPlaneType[i]);
            sWaitingTimeType[i] = Math.sqrt(sWaitingTimeType[i]);
            sWaitingTimeMaxType[i] = Math.sqrt(sWaitingTimeMaxType[i]);
            sTransitTimeType[i] = Math.sqrt(sTransitTimeType[i]);
            sTransitTimeMaxType[i]= Math.sqrt(sTransitTimeMaxType[i]);
        }


        DecimalFormat formato1 = new DecimalFormat("#0.00");
        System.out.println("************************************************");
        System.out.println("REPORTE TOTAL DE 50 EJECUCIONES");
        System.out.println("MEDIA DE CANTIDAD DE AVIONES: ("+formato1.format((xCantPlaneReport - (1.96 * (sCantPLane/Math.sqrt(50)))))+" , "+formato1.format((xCantPlaneReport + (1.96 * (sCantPLane/Math.sqrt(50)))))+")");
        System.out.println("MEDIA DE TIEMPO DE ESPERA: ("+ formato1.format((xWaitingtimeReport -(1.96*(sWaitingtime/Math.sqrt(50)))))+" , "+formato1.format((xWaitingtimeReport+(1.96*(sWaitingtime/Math.sqrt(50)))))+")");
        System.out.println("MEDIA DE MAXIMO TIEMPO DE ESPERA: ("+ formato1.format((xWaitingtimeMaxReport -(1.96*(sWaitingtimeMax/Math.sqrt(50)))))+" , "+formato1.format((xWaitingtimeMaxReport+(1.96*(sWaitingtimeMax/Math.sqrt(50)))))+")");
        System.out.println("MEDIA DE TIEMPO DE TRANSITO: ("+formato1.format( (xTransitTimeReport -(1.96*(sTransitTime/Math.sqrt(50)))))+" , "+formato1.format((xTransitTimeReport+(1.96*(sTransitTime/Math.sqrt(50)))))+")");
        System.out.println("MEDIA DE MAXIMO TIEMPO DE TRANSITO: ("+ formato1.format((xTransitTimeMaxReport -(1.96*(sTransitTimeMax/Math.sqrt(50)))))+" , "+formato1.format((xTransitTimeMaxReport+(1.96*(sTransitTimeMax/Math.sqrt(50)))))+")");


        System.out.println("----------------------------------------------------------------");
        System.out.println("REPORTE TOTAL POR TIPO");
        for(int i=0;i<3;i++){
            if(i==0){
                System.out.println("Liviano");
            }else if (i==1) {
                System.out.println("Mediano");
            }else{
                System.out.println("Pesado");
            }
            System.out.println("MEDIA DE CANTIDAD DE AVIONES: ("+formato1.format((xCantPlaneType[i]-(1.96*(sCantPlaneType[i]/Math.sqrt(50)))))+" , "+formato1.format((xCantPlaneType[i]+(1.96*(sCantPlaneType[i]/Math.sqrt(50)))))+" )");
            System.out.println("MEDIA DE TIEMPO DE ESPERA: ("+formato1.format((xWaitingTimeType[i]-(1.96*(sWaitingTimeType[i]/Math.sqrt(50)))))+" , "+formato1.format((xWaitingTimeType[i]+(1.96*(sWaitingTimeType[i]/Math.sqrt(50)))))+")");
            System.out.println("MEDIA DE MAXIMO TIEMPO DE ESPERA: ("+formato1.format((xWaitingTimeMaxType[i]-(1.96*(sWaitingTimeMaxType[i]/Math.sqrt(50)))))+" , "+formato1.format((xWaitingTimeMaxType[i]+(1.96*(sWaitingTimeMaxType[i]/Math.sqrt(50)))))+")");
            System.out.println("MEDIA DE TIEMPO DE TRANSITO: ("+formato1.format((xTransitTimeType[i]-(1.96*(sTransitTimeType[i]/Math.sqrt(50)))))+" , "+formato1.format((xTransitTimeType[i]+(1.96*(sTransitTimeType[i]/Math.sqrt(50)))))+")");
            System.out.println("MEDIA DE MAXIMO TIEMPO DE TRANSITO: ("+formato1.format((xTransitTimeMaxType[i]-(1.96*(sTransitTimeMaxType[i]/Math.sqrt(50)))))+" , "+formato1.format((xTransitTimeMaxType[i]+(1.96*(sTransitTimeMaxType[i]/Math.sqrt(50)))))+")");
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("REPORTE TOTAL POR PISTA");
        for(int j=0; j<4; j++){
            System.out.println("Pista: "+ (j+1) + " Tipo: "+ report.getServers().get(j+1).getClass().getSimpleName());
            System.out.println("Media de tiempo de ocio: "+ formato1.format((getMeanIdleTotal(j)/50)));
            System.out.println("Porcentaje de ocio que representa con respecto al tiempo de ejecucion: "+ ((getMeanIdleTotal(j)/50)*100)/40320f);
            System.out.println("Media de tiempo maximo de ocio: "+ formato1.format((getMeanIdleMax(j)/50)));
            System.out.println("Porcentaje que representa con respecto al tiempo total de ocio: "+formato1.format(((getMeanIdleMax(j)/50)*100)/(getMeanIdleTotal(j)/50)));
            System.out.println("Media del tamanio maximo de cola de espera: "+ formato1.format((getMeanQueueSizeMax(j)/50)));
            System.out.println("Media de durabilidad del suelo: "+ formato1.format((getMeanWear(j)/50)));
            System.out.println("----------------------------------------------------------------");
        }
    }
}
