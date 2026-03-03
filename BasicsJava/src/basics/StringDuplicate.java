package basics;

import java.util.*;

public class StringDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the string :");
		String s=sc.nextLine();
		char[] c=s.toCharArray();
		int n=c.length;
	
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(c[i]==c[j]) {
					c[j]='1';
				
				
			//		System.out.print(c[j]);
				}
			//	
			}
		}
	for(int i=0;i<n;i++) {
			if(c[i]!='1') {
				System.out.print(c[i]);
				
			}
		}
	}

}
