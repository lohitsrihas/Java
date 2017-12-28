import java.io.IOException;
import java.util.*;

public class problem3
{
	public static void main (String args[])
	{
		Scanner sc = new Scanner(System.in); 
		int[] a = new int[4];
		int j=0;
		while(j<2)
		{
			for(int i = 0; i < 4; i++)
			{
			    	a[j] = a[j] + sc.nextInt();
			}
		j++;
		}
// ###### Addition & Verification of Dice sum
		if(a[0]<a[1])
			System.out.println("Emma");
		else if(a[0]==a[1])
			System.out.println("Tie");
		else
			System.out.println("Gunnar");

	}
}
