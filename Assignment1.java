import java.lang.Math;
class HexCalc
{
	public String addHexaDecimal(String firstHex,String SecondHex)
	{
		int addition=hexaToDecimal(firstHex)+hexaToDecimal(SecondHex);
		return decimalToHexa(addition);
	}
	

	public String subHexaDecimal(String firstHex,String SecondHex)
	{
		int sub=Math.abs(hexaToDecimal(firstHex)-hexaToDecimal(SecondHex));
		return decimalToHexa(sub);
	}
	
	public String mulHexaDecimal(String firstHex,String SecondHex)
	{
		int mul=hexaToDecimal(firstHex)*hexaToDecimal(SecondHex);
		return decimalToHexa(mul);
	}
	
	public String divHexaDecimal(String firstHex,String SecondHex)
	{
		int div=hexaToDecimal(firstHex)/hexaToDecimal(SecondHex);
		return decimalToHexa(div);
	}
	
	public int hexaToDecimal(String hexadecimal)
	{
		char hexChar[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		int powerend=hexadecimal.length()-1;
		int decimal=0;
		for(int i=0;i<hexadecimal.length();i++)
		{
			char eachcode=hexadecimal.charAt(i);
			for(int j=0;j<hexChar.length;j++)
			{
				if (eachcode==hexChar[j])
				{
					
					decimal=decimal+(int)Math.pow(16,powerend)*j;
					powerend--;
					break;
				}
				
			}
		}
		return decimal;
	}
	
	public String decimalToHexa(int decimal)
	{
		int remainder;
		String hexaDecimal="";
		char hexChar[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		while(decimal>0)
		{
			remainder=decimal%16;
			hexaDecimal=hexChar[remainder]+hexaDecimal;
			decimal=decimal/16;
		}
		return hexaDecimal;
	}

}




public class Assignment1 {
public static void main(String...k)
{
	HexCalc hex=new HexCalc();
	System.out.println(hex.decimalToHexa(123));
	System.out.println(hex.hexaToDecimal("7B"));
	System.out.println(hex.addHexaDecimal("7B","7B"));
	System.out.println(hex.subHexaDecimal("7B","12"));
	System.out.println(hex.mulHexaDecimal("7B","1B"));
	System.out.println(hex.divHexaDecimal("7B","2"));
	
}
}
