import java.lang.Math;
class HexCalc
{
	/*Accept two hexadecimal number and return addition of hexadecimal number in hexadecimal form*/
	public String addHexaDecimal(String firstHex,String secondHex)
	{
		int addition=hexaToDecimal(firstHex)+hexaToDecimal(secondHex);
		return decimalToHexa(addition);
	}
	
	/*Accept two hexadecimal number and return subtraction of hexadecimal number in hexadecimal form*/
	public String subHexaDecimal(String firstHex,String secondHex)
	{
		int sub=hexaToDecimal(firstHex)-hexaToDecimal(secondHex);
		return decimalToHexa(sub);
	}
	
	/*Accept two hexadecimal number and return multiplication of hexadecimal number in hexadecimal form*/
	public String mulHexaDecimal(String firstHex,String secondHex)
	{
		int mul=hexaToDecimal(firstHex)*hexaToDecimal(secondHex);
		return decimalToHexa(mul);
	}
	
	/*Accept two hexadecimal number and return division of hexadecimal number in hexadecimal form*/
	public String divHexaDecimal(String firstHex,String secondHex)
	{
		int div=hexaToDecimal(firstHex)/hexaToDecimal(secondHex);
		return decimalToHexa(div);
	}
	
	/*Accept hexadecimal number and return Decimal form*/
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
	
	/*Accept decimal number and return HexaDecimal form*/
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
	
	/*Compare two hexadecimal if equal return 0 greater return 1 lesser return -1*/
	public int hexCompare(String hex1,String hex2)
	{
		int hex1len=hex1.length();
		int hex2len=hex2.length();
		if (hex1len < hex2len)
		{
			return -1;
		}
		else if(hex1len > hex2len)
		{
			return 1;
		}
		else
		{
			for(int i=0;i<hex1len;i++)
			{
				if(hex1.charAt(i) < hex2.charAt(i))
				{
				return -1;
				}
				else if(hex1.charAt(i) > hex2.charAt(i))
				{
				return 1;
				}
			}
		return 0;		
		}
	}

}




public class Assignment1 {
	public static void main(String...k)
	{ 
		HexCalc hex=new HexCalc();
		System.out.println(hex.decimalToHexa(40));
		System.out.println(hex.hexaToDecimal("7B"));
		System.out.println(hex.addHexaDecimal("7B","7B"));
		System.out.println(hex.subHexaDecimal("7B","12"));
		System.out.println(hex.mulHexaDecimal("7B","1B"));
		System.out.println(hex.divHexaDecimal("7B","2"));
		int check=hex.hexCompare("1BC","1BDE");
		if(check==0)
			System.out.println("Hex1 Equal Hex2");
		else if(check==-1)
			System.out.println("Hex1 lower then Hex2");
		else
			System.out.println("Hex1 greater thaen Hex2");
	}
}

