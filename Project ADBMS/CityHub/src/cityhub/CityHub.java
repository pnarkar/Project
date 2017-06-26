/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cityhub;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 *
 * @author pranali
 */
public class CityHub extends Configured implements Tool {

    @Override
    public int run(String[] strings) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "ReduceJoin");
        job.setJarByClass(CityHub.class);

        MultipleInputs.addInputPath(job, new Path(strings[0]), TextInputFormat.class, JoinMapper1.class);
        MultipleInputs.addInputPath(job, new Path(strings[1]), TextInputFormat.class, JoinMapper2.class);
        job.getConfiguration().set("join.type", "innerjoin");

        job.setReducerClass(JoinReducer.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job, new Path(strings[2]));

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        boolean complete = job.waitForCompletion(true);
        Configuration conf1 = new Configuration();
        Job job2 = Job.getInstance(conf1,"chaining");
        if(complete){
             job2.setJarByClass(CityHub.class);
             
        MultipleInputs.addInputPath(job2, new Path(strings[2]), TextInputFormat.class, JoinMapper3.class);
        MultipleInputs.addInputPath(job2, new Path(strings[3]), TextInputFormat.class, JoinMapper4.class);
        job2.getConfiguration().set("join.type", "innerjoin");
        
          job2.setReducerClass(JoinReducer1.class);
        job2.setOutputFormatClass(TextOutputFormat.class);
      

        job2.setOutputKeyClass(Text.class);
        job2.setOutputValueClass(Text.class);
          TextOutputFormat.setOutputPath(job2, new Path(strings[4]));
      }
        boolean success = job2.waitForCompletion(true);
        return success ? 0 : 4;
       
    }
    

    public static class JoinMapper1 extends Mapper<Object, Text, Text, Text> {
       
        private Text outKey = new Text();
        private Text outValue = new Text();

        public void map(Object key, Text value, Context context) {
            try {
               
        
                String[] cityData = value.toString().split(",");
                String city = cityData[0].trim();
                
               String str= city.substring(1, city.length()-1);
           
                if (str == null) {
                    return;
                }
               
                System.out.println(str +"11");
                outKey.set(str);
                outValue.set("A" + value);

                context.write(outKey, outValue);
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(CityHub.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static class JoinMapper2 extends Mapper<Object, Text, Text, Text> {

        private Text outKey = new Text();
        private Text outValue = new Text();

        public void map(Object key, Text value, Context context) {
            try {
                String[] cityData = value.toString().split(",");
                String city = cityData[0].trim();
                
                System.out.println(city +"12");

                if (city == null) {
                    return;
                }

                outKey.set(city);
                outValue.set("B" + value);

                context.write(outKey, outValue);
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(CityHub.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    
   

        
        

    
      public static class JoinReducer extends Reducer<Text, Text, Text, Text> {

        private static final Text EMPTY_TEXT = new Text();
        private Text tmp = new Text();

        private ArrayList<Text> listA = new ArrayList<Text>();
        private ArrayList<Text> listB = new ArrayList<Text>();
        // private ArrayList<Text> listC = new ArrayList<Text>();

        private String joinType = null;

        public void setup(Context context) {
            joinType = context.getConfiguration().get("join.type");
        }

        public void reduce(Text key, Iterable<Text> values, Context context) throws InterruptedException, IOException {
            listA.clear();
            listB.clear();

            while (values.iterator().hasNext()) {
                tmp = values.iterator().next();

                if (tmp.charAt(0) == 'A') {
                    listA.add(new Text(tmp.toString().substring(1)));
                } else if (tmp.charAt(0) == 'B') {
                    listB.add(new Text(tmp.toString().substring(1)));
                }
                
            }

            executeJoinLogic(context);

        }
    
    
     private void executeJoinLogic(Context context) throws InterruptedException, IOException {
         
         if(joinType.equalsIgnoreCase("innerjoin"))
         {
             if(!listA.isEmpty() && !listB.isEmpty() ) 
             {
                 for(Text A : listA)
                 {
                     for(Text B : listB)
                     {
                        
                             
                         
                         context.write(A,B);
                         
                     }
                 }
             }
         }
     }
     }
              public static class JoinMapper3 extends Mapper<Object, Text, Text, Text> {

        private Text outKey = new Text();
        private Text outValue = new Text();

        public void map(Object key, Text value, Context context) {
            try {
                String[] cityData = value.toString().split(",");
                String city = cityData[0].trim();
 String str= city.substring(1, city.length()-1);
                if (str == null) {
                    return;
                }

                outKey.set(str);
                outValue.set("C" + value);

                context.write(outKey, outValue);
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(CityHub.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
              
              public static class JoinMapper4 extends Mapper<Object, Text, Text, Text> {

        private Text outKey = new Text();
        private Text outValue = new Text();

        public void map(Object key, Text value, Context context) {
            try {
                String[] cityData = value.toString().split(",");
                String city = cityData[0].trim();

                if (city == null) {
                    return;
                }

                outKey.set(city);
                outValue.set("D" + value);

                context.write(outKey, outValue);
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(CityHub.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
      
public static class JoinReducer1 extends Reducer<Text, Text, Text, Text> {

        private static final Text EMPTY_TEXT = new Text();
        private Text tmp = new Text();

        private ArrayList<Text> listC = new ArrayList<Text>();
        private ArrayList<Text> listD = new ArrayList<Text>();
        // private ArrayList<Text> listC = new ArrayList<Text>();

        private String joinType = null;

        public void setup(Context context) {
            joinType = context.getConfiguration().get("join.type");
        }

        public void reduce(Text key, Iterable<Text> values, Context context) throws InterruptedException, IOException {
            listC.clear();
            listD.clear();

            while (values.iterator().hasNext()) {
                tmp = values.iterator().next();

                if (tmp.charAt(0) == 'C') {
                    listC.add(new Text(tmp.toString().substring(1)));
                } else if (tmp.charAt(0) == 'D') {
                    listD.add(new Text(tmp.toString().substring(1)));
                }
                
            }

            executeJoinLogic(context);

        }
    
    
     private void executeJoinLogic(Context context) throws InterruptedException, IOException 
     {
         
         if(joinType.equalsIgnoreCase("innerjoin"))
         {
             if(!listC.isEmpty() && !listD.isEmpty()) 
             {
                 for(Text C : listC)
                 {
                     for(Text D : listD)
                     {
                        
                             
                         
                         context.write(C,D);
                         
                     }
                 }
             }
         }
     }
}
      
       public static void main(String[] args) throws Exception {
        try {
            int res = ToolRunner.run(new Configuration(), new CityHub(), args);
        } catch (IOException ex) {
            Logger.getLogger(CityHub.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
