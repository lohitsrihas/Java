import java.io.IOException;
import java.util.*;

public class problem4
{
	public static void main (String args[])
	{
		Scanner sc = new Scanner(System.in);
		int[] a = new int[4];
		int j=0;
		for(int i=0;i<2;i++)
		{
			a[i] = a[i] + sc.nextInt();
		}
		int cap = a[0];
		int lines = a[1];
		if(lines >1 && lines <101 && cap > 0 && cap <= 1000000000)
		{
		int[] b = new int[3];
		List<Integer> le1 = new ArrayList<Integer>();
		List<Integer> en1 = new ArrayList<Integer>();
		List<Integer> st1 = new ArrayList<Integer>();
		while(j<lines)
		{
			for(int i = 0; i < 3; i++)
			{
			    	b[i] = sc.nextInt();
			}
			le1.add(b[0]);
			en1.add(b[1]);
			st1.add(b[2]);
			j++;
		}
		int i1=1;
		int bal=9;
		int count = 0;
		int[] le = le1.stream().mapToInt(i->i).toArray();
		int[] en = en1.stream().mapToInt(i->i).toArray();
		int[] st = st1.stream().mapToInt(i->i).toArray();

		bal = cap-en[0]+le[0];
		if(bal <0 || bal>cap || (0 < st[0] && st[0] <= bal))
			{ 
				System.out.println("impossible");
			}
			else
			{
					while(i1<(lines))
					{
						bal = bal - (en[i1] - le[i1]); 
				//		if(bal < 0 || (bal < cap && st[i1] > 0) || (i1 == lines - 1 && (st[i1] > 0 || bal > 0)))
				//		{ 
				//			System.out.println("impossible");
				//			break;
				//		}
				//		else System.out.println("possible");
						if(i1 == lines-1 && bal == cap && st[i1] == 0)
						{
							System.out.println("possible");
							break;
						}
						else if(i1 == lines-1 && (bal != cap || st[i1] != 0))
						{
						//	System.out.println("else if 1");
							System.out.println("impossible");
							break;
						}


						else if(i1 != lines-1 && (bal < 0 || bal > cap || (0 < st[i1] && st[i1] <= bal)))
						{
							//System.out.println("else if 2");
							System.out.println("impossible");
							break ;
						}
						//else if(i1 != lines-1 && st[i1]<=bal)
					//	{
					//		System.out.println("impossible");
					//		break ;
					//	}	
						else
						{count++;}
					i1++;	
					}
				
			}
			//System.out.println(count);
		//	else
				
		}
		else
		System.out.println("impossible");
	}
}
