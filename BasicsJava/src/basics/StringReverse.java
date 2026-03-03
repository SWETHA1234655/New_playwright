package basics;

import java.util.Scanner;

public class StringReverse {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string :");
		String s=sc.nextLine();
		char[] c=s.toCharArray();
		System.out.println(c);
		
		for(int i=c.length-1;i>=0;i--) {
			System.out.print(c[i]);
		}
/*		int n=s.length();
		System.out.println(n);
		for(int i=n-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
		*/
	}

}
