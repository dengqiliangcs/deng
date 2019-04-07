package com.wxkj.mr.wordCount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

	Text k2=new Text();
	LongWritable v2 = new LongWritable();
	
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		//将Text类型的一行呢荣转换为String类型
		String line=value.toString();
		//将该行内容切割为多个单词组成的数组
		String[] strings = line.split("\t");
		//遍历当前数组，将其中的每一个单词进行输出
		for(int i=0;i<strings.length;i++) {
			String word=strings[i];
			k2.set(word);
			v2.set(1);
			context.write(k2, v2);
		}
		
	}

	
}
