package com.wxkj.mr.wordCount;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

	LongWritable v3 = new LongWritable();
	
	@Override
	protected void reduce(Text k2, Iterable<LongWritable> v2,
			Context context) throws IOException, InterruptedException {
		Iterator<LongWritable> iterator= v2.iterator();
		long count=0;
		while(iterator.hasNext()) {
			LongWritable i = iterator.next();
			count += i.get();
		}
		v3.set(count);
		context.write(k2, v3);
	}

	
}
