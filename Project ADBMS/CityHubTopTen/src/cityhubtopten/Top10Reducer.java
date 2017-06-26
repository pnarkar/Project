/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityhubtopten;

/**
 *
 * @author pranali
 */
import java.io.IOException;
 
import java.util.Iterator;
 
import java.util.TreeMap;
 
import java.util.Map.Entry;
 
import org.apache.hadoop.io.LongWritable;
 
import org.apache.hadoop.io.NullWritable;
 
import org.apache.hadoop.io.Text;
 
import org.apache.hadoop.mapreduce.Reducer;
 
import org.apache.hadoop.mapreduce.Reducer.Context;
public class Top10Reducer extends Reducer<NullWritable, Text, NullWritable, Text> {
 
                public static TreeMap<QualityOfLife , Text> ToRecordMap = new TreeMap<QualityOfLife , Text>();
 
 
 
                public void reduce(NullWritable key, Iterable<Text> values,Context context) throws IOException, InterruptedException {
 
 
 
                     for (Text value : values) {
 
                       String line=value.toString();
 
                      if(line.length()>0){
 
                      String[] tokens=line.split(",");
 
                     //split the data and fetch salary
 
                     double quality=Double.parseDouble(tokens[6]);
 
                     //insert salary as key and entire row as value
 
                     //tree map sort the records based on salary
 
                    ToRecordMap.put(new QualityOfLife (quality), new Text(value));
 
                     }
 
                     }
 
                     // If we have more than ten records, remove the one with the lowest sal
 
                     // As this tree map is sorted in descending order, the user with
 
                     // the lowest sal is the last key.
 
                     Iterator<Entry<QualityOfLife , Text>> iter = ToRecordMap.entrySet().iterator();
 
                     Entry<QualityOfLife , Text> entry = null;
 
         
 
          while(ToRecordMap.size()>10){
 
             entry = iter.next();
 
                           iter.remove();            
 
          }
 
                     for (Text t : ToRecordMap.descendingMap().values()) {
 
                     // Output our ten records to the file system with a null key
 
                     context.write(NullWritable.get(), t);
 
                     }
 
                 }
 
 
 
     }
