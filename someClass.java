package Main;

public class someClass {
    Integer[][] A = { { 2, 3,1 , 1 }, { 1, 2, 3, 1 }, { 1, 1, 2, 3}, { 3, 1, 1, 2 } };  
    Integer[][] B = { { 99, 235, 159, 160 }, { 47, 147, 146, 192 }, { 175, 199, 171, 48 },  {162, 32, 203, 43 } };

    
    
    public static Integer[][] multiplicar(Integer[][] A, Integer[][] B)
    {
    	
    	int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;
        
//        63
//        63^ 2f*2= 7d
//        7d ^ 1f1 = 18c
//        18c ^ a2 = 12e
//        
        
     //   1 0010 1110
        
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
            	
            	System.out.println("________________________________\n");
            	
                for (int k = 0; k < aColumns; k++) { // aColumn
                	System.out.print(A[i][k]+ " " + B[k][j] +" | ");
                	
                	
                	if (A[i][k] == 2)
                	{
                		int b = B[k][j];
                		
                		
                		
                		int temp_mult = (2*b);
                		
                		
                		if (b>=128)
                			temp_mult = temp_mult^27;
                		
            			if (temp_mult > 255)
            				temp_mult = Math.floorMod(temp_mult, 256);
            			
            			
            			
                		C[i][j] = C[i][j] ^ temp_mult;
            			System.out.println("we have" + A[i][k] +" " +temp_mult); 
	
                		
                	}
                    
                	
                	
                	
                	else if (A[i][k] == 3)
                	{
                		
                		
                		int b = B[k][j];
                		
                		
                		
                		int temp_mult = (2*b);
                		
                		if (b>=128)
                			temp_mult = temp_mult^27;

                		System.out.println("after ^27 " + b);
                		
                			if (temp_mult > 255)
                				temp_mult = Math.floorMod(temp_mult, 256);
                		
                			temp_mult = temp_mult ^B[k][j] ;
                			
                		C[i][j] = C[i][j] ^ ( temp_mult ) ;
                		
                		System.out.println("we have"+ A[i][k] +" " + temp_mult); 
                		
                	}
                	
                	else if (A[i][k] == 1)
                	{
                		C[i][j] = C[i][j] ^ B[k][j];
                		System.out.println("we have"+ A[i][k] +" " + B[k][j]); 

                	}
                	
                	System.out.println("this is" + C[i][j]); 
         //       	if (B[k][j]>128)
                	
                }
            	System.out.print(C[i][j] + "\n");

            }
        }

        return C;
    }

    public static void main(String[] args) {

        someClass matrix = new someClass();
        Integer[][] result = multiplicar(matrix.A, matrix.B);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++)
            {	
            	System.out.print(result[i][j] + " ");
            }	
            System.out.println();
        }
        
        System.out.println();
        
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++)
            {	
            	System.out.print(DecToHex(result[i][j]    ) + " " );
            }	
            System.out.println();
        }
        
    	
    //	System.out.println(DecToHex(200));
    }
    
    
    
    public static String DecToHex(int dec)
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
    
    
    
    
}