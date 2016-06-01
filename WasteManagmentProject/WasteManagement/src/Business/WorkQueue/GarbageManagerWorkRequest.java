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
public class GarbageManagerWorkRequest extends WorkRequest{
    private String garbageStatus ;
    private String metalGarbageStatus;
    private String biodegradableStatus;
    private String plasticStatus;
    private String area;
    

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    public String getGarbageStatus() {
        return garbageStatus;
    }

    public void setGarbageStatus(String garbageStatus) {
        this.garbageStatus = garbageStatus;
    }

    public String getMetalGarbageStatus() {
        return metalGarbageStatus;
    }

    public void setMetalGarbageStatus(String metalGarbageStatus) {
        this.metalGarbageStatus = metalGarbageStatus;
    }

    public String getBiodegradableStatus() {
        return biodegradableStatus;
    }

    public void setBiodegradableStatus(String biodegradableStatus) {
        this.biodegradableStatus = biodegradableStatus;
    }

    public String getPlasticStatus() {
        return plasticStatus;
    }

    public void setPlasticStatus(String plasticStatus) {
        this.plasticStatus = plasticStatus;
    }

    
    
}
