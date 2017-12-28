import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
//import java.util.List;
//import java.util.Arrays;
//import java.util.ArrayList;

public class dice_game
{
//	public static int add_res;
//	public static int k;
	public static void main (String args[])
	{
		try
		{
			//List<Integer> arr2 = new ArrayList<Integer>();
			String n;
			int i=0;
			int[][] a = new int[4][4];
			while(i<2)
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				n = br.readLine();
				String strs[] = new String[4];
				
				for(int d=0;d<4;d++)
				{
					strs[d] = new String();
				}
				strs = n.trim().split("\\s+");
			//	for(int j=0; j<strs.length;j++)
			//	{
					for(int k=0;k<4;k++)
					{
						if(Integer.parseInt(strs[k]) >=1 && Integer.parseInt(strs[k]) <= 100)
						{
							a[i][k] = Integer.parseInt(strs[k]);
						}
						else
						{
							System.out.println("Invalid Input");
							break;
						}
					}

//				}
			i++;
			//	int[] arr1 = new int[20000];
			//	List<Integer> arr2 = new ArrayList<Integer>();
			//	arr2.add(n1);
			}
			
// ###### Addition & Verification of Dice sum
			int c=0, temp=0;
			int [] sum = new int[2];	
			while(c<2)
			{
				for(int k=0; k<4;k++)
				{
					temp = temp + a[c][k];
				}
				sum[c]=temp;
			c++;
			}
			if(sum[0]<sum[1])
				{System.out.println("Emma");}
			else if(sum[0]==sum[1])
				{System.out.println("Tie");}
			else
				{System.out.println("Gunnar");}

		//	int b=0;
		//	while(b<2)
		//	{
		//		for(int l=0;l<4;l++)
		//		{
		//			System.out.print(a[b][l]+" ");
		//		}
		//		System.out.print("\n");
		//	b++;
		//	}

		}
		catch(IOException ioe)
		{
			//ioe.PrintStackTrace();
			System.err.println("Input Read Error");
		}
	//	catch(NullPointerException npe)
	//	{
	//		//ioe.PrintStackTrace();
	//		System.err.println("Input Read Error");
	//	}
	}
}
