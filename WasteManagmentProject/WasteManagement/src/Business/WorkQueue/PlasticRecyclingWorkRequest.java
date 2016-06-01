/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;

/**
 *
 * @author pranalinarkar
 */
public class PlasticRecyclingWorkRequest extends PlasticTransportationWorkRequest {
   private int pTime;
   private int pTemperature;
   private int pMoneyEarned;
   private int totalMoneyEarned;

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public void setTotalMoneyEarned(int totalMoneyEarned) {
        this.totalMoneyEarned = totalMoneyEarned;
    }
    public int getpMoneyEarned() {
        return pMoneyEarned;
    }

    public void setpMoneyEarned(int pMoneyEarned) {
        this.pMoneyEarned = pMoneyEarned;
    }
   
    private int numberOfItemsProduced;
     private UserAccount SentTo;

    public UserAccount getSentTo() {
        return SentTo;
    }

    public void setSentTo(UserAccount SentTo) {
        this.SentTo = SentTo;
    }
   

    public int getNumberOfItemsProduced() {
        return numberOfItemsProduced;
    }

    public void setNumberOfItemsProduced(int numberOfItemsProduced) {
        this.numberOfItemsProduced = numberOfItemsProduced;
    }
    
    public int getpTime() {
        return pTime;
    }

    public void setpTime(int pTime) {
        this.pTime = pTime;
    }

    public int getpTemperature() {
        return pTemperature;
    }

    public void setpTemperature(int pTemperature) {
        this.pTemperature = pTemperature;
    }
   
   
}
