package cn.datastructure;

public class Answer1_1_3 {
	public static void main(String[] args) {
//		System.out.println(compareThreeArges(501, 50, 50));
		int N=8;
		String s="";
		for (int i = N; i >0; i/=2) {
			s+=i%2;
		}
		System.out.println(s);
	}
	 public static boolean compareThreeArges(long a,long b,long c){
		 return (a==b)&&(b==c);
	 }
}
