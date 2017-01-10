package binRulz.com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Test {

	
	private static List<String> strArrList;
	private static List<String> wrr = new ArrayList<String>();
	public static String [] backupList;
	public static int [] backupIntList;
	public static int [] wrt;
	public static int from;
	public static int to;
	
	
	public static void main(String[] args) throws IOException {
		
		Test sa = new Test();

		//adding servers url via txt file
		Scanner s = new Scanner(new File("bin_mig.txt"));
		//Scanner s = new Scanner(new File("C:/url/url-input.txt"));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()){
			list.add(s.next());
		}
		strArrList = list;
		s.close();
		//---------------------------------------------------------//
		
		String []txtlist = new String[strArrList.size()];
		strArrList.toArray(txtlist);
		backupList = txtlist;
		
		backupIntList = conSAtoIA(backupList);
		
		
		backupIntList = countingSort(backupIntList);
		
		for(int i : backupIntList){
			//System.out.println(i);
		}
		
		//firstAttempt(backupIntList);
		/*for(int i : backupIntList){
			
			if(i == backupIntList[0]){
				firstAttempt(i);
				System.out.println(from + " \t " + to);
			}
			else if(i == (i-1)){
				System.out.println(" \t " +" blaa");
			}
			else if((i) - (i-1) == 2){
				excep1(i);
				System.out.println(  " \t " + to);
			}
			else { //if((i > (i-1)) &&( (i) - (i-1) >2) )
				secondAttempt(i);
				System.out.println(from + " \t " + to);
			}
			
			
			
		}*/
		
		
		for (int i = 0; i < backupIntList.length; i++){
			//backupIntList[i] = i + 1;
			
			if(backupIntList[i] == backupIntList[0]){
				firstAttempt(backupIntList[i]);
				System.out.println(from + " \t " + to);
				wrr.add(from + " \t " + to);
				
			}
			else if(backupIntList[i] - backupIntList[i-1] == 1){
				//from++;
				excep1(backupIntList[i]);
				System.out.println(" \t " +" ");
				
			}
			else if(backupIntList[i] - backupIntList[i-1] == 2){
				excep1(backupIntList[i]);
				System.out.println(  " \t " + to);
				wrr.add( " \t " + to);
				
			}
			else if(backupIntList[i] > backupIntList[i-1] && backupIntList[i] - backupIntList[i-1] > 2) { //if((i > (i-1)) &&( (i) - (i-1) >2) )
				secondAttempt(backupIntList[i]);
				System.out.println(from + " \t " + to);
				wrr.add(from + " \t " + to);
				
			}
			else if(backupIntList[i] == backupIntList[backupIntList.length -1]){
				//lastAttempt(backupIntList[i]);
				//secondAttempt(backupIntList[i]);
				lastAttempt(backupIntList[i]);
				//lastAttempt(backupIntList[i]);
				System.out.println(from + " \t " + to);
				wrr.add(from + " \t " + to);
				
			}
			else if(backupIntList[i] == backupIntList[i-1]){
				
				
			}
			
		}
		//System.out.println(backupIntList.length);
			//System.out.println(backupIntList[backupIntList.length -1]);
		String [] arrr = new String[wrr.size()];
		writeFile1(backupIntList);
		wrr.toArray(arrr);
		writeFile2(arrr);
		/*try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("bin-rules.txt"), "utf-8"))) {
			//writer.write("something");
			for(int i : backupIntList){
				//System.out.println(i);
				writer.write(i);
				
			}
			
		}*/
	
		
		
	}
	
	
	
	public static void writeFile2(String [] arr) throws IOException {
		File fout = new File("bin-rules2.txt");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		for(String ii : arr){
			bw.write(ii);
			bw.newLine();
		}
		
		/*for (int i = 0; i < 10; i++) {
			bw.write("something");
			bw.newLine();
		}
	 */
		bw.close();
	}
	
	
	
	
	
	
	public static void writeFile1(int [] arr) throws IOException {
		File fout = new File("bin-rules.txt");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		for(int ii : arr){
			bw.write(Integer.toString(ii));
			bw.newLine();
		}
		
		/*for (int i = 0; i < 10; i++) {
			bw.write("something");
			bw.newLine();
		}
	 */
		bw.close();
	}
	
	
	public static int[] conSAtoIA(String [] numberStrs){
		
		
		int[] numbers = new int[numberStrs.length];
		for(int i = 0;i < numberStrs.length;i++)
		{
		    numbers[i] = Integer.parseInt(numberStrs[i]);
		}
		return numbers;
	}
	
	
	
/*	
	private Integer[] processLine(String[] strings) {
	    Integer[] intarray=new Integer[strings.length];
	    int i=0;
	    for(String str:strings){
	    	intarray[i]=Integer.parseInt(str.trim());
	        i++;
	    }
	    return intarray;
	}*/

	public static int[] countingSort(int[] numbers) {
	    int max = numbers[0];
	    for (int i = 1; i < numbers.length; i++) {
	        if (numbers[i] > max)
	            max = numbers[i];
	    }

	    int[] sortedNumbers = new int[max+1];

	    for (int i = 0; i < numbers.length; i++) {
	        sortedNumbers[numbers[i]]++;
	    }

	    int insertPosition = 0;

	    for (int i = 0; i <= max; i++) {
	            for (int j = 0; j < sortedNumbers[i]; j++) {
	                    numbers[insertPosition] = i;
	                    insertPosition++;
	            }
	    }
	    return numbers;
	}
	
	public static void firstAttempt(int i){
		
		//from 
		from = i/100000;
		from = from*100000;
		
		//to
		to = i -1;
		 
	}
	
	public static void secondAttempt(int i){
		
		from =  to + 2;
		
		to  = i -1;
	}
	
	public static void excep1(int i){
		to  = i -1;
	}
	public static void excep2(int i){
		//from = to +2;
		to = i -1;
	}
	public static void lastAttempt(int i){
		
		from =  i + 1;
		
		to = 999999;
	}
	
	
}
