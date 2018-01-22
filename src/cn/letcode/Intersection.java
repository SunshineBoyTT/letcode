/**
 * 
 */
package cn.letcode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

/**
 * @Description:
 * @author zhengjuntao@hjtechcn.cn
 * 有两个有序的集合，集合的每个元素都是一段范围，求其交集，例如集合{[4,8],[9,13]}和{[6,12]}的交集为{[6,8],[9,12]}
 * @Since:2017年12月6日
 * @Version:1.1.0
 */
public class Intersection {
	
	public static void main(String[] args) throws Exception {
		createNumber(10000);
	}
	
	public static void createNumber(int length) throws Exception{
		StringBuffer stringBuffer=new StringBuffer();
		Random random=new Random();
		File file=new File("c://output1.txt");
		FileWriter writer=new FileWriter(file);
		for (int i = 0; i < length; i++) {
			stringBuffer.append(random.nextInt(100)+" ");
		}
		writer.write(stringBuffer.toString());
		writer.flush();
		writer.close();
	}
}
