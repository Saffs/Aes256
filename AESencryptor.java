package Main;

import java.math.BigInteger;
import java.util.ArrayList;

public class AESencryptor {

	private static final int Nr = 3;
	
	private static final String[] SBox = 
			{"63", "7c", "77", "7b", "f2", "6b", "6f", "c5", "30", "01", "67", "2b", "fe", "d7", "ab", "76"
			,"ca", "82", "c9", "7d", "fa", "59", "47", "f0", "ad", "d4", "a2", "af", "9c", "a4", "72", "c0"
			,"b7", "fd", "93", "26", "36", "3f", "f7", "cc", "34", "a5", "e5", "f1", "71", "d8", "31", "15"
			,"04", "c7", "23", "c3", "18", "96", "05", "9a", "07", "12", "80", "e2", "eb", "27", "b2", "75"
			,"09", "83", "2c", "1a", "1b", "6e", "5a", "a0", "52", "3b", "d6", "b3", "29", "e3", "2f", "84"
			,"53", "d1", "00", "ed", "20", "fc", "b1", "5b", "6a", "cb", "be", "39", "4a", "4c", "58", "cf"
			,"d0", "ef", "aa", "fb", "43", "4d", "33", "85", "45", "f9", "02", "7f", "50", "3c", "9f", "a8"
			,"51", "a3", "40", "8f", "92", "9d", "38", "f5", "bc", "b6", "da", "21", "10", "ff", "f3", "d2"
			,"cd", "0c", "13", "ec", "5f", "97", "44", "17", "c4", "a7", "7e", "3d", "64", "5d", "19", "73"
			,"60", "81", "4f", "dc", "22", "2a", "90", "88", "46", "ee", "b8", "14", "de", "5e", "0b", "db"
			,"e0", "32", "3a", "0a", "49", "06", "24", "5c", "c2", "d3", "ac", "62", "91", "95", "e4", "79"
			,"e7", "c8", "37", "6d", "8d", "d5", "4e", "a9", "6c", "56", "f4", "ea", "65", "7a", "ae", "08"
			,"ba", "78", "25", "2e", "1c", "a6", "b4", "c6", "e8", "dd", "74", "1f", "4b", "bd", "8b", "8a"
			,"70", "3e", "b5", "66", "48", "03", "f6", "0e", "61", "35", "57", "b9", "86", "c1", "1d", "9e"
			,"e1", "f8", "98", "11", "69", "d9", "8e", "94", "9b", "1e", "87", "e9", "ce", "55", "28", "df"
			,"8c", "a1", "89", "0d", "bf", "e6", "42", "68", "41", "99", "2d", "0f", "b0", "54", "bb", "16"};
	
	private static final String[] InvBox =
			{"52", "09", "6a", "d5", "30", "36", "a5", "38", "bf", "40", "a3", "9e", "81", "f3", "d7", "fb"
			,"7c", "e3", "39", "82", "9b", "2f", "ff", "87", "34", "8e", "43", "44", "c4", "de", "e9", "cb"
			,"54", "7b", "94", "32", "a6", "c2", "23", "3d", "ee", "4c", "95", "0b", "42", "fa", "c3", "4e"
			,"08", "2e", "a1", "66", "28", "d9", "24", "b2", "76", "5b", "a2", "49", "6d", "8b", "d1", "25"
			,"72", "f8", "f6", "64", "86", "68", "98", "16", "d4", "a4", "5c", "cc", "5d", "65", "b6", "92"
			,"6c", "70", "48", "50", "fd", "ed", "b9", "da", "5e", "15", "46", "57", "a7", "8d", "9d", "84"
			,"90", "d8", "ab", "00", "8c", "bc", "d3", "0a", "f7", "e4", "58", "05", "b8", "b3", "45", "06"
			,"d0", "2c", "1e", "8f", "ca", "3f", "0f", "02", "c1", "af", "bd", "03", "01", "13", "8a", "6b"
			,"3a", "91", "11", "41", "4f", "67", "dc", "ea", "97", "f2", "cf", "ce", "f0", "b4", "e6", "73"
			,"96", "ac", "74", "22", "e7", "ad", "35", "85", "e2", "f9", "37", "e8", "1c", "75", "df", "6e"
			,"47", "f1", "1a", "71", "1d", "29", "c5", "89", "6f", "b7", "62", "0e", "aa", "18", "be", "1b"
			,"fc", "56", "3e", "4b", "c6", "d2", "79", "20", "9a", "db", "c0", "fe", "78", "cd", "5a", "f4"
			,"1f", "dd", "a8", "33", "88", "07", "c7", "31", "b1", "12", "10", "59", "27", "80", "ec", "5f"
			,"60", "51", "7f", "a9", "19", "b5", "4a", "0d", "2d", "e5", "7a", "9f", "93", "c9", "9c", "ef"
			,"a0", "e0", "3b", "4d", "ae", "2a", "f5", "b0", "c8", "eb", "bb", "3c", "83", "53", "99", "61"
			,"17", "2b", "04", "7e", "ba", "77", "d6", "26", "e1", "69", "14", "63", "55", "21", "0c", "7d"};

	public String[] shiftDuringEncryption(String[] str)
	{
		String[] result = new String[str.length];
		
		for (int i = 0; i < str.length/4; i++)
		{
			int b = i*4;
			
			result[b] = str[b];
			
			if (b+1+4 < str.length)
				result[b+1] = str[b+1+4];
			else
				result[b+1] = str[b+1-3*4];
			
			if (b+2+2*4 < str.length)
				result[b+2] = str[b+2+2*4];
			else
				result[b+2] = str[b+2-2*4];
			
			if(b+3+3*4<str.length)
				result[b+3] = str[b+3+3*4];
			else
				result[b+3] = str[b+3-1*4];
		}
		
		return result;
	}
	
	public String[] shiftDuringDecryption(String[] str)
	{
		String[] result = new String[str.length];
		
		for (int i = str.length/4; i > 0; i--)
		{
			int b = i*4-1;
			
			System.out.println(b);
			
			result[b-3] = str[b-3];
			
			if (b-2-4 > 0)
				result[b-2] = str[b-2-4];
			else
				result[b-2] = str[b+2+2*4];
			
			if (b-1-2*4 > 0)
				result[b-1] = str[b-1-2*4];
			else
				result[b-1] = str[b-1+2*4];
			
			if(b-3*4>0)
				result[b] = str[b-3*4];
			else
				result[b] = str[b+1*4];
		}
		
		return result;
	}
	
	
	
	public String[] byteLeftShift(String[] s)
	{
		String[] result = new String[s.length];
		
		for (int i = 1; i < s.length; i++)
		{
			result[i-1] = s[i];
		}
		
		result[s.length-1] = s[0];
		
		return result;
	}
	
	
	public String[] getSBOXelement (String[] array)
	{
		String[] outArray = new String[array.length];
		
		int i = 0;
		for(String S:array)
		{
			char[] ch = S.toCharArray();
			
			int b = Integer.parseInt(ch[0]+"", 16);
			int c = Integer.parseInt(ch[1]+"", 16);
			
			outArray[i++] = SBox[b*16+c];	
		}
		
		return outArray;	
	}
	
	
	public String[] getSInvBOXelement (String[] array)
	{
		String[] outArray = new String[array.length];
		
		int i = 0;
		for(String S:array)
		{
			char[] ch = S.toCharArray();
			
			int b = Integer.parseInt(ch[0]+"", 16);
			int c = Integer.parseInt(ch[1]+"", 16);
			
			outArray[i++] = InvBox[b*16+c];	
		}
		
		return outArray;	
	}
	
	
	public String[] addRoundConstant(String[] s, int i)
	{
		String[] out = new String[s.length];
		
		out = s;
		
		int b = Integer.parseInt(s[0], 16);
		int c = b ^ i;
		
		String temp = Integer.toHexString(c);
		if(c <=15)
		{
			temp = "0" + temp;
		}
		out[0] = temp;
		return out;
	}
	
	
	
	
	
	public String[] AddRoundKey(String[] key, String[] changed) 
	{
		MatrixHandler mh = new MatrixHandler();
		Converter converter = new Converter();
		StringBuilder sb = new StringBuilder();
				
		ArrayList<String> arL = new ArrayList<String>();
		
			String[] m0 = converter.CutSymbols(key,0,4);	
			String[] m1 = converter.CutSymbols(key,4,8);
			String[] m2 = converter.CutSymbols(key,8,12);
			String[] m3 = converter.CutSymbols(key,12,16);
			
			String[] m4 = mh.matrixMultuplication(m0, changed);
			String[] m5 = mh.matrixMultuplication(m1, m4);
			String[] m6 = mh.matrixMultuplication(m2, m5);
			String[] m7 = mh.matrixMultuplication(m3, m6);
			
			String[] temp = new String[m0.length*4];
			
			for(String s : m4)
				arL.add(s);
			
			for(String s : m5)
				arL.add(s);
			
			for(String s : m6)
				arL.add(s);
			
			for(String s : m7)
				arL.add(s);
	
		String[]  haha = new String[arL.size()];
		
		for (int i = 0; i < arL.size(); i++)
			haha[i] = arL.get(i);
			
		return haha;
	}


	private void SubBytes() {
		// TODO Auto-generated method stub
		
	}



	private void ShiftRows() {
		// TODO Auto-generated method stub
		
	}



	private void MixColumns() {
		// TODO Auto-generated method stub
		
	}



	



	private void addRoundKey(int i)
	{
	}
	
	
}
