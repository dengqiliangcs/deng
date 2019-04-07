package com.wxkj.mr.wordCount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.v2.app.webapp.JobBlock;

public class WordCount {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Job job = Job.getInstance(new Configuration());
		
		//设置主函数所在的类
		job.setJarByClass(WordCount.class);
		
		//组装mapper
		job.setMapperClass(WordCountMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);
		FileInputFormat.setInputPaths(job, new Path("/bss"));
		
		//组装reducer
		job.setReducerClass(WordCountReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		FileOutputFormat.setOutputPath(job, new Path("/wordOut"));
		
		//提交作业(任务)
		job.waitForCompletion(true);
	}

}
