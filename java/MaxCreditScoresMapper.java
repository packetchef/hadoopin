import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxCreditScoresMapper
	extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	@Override
	public void map(LongWritable key, Text value, Context context)
		throws IOException, InterruptedException {
	
		try {	
			String line = value.toString();

			int linelength = line.length();
			String current_status = String.format("Length of line being processed: %s", linelength);
			System.err.println(current_status);
			String [] line_components = line.split(",");

			current_status = String.format("%s%s", "line value: ", line);
			System.err.println(current_status);

			String ssn = line_components[0];
			current_status = String.format("%s%s", "ssn value: ", ssn);
			System.err.println(current_status);

			String credit_score_split = line_components[1];
			current_status = String.format("%s%s", "credit_score_split value: ", credit_score_split);
			System.err.println(current_status);

			int credit_score = Integer.parseInt(credit_score_split);
			current_status = String.format("%s%s", "credit_score value: ", credit_score);
			System.err.println(current_status);

			context.write(new Text(ssn), new IntWritable(credit_score));
		}
		catch (ArrayIndexOutOfBoundsException exception) {
			System.err.println("Got a line without at least two components");
		}
	}
}

