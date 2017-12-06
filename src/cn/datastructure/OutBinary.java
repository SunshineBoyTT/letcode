package cn.datastructure;

import java.util.Scanner;

/**
 * Java 输出整数的二进制
 * @author Administrator
 *
 */
/**
 * 解题思路:知识预热:第一个Integer.numberOfLeadingZeros(num)计算二进制的num左边0个数。第二个作用是.假如左边还有0,说明接下来的x这项是0.
 * 详细讲解的博客   http://blog.csdn.net/hr_tao/article/details/73823421
 *
 */
public class OutBinary {

	 public static void main(String[] args) {  
		 System.out.println(toBinaryString(9));
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
