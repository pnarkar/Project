/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityhubtopten;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 *
 * @author pranali
 */
public class Top10Mapper extends Mapper<LongWritable, Text, NullWritable, Text> {

 
public static TreeMap<QualityOfLife, Text> ToRecordMap = new TreeMap<QualityOfLife , Text>();
 
                    
 
public void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException {
 
                     String line=value.toString();
                     
 
                     String[] tokens=line.split(",");
 if(line.contains("Quality of Life")){
                     return;
                     }
                 
 
                     double quality=Double.parseDouble(tokens[6]);
 
                
 
               ToRecordMap.put(new QualityOfLife (quality), new Text(value));
 

 
Iterator<Entry<QualityOfLife , Text>> iter = ToRecordMap.entrySet().iterator();
 
     Entry<QualityOfLife , Text> entry = null;
 
                
 
                 while(ToRecordMap.size()>10){
 
                   entry = iter.next();      
 
   iter.remove();         
 
                 }
 
                     }
 
protected void cleanup(Context context) throws IOException, InterruptedException {
 
 
 

                     for (Text t:ToRecordMap.values()) {
 
                     context.write(NullWritable.get(), t);
 
                     }
 
                     }                 
 
}
