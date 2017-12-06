package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Converter converter = new Converter();
	static AESencryptor encryptor = new AESencryptor();
	static MatrixHandler mh = new MatrixHandler();
	
        static String keyPhrase;
        
	static ArrayList<String[]> keys = new ArrayList<String[]>();
	
	public static void main(String[] args) {
                

            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Enter a text to encrypt (16 characters only): ");
            String textToEncrypt = reader.next();
            System.out.println("Enter a keyPhrase to encrypt (16 characters only): ");
            keyPhrase = reader.next();
            reader.close(); 
                
                String[] text = encrypt(textToEncrypt);
                
                println("_______encrypted data is_________");
                println(text);
                println("______________________");
                
		String[] textD = decrypt(text);
                
                
		
	}
	
	private static String[] decrypt(String[] encrptedText)
	{
		
		encrptedText = mh.matrixMultuplication(encrptedText, keys.get(10));
		encrptedText = encryptor.shiftDuringDecryption(encrptedText);
		encrptedText = encryptor.getSInvBOXelement(encrptedText);

		encrptedText = mh.matrixMultuplication(encrptedText, keys.get(9));
		// decryptor is not finished yet
		
		println(encrptedText);
		
		return encrptedText;
	}
	
	
	private static String[] encrypt(String textToEncrypt)
	{
		String[] key = converter.textToHex(keyPhrase);
		
		String[] text = converter.textToHex(textToEncrypt);
		
		String[] ciphertext;
		
		
		// key expander
		
		keys.add(key);
		
		// round 0 over
		ciphertext = mh.matrixMultuplication(text, keys.get(0));
		println(ciphertext);
		
		for (int i = 0; i < 10; i++)
		{
			
			int c = (int) Math.pow(2, i);
			if (i == 8) c = 27;
			if( i == 9) c = 54;
			if( i == 10) c = 108;
			if( i == 11) c = 216;
			if( i == 12) c = 171;
			if( i == 13) c = 77;
			if( i == 14) c = 154;
			
			String[] addConst = makeAddConst(key, c);
			key = encryptor.AddRoundKey(key, addConst);
			
			keys.add(key);
		}
		
		// round 1
		for (int i = 1; i< 10;i++)
		{
			ciphertext = encryptor.getSBOXelement(ciphertext);
			ciphertext = encryptor.shiftDuringEncryption(ciphertext);		
			ciphertext = mh.multiplicar(ciphertext);
			ciphertext = mh.matrixMultuplication(ciphertext, keys.get(i));
		}
		
		// last round
		ciphertext = encryptor.getSBOXelement(ciphertext);
		ciphertext = encryptor.shiftDuringEncryption(ciphertext);		
		ciphertext = mh.matrixMultuplication(ciphertext, keys.get(10));
		println(ciphertext);
				
		return ciphertext;
	}
	
	public static String[] makeAddConst(String[] key, int cons)
	{
		String[] cuttedSymbols = converter.CutSymbols(key,12,16);
		
		String[] shiftedByte = encryptor.byteLeftShift(cuttedSymbols);
		
		
		String[] sBoxed = encryptor.getSBOXelement(shiftedByte);

		String[] addConst = encryptor.addRoundConstant(sBoxed, cons);
		
		return addConst;
	}
	
	
	static void println(Object line) {
	    System.out.println(line);
	}

	static void print(Object line) {
	    System.out.print(line);
	}
	
	
	static void println(String[] line) {
	    
		for (String s:line)
			System.out.print(s+"|");
		
		System.out.print("\n");
		
	}
	

}
