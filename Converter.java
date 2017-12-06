package Main;

import java.math.BigInteger;

public class Converter {

	public String[] textToHex(String phrase)
	{
		String temp = String.format("%x", new BigInteger(1, phrase.getBytes(/*YOUR_CHARSET?*/)));
		
		String[] tempArray = new String[temp.length()/2];
		for (int i = 0; i< temp.length()/2; i++)
		{
			tempArray[i] = temp.substring(i*2, i*2+2);
		}
		
		return tempArray;
	}
	
	public String[] CutSymbols(String[] s, int begin, int end)
	{
		String[] temp = new String[end - begin];
		
		
		for (int i = 0; i< end-begin; i++)
		{
			temp[i] = s[begin+i];
		}
		
		
		return temp;
	}
	
	public String DecToHex(int dec)
    {
    	String result = "";
    	
    	
    	int temp;
    	int left = dec;
  
    	do
    	{
    		temp  = dec/16;
    		left = dec%16;
    		
    		if (temp<10)
    	    	result = result+temp+"";
    	    	else
    	    		switch(temp)
    	    		{
    	    		case 10:
    	    			result = result+"a";
    	    			break;
    	    		case 11:
    	    			result = result+"b";
    	    			break;
    	    		case 12:
    	    			result = result+"c";
    	    			break;
    	    		case 13:
    	    			result = result+"d";
    	    			break;
    	    		case 14:
    	    			result = result+"e";
    	    			break;
    	    		case 15:
    	    			result = result+"f";
    	    			break;
    	    			default:
    	    				result = "fdsfsd";
    	    		}
    	}
    	while(left>16);
    	
    	temp = left;
    	
    	if (temp<10)
	    	result = result+temp+"";
	    	else
	    		switch(temp)
	    		{
	    		case 10:
	    			result = result+"a";
	    			break;
	    		case 11:
	    			result = result+"b";
	    			break;
	    		case 12:
	    			result = result+"c";
	    			break;
	    		case 13:
	    			result = result+"d";
	    			break;
	    		case 14:
	    			result = result+"e";
	    			break;
	    		case 15:
	    			result = result+"f";
	    			break;
	    			default:
	    				result = "fdsfsd";
	    		}
    	
    		
    	
    	
    	
    	
    	return result;
    }
	
	
	public  String hexStringToByteArray(String s) {

		return new BigInteger(s, 16).toString(2);
		
	}
	
	
	
}
