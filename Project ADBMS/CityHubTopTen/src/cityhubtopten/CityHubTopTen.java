/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityhubtopten;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 * @author pranali
 */
public class CityHubTopTen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        try {
            Configuration conf = new Configuration();
            Job job = Job.getInstance(conf, "Top10");
            job.setJarByClass(CityHubTopTen.class);
           
            job.setMapperClass(Top10Mapper.class);
            
            
            
            job.setReducerClass(Top10Reducer.class);
            job.setOutputKeyClass(NullWritable.class);
            job.setOutputValueClass(Text.class);
            FileInputFormat.addInputPath(job, new Path(args[0]));
            FileOutputFormat.setOutputPath(job, new Path(args[1]));
            
            
            
            System.exit(job.waitForCompletion(true) ? 0 : 1);
            
        } catch (IOException | InterruptedException | ClassNotFoundException ex) {
            System.out.println("Erorr Message"+ ex.getMessage());
        }
    }
    
}
