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
public class MetalRecyclingWorkRequest extends MetalTransportationWorkRequest implements Comparable<MetalRecyclingWorkRequest> {
     private int mTemperature;
     private int mTime;
      private int quantityProduced;
    private int moneyEarned;
    private UserAccount SentTo;
    private int totalMoneyEarned;

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public void setTotalMoneyEarned(int totalMoneyEarned) {
        this.totalMoneyEarned = totalMoneyEarned;
    }
    

    public UserAccount getSentTo() {
        return SentTo;
    }

    public void setSentTo(UserAccount SentTo) {
        this.SentTo = SentTo;
    }
    

    public int getQuantityProduced() {
        return quantityProduced;
    }

    public void setQuantityProduced(int quantityProduced) {
        this.quantityProduced = quantityProduced;
    }

    public int getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(int moneyEarned) {
        this.moneyEarned = moneyEarned;
    }

    
    

    public int getmTemperature() {
        return mTemperature;
    }

    public void setmTemperature(int mTemperature) {
        this.mTemperature = mTemperature;
    }

    public int getmTime() {
        return mTime;
    }

    public void setmTime(int mTime) {
        this.mTime = mTime;
    }

    @Override
    public int compareTo(MetalRecyclingWorkRequest o) {
        if (this.totalMoneyEarned> o.getTotalMoneyEarned()) {
            return -1;
        } else if (this.totalMoneyEarned< o.getTotalMoneyEarned()) {
            return 1;
        } else {

            return 0;
        }
    }

   

   
     
}
