import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;

class binary_reversal
{
	public static void main (String args[])
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			if(n>1 || n<1000000000)
			{
	//		int x1 = 47;
				int x = n;
	//	int rev=0;					1	1	0	1
				String bin = Integer.toBinaryString(x);
				char[] y = bin.toCharArray();
				double result=0;
				int z;
				for(int k=y.length-1;k>=0;k--)
				{
					if(y[k]=='1')
					{	
						z = Character.getNumericValue(y[k]);	
						result = result+((z)*Math.pow(2,k));
					}
				}
				
				System.out.println((int)result);
			}
		}
		catch(IOException ioe)
		{
			//ioe.PrintStackTrace();
			System.err.println("Input Read Error");
		}
	}
}
