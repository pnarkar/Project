/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.Date;

/**
 *
 * @author pranalinarkar
 */
public class MetalFactoryOutletTransportationWorkRequest extends MetalRecyclingWorkRequest{
    private int distanceTravelled;
    private int moneyEarnedInDelivering;
    private String nameOfOutlet;
     private Date FresolveDate;
     private int daysTakenToComplete;

    public int getDaysTakenToComplete() {
        return daysTakenToComplete;
    }

    public void setDaysTakenToComplete(int daysTakenToComplete) {
        this.daysTakenToComplete = daysTakenToComplete;
    }
     

    public Date getFresolveDate() {
        return FresolveDate;
    }
   public MetalFactoryOutletTransportationWorkRequest(){
   
   FresolveDate=new Date();
   }
    public void setFresolveDate(Date FresolveDate) {
        this.FresolveDate = FresolveDate;
    }

    public String getNameOfOutlet() {
        return nameOfOutlet;
    }

    public void setNameOfOutlet(String nameOfOutlet) {
        this.nameOfOutlet = nameOfOutlet;
    }
    
    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public int getMoneyEarnedInDelivering() {
        return moneyEarnedInDelivering;
    }

    public void setMoneyEarnedInDelivering(int moneyEarnedInDelivering) {
        this.moneyEarnedInDelivering = moneyEarnedInDelivering;
    }
    
    
    
    
}
