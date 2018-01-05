import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MaxCreditScores {

        public static void main(String [] args) throws Exception {
                if (args.length != 2) {
                        System.err.println("Usage: MaxCreditScore <input path> <output path");
                        System.exit(-1);
                }

                Configuration conf = new Configuration();

                //Job job = new Job.getInstance(conf);
                Job job = new Job();
                job.setJarByClass(MaxCreditScores.class);
                job.setJobName("Max credit scores");

                FileInputFormat.addInputPath(job, new Path(args[0]));
                FileOutputFormat.setOutputPath(job, new Path(args[1]));

                Path outputdir = new Path(args[1]);

                FileSystem hdfs = FileSystem.get(conf);
                if (hdfs.exists(outputdir)) {
                        hdfs.delete(outputdir, true);
                }


                job.setMapperClass(MaxCreditScoresMapper.class);
                job.setReducerClass(MaxCreditScoresReducer.class);

                job.setOutputKeyClass(Text.class);
                job.setOutputValueClass(IntWritable.class);

                // job.waitForCompletion(true);

                System.exit(job.waitForCompletion(true) ? 0 : 1);
        }
}

