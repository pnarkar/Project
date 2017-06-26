/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityhubtopten;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableUtils;

/**
 *
 * @author pranali
 */
public class QualityOfLife implements Writable, WritableComparable<QualityOfLife>{
    
    private double qualityOfLife;

    public double getQualityOfLife() {
        return qualityOfLife;
    }

    public void setQualityOfLife(double qualityOfLife) {
        this.qualityOfLife = qualityOfLife;
    }

    public QualityOfLife(double Ql) {
        super();
        this.qualityOfLife=Ql;
        
    }

    @Override
    public void write(DataOutput d) throws IOException {
        d.writeDouble(qualityOfLife);
       
    }

    @Override
    public void readFields(DataInput di) throws IOException {
        qualityOfLife = di.readDouble();
       
    }

    @Override
    public int compareTo(QualityOfLife e1) {
       if(qualityOfLife > e1.getQualityOfLife()){
           
           return 1;
           
       } else {
           
           return -1;
           
       }
    }

    
    
    public String toString()
    {
        return (new StringBuilder().append(qualityOfLife).toString());
    }
  
}
