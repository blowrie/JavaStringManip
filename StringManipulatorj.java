import java.util.*;


public class Untitled{
	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		List<String> sList = new ArrayList<String>();
		String input;
		int count = 0; 
		int num1 = 0;
	
		//End Stat Variables
		List<Integer> median = new ArrayList<Integer>();
		int inNum = 0;
		int outNum = 0;
		int finalMed = 0;
		//if length for median is even
		int num2 = 0;
		
	
		System.out.println("Please enter a list of strings and type 'done' when finished");
		do {
			input = reader.nextLine();
			sList.add(input);
			if(input.equals("!")) {
				sList.remove(input);
			}
			inNum = inNum + input.length();
			median.add(input.length());
		} while (!input.equals("!"));
		
		Manipulate(sList);
		
		for(String s: sList) {
			System.out.println(s);
			outNum = outNum + s.length();
			median.add(s.length());
		}
		
		Collections.sort(median);
		count = median.size();
		if(count % 2 == 1) {
			num1 = count / 2;
			finalMed = median.get(num1);
		}
		else {
			num1 = count / 2;
			num2 = (count /2) + 1;
			finalMed = (median.get(num1) + median.get(num2)) / 2;
		}
		
		System.out.println("");
		System.out.println("The total number of characters input are: " + inNum);
		System.out.println("The total number of characters output are: " + outNum);
		System.out.println("The median of the string length: " + finalMed);
		for(int i: median) {
			System.out.print(i + ", ");
		}
	}
	
	static void Manipulate(List<String> myStrings) {
		int upCount = 0; 
		
		for (int i = 0; i < myStrings.size(); i++) {
			String s = myStrings.get(i);
			int length = s.length();
			char[] charArray = s.toCharArray();
			
			//Part 1
			if(length % 4 == 0) {
				String flip = "";
				for (int j = charArray.length-1; j >= 0; j--) {
					flip += charArray[j];
				}
				myStrings.set(i, flip);
			}
			
			//Part 2
			if(length % 5 == 0) {
				myStrings.set(i, myStrings.get(i).substring(0, 5));
			}
			
			//Part 3
			for (char c: charArray) {
				if(Character.isUpperCase(c)) {
					upCount = upCount + 1;
					if(upCount == 3) {
						myStrings.set(i, myStrings.get(i).toUpperCase());
						upCount = 0;
					}
				}
			}
			
			//Part 4
			for (int j = 0; j < charArray.length; j++) {
				if(charArray[j] == '-') {
					myStrings.set(i, myStrings.get(i).substring(0, j) + myStrings.get(i + 1));
				}
			}
		}
	}

//End Bracket
}


