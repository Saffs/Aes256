package Main;

public class MatrixHandler {
	
	private Converter conv = new Converter();
	
	
	public String[] matrixMultuplication(String[] m1, String[] m2)
	{


			String[] temp = new String[m1.length];
		
		
		
	
		for (int i = 0; i < m1.length; i++)
		{
			int m11= Integer.parseInt(m1[i],16);
			int m22 = Integer.parseInt(m2[i],16);
			
			String m3 = Integer.toHexString(m11^m22);
			
			if (m3.length() == 1)
				m3 = "0" + m3;
			
			temp[i] = m3;
		}
			
			
		
		return temp;
	}
	
	
	public String[] matrixMultuplicationDuringEncryption( String[] cipher)
	{
		
			String[] temp = new String[16];
		
			String[][] mult = { 
					
							  {"02", "01", "01", "03"},
							  {"03", "02", "01", "01"},
							  {"01", "03", "02", "01"},
							  {"01", "01", "03", "02"}
					
							};
			
			String[][] mult2 = { 
					
					  {"63", "EB", "9F", "A0"},
					  {"2F", "93", "92", "C0"},
					  {"AF", "C7", "AB", "30"},
					  {"A2", "20", "CB", "2B"}
			
					};
			
			for (int i = 0; i < mult.length; i++)
			{
				for (int j = 0; j < mult[0].length; j++)
				{
					int m11= Integer.parseInt(mult[i][j],16);	
					int m22= Integer.parseInt(mult2[j][i],16);
					
					int tempResult;
					if (m11 == 3)
					{
						tempResult = (m22*2)^m22;
					}
					else
					{
						tempResult = m22*m11;
					}
					
					temp[i*mult.length + j] = Integer.toHexString(tempResult);;
					
				}
				
			}
			
					
		return temp;
	}
	
	
	  public  String[] multiplicar(String[] array)
	    {
		    Integer[][] A = { { 2, 3,1 , 1 }, { 1, 2, 3, 1 }, { 1, 1, 2, 3}, { 3, 1, 1, 2 } };  
		    Integer[][] B = { { 99, 235, 159, 160 }, { 47, 147, 146, 192 }, { 175, 199, 171, 48 },  {162, 32, 203, 43 } };

//		    Integer[][] B = new Integer[array.length/4][array.length/4];
		    
		   
		
		    
		    
		    
		    System.out.println();
		    
		    
		    for (int i = 0; i < array.length/4; i++)
		    {
		    	for (int j = 0; j <array.length/4; j++)
		    	{
		    		String temp = array[array.length/4*j + i];
		    		
		    		int b = Integer.parseInt(temp, 16);
		    		
		    		B[i][j] = b;
		    		
		    		
		    	}	
		    	
		    }
		    
		    
	    	
	    	int aRows = A.length;
	        int aColumns = A[0].length;
	        int bRows = B.length;
	        int bColumns = B[0].length;

	        
	        if (aColumns != bRows) {
	            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
	        }

	        Integer[][] C = new Integer[aRows][bColumns];
	        for (int i = 0; i < aRows; i++) {
	            for (int j = 0; j < bColumns; j++) {
	            	
	                C[i][j] = 0;
	            
	            }
	        }

	        for (int i = 0; i < aRows; i++) { // aRow
	            for (int j = 0; j < bColumns; j++) { // bColumn
	            	
	            	
	                for (int k = 0; k < aColumns; k++) { // aColumn
	                	
	                	
	                	if (A[i][k] == 2)
	                	{
	                		int b = B[k][j];
	                		
	                		
	                		
	                		int temp_mult = (2*b);
	                		
	                		
	                		if (b>=128)
	                			temp_mult = temp_mult^27;
	                		
	            			if (temp_mult > 255)
	            				temp_mult = Math.floorMod(temp_mult, 256);
	            			
	            			
	            			
	                		C[i][j] = C[i][j] ^ temp_mult;
		
	                		
	                	}
	                    
	                	
	                	
	                	
	                	else if (A[i][k] == 3)
	                	{
	                		
	                		
	                		int b = B[k][j];
	                		
	                		
	                		
	                		int temp_mult = (2*b);
	                		
	                		if (b>=128)
	                			temp_mult = temp_mult^27;

	                		
	                			if (temp_mult > 255)
	                				temp_mult = Math.floorMod(temp_mult, 256);
	                		
	                			temp_mult = temp_mult ^B[k][j] ;
	                			
	                		C[i][j] = C[i][j] ^ ( temp_mult ) ;
	                		
	                		
	                	}
	                	
	                	else if (A[i][k] == 1)
	                	{
	                		C[i][j] = C[i][j] ^ B[k][j];

	                	}
	                	
	                	
	                }
	            	array[j*4+i] = conv.DecToHex(C[i][j]  );
	            }
	        }

	        return array;
	    }
	
	
	  public  String[] multiplicar2(String[] array)
	    {
		    Integer[][] A = { { 14, 11,13 , 9 }, { 9, 14, 11, 13 }, { 13, 9, 14, 11}, { 11, 13, 9, 14 } };  
		    Integer[][] B = { { 99, 235, 159, 160 }, { 47, 147, 146, 192 }, { 175, 199, 171, 48 },  {162, 32, 203, 43 } };

//		    Integer[][] B = new Integer[array.length/4][array.length/4];
		    
		   
		
		    
		    
		    
		    System.out.println();
		    
		    
		    for (int i = 0; i < array.length/4; i++)
		    {
		    	for (int j = 0; j <array.length/4; j++)
		    	{
		    		String temp = array[array.length/4*j + i];
		    		
		    		int b = Integer.parseInt(temp, 16);
		    		
		    		B[i][j] = b;
		    		
		    		
		    	}	
		    	
		    }
		    
		    
	    	
	    	int aRows = A.length;
	        int aColumns = A[0].length;
	        int bRows = B.length;
	        int bColumns = B[0].length;

	        
	        if (aColumns != bRows) {
	            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
	        }

	        Integer[][] C = new Integer[aRows][bColumns];
	        for (int i = 0; i < aRows; i++) {
	            for (int j = 0; j < bColumns; j++) {
	            	
	                C[i][j] = 0;
	            
	            }
	        }

	        for (int i = 0; i < aRows; i++) { // aRow
	            for (int j = 0; j < bColumns; j++) { // bColumn
	            	
	            	
	                for (int k = 0; k < aColumns; k++) { // aColumn
	                	
	                	
	                	 if (A[i][k] == 13)
	                	{
	                		
	                		int b = B[k][j];
	                		
	                		int temp_mult = (2*b);
	                		
	                		if (b>=128)
	                			temp_mult = temp_mult^27;

	                		if (temp_mult > 255)
	                				temp_mult = Math.floorMod(temp_mult, 256);
	                		
	                		temp_mult = temp_mult ^temp_mult^temp_mult^temp_mult^temp_mult^temp_mult^B[k][j] ;
	                			
	                		C[i][j] = C[i][j] ^ ( temp_mult ) ;
	                		
	                		
	                	}
	                	
	                	else if (A[i][k] == 11)
	                	{
	                		
	                		int b = B[k][j];
	                		
	                		int temp_mult = (2*b);
	                		
	                		if (b>=128)
	                			temp_mult = temp_mult^27;

	                		if (temp_mult > 255)
	                				temp_mult = Math.floorMod(temp_mult, 256);
	                		
	                		temp_mult = temp_mult ^temp_mult^temp_mult^temp_mult^temp_mult^B[k][j] ;
	                			
	                		C[i][j] = C[i][j] ^ ( temp_mult ) ;
	                		
	                		
	                	}
	                	
	                	else if (A[i][k] == 9)
	                	{
	                		
	                		int b = B[k][j];
	                		
	                		int temp_mult = (2*b);
	                		
	                		if (b>=128)
	                			temp_mult = temp_mult^27;

	                		if (temp_mult > 255)
	                				temp_mult = Math.floorMod(temp_mult, 256);
	                		
	                		temp_mult = temp_mult^temp_mult^temp_mult^temp_mult^B[k][j] ;
	                			
	                		C[i][j] = C[i][j] ^ ( temp_mult ) ;
	                		
	                		
	                	}
	                	
	                	else if (A[i][k] == 14)
	                	{
	                		
	                		int b = B[k][j];
	                		
	                		int temp_mult = (2*b);
	                		
	                		if (b>=128)
	                			temp_mult = temp_mult^27;

	                		if (temp_mult > 255)
	                				temp_mult = Math.floorMod(temp_mult, 256);
	                		
	                		temp_mult = temp_mult ^temp_mult^temp_mult^temp_mult^temp_mult^temp_mult^temp_mult ;
	                			
	                		C[i][j] = C[i][j] ^ ( temp_mult ) ;
	                		
	                		
	                	}
	                	
	                	
	                	
	                	
	                }
	            	array[j*4+i] = conv.DecToHex(C[i][j]  );
	            }
	        }

	        return array;
	    }

	
}
