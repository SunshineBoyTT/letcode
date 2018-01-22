/**
 * 
 */
package cn.java8lambda;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Description:
 * @author zhengjuntao@hjtechcn.cn
 * @Since:2017年7月7日
 * @Version:1.1.0
 */
public class Demo_1 {

	/** 
	 * @Title: main 
	 * @Description:
	 * @param @param args    
	 * @return void    返回类型 
	 * @throws 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//线程
//		new Thread(()->{
//			System.out.println(1);
//		}).start();
		//对数组进行字典排序
//		String[] datas=new String[]{"zheng","jun","tao"};
//		Arrays.sort(datas);
//		Stream.of(datas).forEach(params->{
//			System.out.println(params);
//		});
		//自定义排序
//		Arrays.sort(datas,(v1,v2)->Integer.compare(v2.length(), v1.length()));
//		Stream.of(datas).forEach(items->{
//			System.out.println(items);
//		});
//		List<String> list=new ArrayList<>();
//		list.add("zheng");
//		list.add("jun");
//		list.add("tao");
//		Predicate<String> condation=(str)->(str).length()>4;
//		Predicate<String> startsWithJ = (n) -> n.startsWith("z");
//		list.stream().filter((name)->(condation.and(startsWithJ).test(name))).forEach(System.out::println);
		//获取数字的个数、最小值、最大值、总和以及平均值
//		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
//		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
//		System.out.println("Highest prime number in List : " + stats.getMax());
//		System.out.println("Lowest prime number in List : " + stats.getMin());
//		System.out.println("Sum of all prime numbers : " + stats.getSum());
//		System.out.println("Average of all prime numbers : " + stats.getAverage());
//		long i=9223372036854775807l;
//		System.out.println(i);
//		System.out.println((int)i);
//		System.out.println(Long.MAX_VALUE);
	}

}
