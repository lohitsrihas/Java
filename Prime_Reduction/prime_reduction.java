import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class problem2
{
	public static int add_res;
	public static int k;
	public static void main (String args[])
	{
		
		problem2.add_res = 0;
		problem2.k = 0;
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
				int a;
				a = primeLoop(n);
				System.out.println(a);
			}
			//System.out.println("\n");
		}
		catch(IOException ioe)
		{
			//ioe.PrintStackTrace();
			System.err.println("Input Read Error");
		}
	}
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
	public static int primeFactor(int b, int add1)
	{
		int mod, count = 0, fact1=0;
		List<Integer> num2 = new ArrayList<>();
		for(int i = 2;i<b;i++)
		{
			mod = b%i;
			if(mod == 0)
			{
				//System.out.print(i+" ");
				add1 = add1 + i;
				num2.add(i);
				fact1 = b/i;
				break;
				//return fact1;	
			}	
		}
	//	return count;
		return fact1;
	}
	public static int primeLoop(int n)
	{
		int p=0;
		problem2.add_res = 0;
		if(primeCheck(n) == 0)
				System.out.println(n+" "+"1");
			else
				{
					for(int j=2;j<n;j++)
					{
					//ret = primeFactor(n);
						while(problem2.k == 0)
						{
							n = primeFactor(n, problem2.add_res);
							if(primeCheck(n)==0)
							{	
								//System.out.println(n);
								problem2.add_res = problem2.add_res + n;
								problem2.k = problem2.k + 1;
								problem2.add_res = primeLoop(problem2.add_res);
							//num.add(primeFactor(n));
							}
						}
				
					}
//				System.out.println("Hello");
				
				}
		return problem2.add_res;
	}
}
