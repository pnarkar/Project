/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author pranalinarkar
 */
public class PlasticTransportationWorkRequest extends GarbageCollectorWorkRequest{
     int distanceTravelled;
    int moneyEarned;
    
    
    public PlasticTransportationWorkRequest(){
    distanceTravelled= (int)(Math.random()*100);
    
    }
    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public int getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(int moneyEarned) {
        this.moneyEarned = moneyEarned;
    }
}
