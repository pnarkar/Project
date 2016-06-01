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
public class BioRecyclingWorkRequest extends BioTransportationWorkRequest{
    private int bTime;
    private int bTemperature;
    private int quantityProduced;
     private UserAccount SentTo;
     private int moneyEarned;
      private int totalMoneyEarned;

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public void setTotalMoneyEarned(int totalMoneyEarned) {
        this.totalMoneyEarned = totalMoneyEarned;
    }
    public int getMoneyEarned() {
        return moneyEarned;
    }

    public void setMoneyEarned(int moneyEarned) {
        this.moneyEarned = moneyEarned;
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
    
    public int getbTime() {
        return bTime;
    }

    public void setbTime(int bTime) {
        this.bTime = bTime;
    }

    public int getbTemperature() {
        return bTemperature;
    }

    public void setbTemperature(int bTemperature) {
        this.bTemperature = bTemperature;
    }
    
}
