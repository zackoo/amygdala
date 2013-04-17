import java.util.*;
import java.io.*;

public class personality {
	public static void main (String[]args)
	throws FileNotFoundException{
		Scanner input = new Scanner (new File 
				("/home/zacko/Downloads/Personality.txt"));

		
		while (input.hasNextLine()){
			String line = input.nextLine();
			if (line.length() > 69){
				String ans = line;
				//int[] dimList = process(ans);
				
				System.out.print(Arrays.toString(process(ans)));
				makeAcro(process(ans));
				System.out.println();
				
				}else{
				System.out.print(line + ": "); 
			}
		}
	}
	
	/*builds the 4 Dimensions arrays and fills in 
	 * values based on the string 'ans'
	 * returns an array of all % of each dim
	 */
	public static int[] process(String ans){
		
		char [] D1 = new char [10];
		char [] D2 = new char [20];
		char [] D3 = new char [20];
		char [] D4 = new char [20];
		
		int j = 0;
		int k = 0;
		int l = 0;
		int m = 0;
		
		for(int i = 0; i <= 69; i++){
			
			if (i == 0 || i%7 == 0){
				D1[j]= ans.charAt(i);
				j++;
			}
			if (i == 1||i == 2|| i%7 == 1|| i%7 == 2){
				D2[k]= ans.charAt(i);
				k++;
			}
			if (i == 3||i == 4|| i%7 == 3|| i%7 == 4){
				D3[l]= ans.charAt(i);
				l++;
			}
			if (i == 5||i == 6|| i%7 == 5|| i%7 == 6){
				D4[m]= ans.charAt(i);
				m++;
			}
		}
		int [] dimPer = new int [4];
		dimPer[0] = percent(Arrays.toString(D1));
		dimPer[1] = percent(Arrays.toString(D2));
		dimPer[2] = percent(Arrays.toString(D3));
		dimPer[3] = percent(Arrays.toString(D4));
		
		return dimPer; 
		
	}
	/*takes the string built from the D array and 
	 * calculates the % of As and Bs and returns 
	 * a string [][] of % and  personality  
	 */
	public static int percent(String dim){
		double Acount = 0; 
		double Bcount = 0;
		for(int i = 0; i < dim.length(); i++){
			if (dim.charAt(i)== 'a' || dim.charAt(i)== 'A'){
				Acount++;
			}
			if (dim.charAt(i)== 'b' || dim.charAt(i)== 'B'){
				Bcount++;
			}
		} 
		//System.out.println("a = " + Acount);
		//System.out.println("b = " + Bcount);
		double total = Acount + Bcount; 
		if (Acount != Bcount){
			return (int)(.5 +(Bcount/total)*100);
		}else{
			return 50;
		}
	}
	public static void makeAcro(int [] list){
		String [] alist = {"E","S","T","J"};
		String [] blist = {"I","N","F","P"};
		String[] newList = new String [4];
		for (int i = 0; i < list.length; i++){
			if (list [i] < 50){
			newList[i] = alist[i]; 
			}else{
				newList[i]= blist[i];
			}
		}
		printList(newList);
		}
	public static void printList(String [] list){
		System.out.print(list[0]);
		for (int i =1; i< list.length; i++){
			System.out.print(list[i]);
			
		}
	}
	

}
