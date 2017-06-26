/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityhubpartitioningcountry;

import java.io.IOException;
import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 * @author pranali
 */
public class CityHubPartitioning {

   public static class PartitionMonthMapper extends Mapper<Object,Text,Text,Text>{
 private Text country= new Text();
 public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
    String[] tokens = value.toString().split(",");
     String mn = tokens[1].trim();
     country.set(mn);
     context.write(country, value);
    
    }
 }
 
 public static class PartitionCountryPartitioner extends Partitioner<Text,Text> implements Configurable{
        private Configuration conf= null;
        private int ret=0;
         @Override
         public int getPartition(Text key, Text value, int i) {
             if(key.toString().startsWith("A")){
             return 0;
             
             }
           else  if(key.toString().startsWith("B")){
             return 1;
             
             }
            else if(key.toString().startsWith("C")){
             return 2;
             
             }
           else  if(key.toString().startsWith("D")){
             return 3;
             
             }
            else if(key.toString().startsWith("E")){
             return 4;
             
             }
            else if(key.toString().startsWith("F")){
             return 5;
             
             }
           else  if(key.toString().startsWith("G")){
             return 6;
             
             }
            else if(key.toString().startsWith("H")){
             return 7;
             
             }
           else if(key.toString().startsWith("I")){
             return 8;
             
             }
           else if(key.toString().startsWith("J")){
             return 9;
             
             }
            else if(key.toString().startsWith("K")){
             return 10;
             
             }
           else if(key.toString().startsWith("L")){
             return 11;
             
             }
           else if(key.toString().startsWith("M")){
             return 12;
             
             }
           else  if(key.toString().startsWith("N")){
             return 13;
             
             }
           else  if(key.toString().startsWith("O")){
             return 14;
             
             }
             else  if(key.toString().startsWith("P")){
             return 15;
             
             }
             else  if(key.toString().startsWith("Q")){
             return 16;
             
             }
             else  if(key.toString().startsWith("R")){
             return 17;
             
             }
             else  if(key.toString().startsWith("S")){
             return 18;
             
             }
             else  if(key.toString().startsWith("T")){
             return 19;
             
             }
             else  if(key.toString().startsWith("U")){
             return 20;
             
             }
             else  if(key.toString().startsWith("V")){
             return 21;
             
             }
             else  if(key.toString().startsWith("W")){
             return 22;
             
             }
             else  if(key.toString().startsWith("X")){
             return 23;
             
             }
             else  if(key.toString().startsWith("Y")){
             return 24;
             
             }
             else  if(key.toString().startsWith("Z")){
             return 25;
             
             }
             else
             {return 26;}
             
             
         }

         @Override
         public void setConf(Configuration conf) {
             this.conf=conf;
         }

         @Override
         public Configuration getConf() {
             return conf;
         }
 
 }
 
 public static class countryReducer extends Reducer<Text, Text, Text, NullWritable>{
 protected void reduce (Text key, Iterable<Text> values,Context context) throws IOException, InterruptedException{
 for (Text t: values){
 context.write(t, NullWritable.get());
 
 } 
 }
 }
 
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "partitioner");
        job.setJarByClass(CityHubPartitioning.class);
        job.setMapperClass(PartitionMonthMapper.class);
                  job.setReducerClass(countryReducer.class);
        job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(Text.class);
        
         job.setPartitionerClass(PartitionCountryPartitioner.class);
      
       
         job.setNumReduceTasks(27);
          job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
