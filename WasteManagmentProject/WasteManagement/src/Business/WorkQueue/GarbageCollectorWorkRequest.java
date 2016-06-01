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
public class GarbageCollectorWorkRequest extends GarbageManagerWorkRequest{
    private int collectedMetal;
    private int collectedPlastic;
    private int collectedDegradable;
    private int segregatedMetal;
    private int segregatedPlastic;
    private int segregatedDegradable;
    private String messageToMetalDept;
    private String messageToPlasticDept;
    private String messageToBioDept;
    private UserAccount sentToMD;
    private UserAccount sentToPD;
    private UserAccount sentToBD;
    
    
    public UserAccount getSentToMD() {
        return sentToMD;
    }

    public void setSentToMD(UserAccount sentToMD) {
        this.sentToMD = sentToMD;
    }

    public UserAccount getSentToPD() {
        return sentToPD;
    }

    public void setSentToPD(UserAccount sentToPD) {
        this.sentToPD = sentToPD;
    }

    public UserAccount getSentToBD() {
        return sentToBD;
    }

    public void setSentToBD(UserAccount sentToBD) {
        this.sentToBD = sentToBD;
    }

    public String getMessageToMetalDept() {
        return messageToMetalDept;
    }

    public void setMessageToMetalDept(String messageToMetalDept) {
        this.messageToMetalDept = messageToMetalDept;
    }

    public String getMessageToPlasticDept() {
        return messageToPlasticDept;
    }

    public void setMessageToPlasticDept(String messageToPlasticDept) {
        this.messageToPlasticDept = messageToPlasticDept;
    }

    public String getMessageToBioDept() {
        return messageToBioDept;
    }

    public void setMessageToBioDept(String messageToBioDept) {
        this.messageToBioDept = messageToBioDept;
    }
    
    public int getCollectedMetal() {
        return collectedMetal;
    }

    public void setCollectedMetal(int collectedMetal) {
        this.collectedMetal = collectedMetal;
    }

    public int getCollectedPlastic() {
        return collectedPlastic;
    }

    public void setCollectedPlastic(int collectedPlastic) {
        this.collectedPlastic = collectedPlastic;
    }

    public int getCollectedDegradable() {
        return collectedDegradable;
    }

    public void setCollectedDegradable(int collectedDegradable) {
        this.collectedDegradable = collectedDegradable;
    }

    public int getSegregatedMetal() {
        return segregatedMetal;
    }

    public void setSegregatedMetal(int segregatedMetal) {
        this.segregatedMetal = segregatedMetal;
    }

    public int getSegregatedPlastic() {
        return segregatedPlastic;
    }

    public void setSegregatedPlastic(int segregatedPlastic) {
        this.segregatedPlastic = segregatedPlastic;
    }

    public int getSegregatedDegradable() {
        return segregatedDegradable;
    }

    public void setSegregatedDegradable(int segregatedDegradable) {
        this.segregatedDegradable = segregatedDegradable;
    }
    
}
