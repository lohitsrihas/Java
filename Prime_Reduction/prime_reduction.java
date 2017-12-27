import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class problem2
{
//	public static int add_res;
//	public static int k;
	public static void main (String args[])
	{
		try
		{
			List<Integer> arr2 = new ArrayList<Integer>();
			int n1;
			do
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				n1 = Integer.parseInt(br.readLine());
			//	int[] arr1 = new int[20000];
			//	List<Integer> arr2 = new ArrayList<Integer>();
				arr2.add(n1);
			}while(n1!=4);
			for(int l=0;l<arr2.size()-1;l++)
			{
				//int ret;
				int[] arr = arr2.stream().mapToInt(i->i).toArray();
				int n = arr[l];
				int k2;
				for(k2=1;k2>0;k2++)
				{
					if(primeCheck(n) == 0)
					{
						System.out.println(n+" "+k2);
						break;
					}
					else
					{
						n = primeFactor(n);
					}
	//				System.out.println("Hello");
				}
			}
	}
			//System.out.println("\n");
		
		catch(IOException ioe)
		{
			//ioe.PrintStackTrace();
			System.err.println("Input Read Error");
		}
	}
// ##### Method to Check if the number is Prime or Not

	public static int primeCheck(int a)
	{
		int mod, count = 0;
		for(int i = 2;i<a;i++)
		{
			mod = a%i;
			if(mod == 0)
			{
				count = count + 1;	
			}	
		}
		return count;
	}
// ##### Method to get prime factors of the arg number

	public static int primeFactor(int b)
	{
		int mod, fact1=0, add1=0;
		//List<Integer> num2 = new ArrayList<>();
		for(int i = 2;i<b;i++)
		{
			mod = b%i;
			if(mod == 0)
			{
				//System.out.print(i+" ");
				add1 = add1 + i;
				//num2.add(i);
				b = b/i;
				i = 2;
				if(primeCheck(b)==0)
					add1 = add1 + b;
				//return fact1;	
			}	
		}
		return add1;
	}
}
