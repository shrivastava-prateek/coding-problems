package com.hackajob;

public class MorseCode {

	public static void main(String[] args) {
		System.out.println(run(false, "The wizard quickly jinxed the gnomes before they vaporized."));

	}
	public static String run(boolean morseToEnglish, String textToTranslate) {
		/*
		* Some work here; return type and arguments should be according to the problem's requirements
		*/
		char[] alpha = {'0','1', '2', '3', '4', '5', '6', '7', '8',
				'9','A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			    'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			    'W', 'X', 'Y', 'Z'};
		
		String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
			    "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
			    "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
			    "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
			"-....", "--...", "---..", "----.", "-----"};
		
		String translatedText = "";
		
		if(!morseToEnglish) {
			StringBuffer morseCode = new StringBuffer();
			textToTranslate.toUpperCase();
			for(char c:textToTranslate.toCharArray()) {
				if(c == ' ') morseCode.append("   ");
				else {
					morseCode.append(" ");
					morseCode.append(morse[getIndex(alpha, c)]);
				}
				System.out.println(getIndex(alpha, c));
			}
			translatedText = morseCode.toString().trim();
		}
		
		
		return translatedText;
	}
	
	public static int getIndex(char[] alpha, char c) {
	
		System.out.println("Calculating Index for: "+c);
		int lb = 0;
		int ub = alpha.length-1;
		
		while(lb<ub) {
		int middle = (lb+ub)/2;
		System.out.println("Middle: "+middle);
		if(c<alpha[middle]) {
			lb=0;
			ub=middle;
		}
		else if(c>alpha[middle]) {
			lb=middle;
			ub = alpha.length-1;
		}
		else return middle;
		}
		return 0;
	}
	

}
