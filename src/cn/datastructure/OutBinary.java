package cn.datastructure;

import java.util.Scanner;

/**
 * Java 输出整数的二进制
 * @author Administrator
 *
 */
public class OutBinary {

	 public static void main(String[] args) {  
		 System.out.println(toBinaryString(1));
	 }  
	 
	 public static String toBinaryString(int num) {
	        if (num == 0) return ""+0;
	        String result = "";
	        // 左面0的个数
	        int n = Integer.numberOfLeadingZeros(num);
	        System.out.println("num <<= n"+(num <<= n));
	        for (int i=0; i<32-n; ++i) {
	            int x = (Integer.numberOfLeadingZeros(num) == 0)?1:0;
	            result += x;
	            num <<= 1;
	        }
	        return result;
	   }

}
