import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class test1
{
    public static int user_num;
    public static ArrayList<Integer> oprt_index = new ArrayList<Integer>();
    public static ArrayList<Integer> country_code = new ArrayList<Integer>();
    public static void main(String[]args)
	{
		Scanner input = new Scanner(System.in);
		String next_token = "";
        String[] tokens = new String[2];
        int count = 0;
        int index_ret;
        int final_value;
        int temp3;
        String final_operator = "";
        ArrayList<String> oprt_name = new ArrayList<String>();
        ArrayList<Integer> country_value = new ArrayList<Integer>();
        ArrayList<Integer> calc_ind = new ArrayList<Integer>();
        ArrayList<Integer> final_ind = new ArrayList<Integer>();
        ArrayList<Integer> calc_final = new ArrayList<Integer>();

        //Input Secion

        while(input.hasNextLine())
		{
            
			next_token = input.nextLine();
            //tokens[0] = input.next();
            if(next_token.isEmpty())
            {
                break;
            }
            tokens = next_token.split(" ");
            //tokens[1] = input.next();
			//System.out.println(tokens[1]);
            
            
            if(next_token.contains("Operator") || next_token.contains("operator"))
            {
                oprt_name.add(tokens[1]);
                test1.oprt_index.add(count);
                country_code.add(0);
                country_value.add(0);
            }
			else if(tokens.length < 2)
            {
                test1.user_num = Integer.valueOf(tokens[0]);
                test1.oprt_index.add(count);
                break;
            }
            else
            {
                test1.country_code.add(Integer.parseInt(tokens[0]));
                country_value.add(Integer.parseInt(tokens[1]));
            }
            count++;
		}
        
        for(int convert_val : oprt_index)
        {
            System.out.println("**"+convert_val);
        }
        for(int convert_val : country_value)
        {
            System.out.println("$$"+convert_val);
        }
        
        //Filtering out the longest match and finding lowest cost
        
        for(int j=1;j<oprt_index.size();j++)
        {
            index_ret = test1.longest_match(j-1,j);
            //System.out.println("##"+index_ret);
            calc_ind.add(index_ret); //returned index for longest match in each operatoris stored in it
        }
        for(int k=0;k<calc_ind.size();k++)
        {
            System.out.println("Size of calc_index: "+calc_ind.size());
            int temp2 = calc_ind.get(k);
            if(temp2 != -1)
            {
                calc_final.add(country_value.get(temp2));
                final_ind.add(k); //for track of index of match found operators
            }
        }
        final_value = Collections.min(calc_final);
        for(int convert_val : calc_final)
        {
            System.out.println("**"+convert_val);
        }
        //temp3 = calc_final.indexOf(final_value);
        //System.out.println("operator index: "+temp3);
        for(int l=0;l<calc_final.size();l++)
        {
            if(final_value == calc_final.get(l))
            {
                final_operator = oprt_name.get(l);
                break;
            }
        }
        //final_operator = oprt_name.get(temp3);
        System.out.println("Cheapest Operator: "+final_operator+" at a value of "+final_value);
	}
    
    // Function for finding longest match in each operator
    
    public static int longest_match(int low, int high)
    {
        //System.out.println("Function loop");
        int temp = test1.user_num;
        int remainder;
        int negative = -1;
        low = oprt_index.get(low) + 1;
        high = oprt_index.get(high);
        //for(int i=1;i<)
        // Modulo function for number match
        while(temp > 0)
        {
            for(int k = low;k < high;k++)
            {
                //negative = test1.int_code.indexOf(temp);
                //System.out.println("Loopcheck: "+k+" high :"+high);
                if(test1.country_code.get(k) == temp)
                {
                    negative = k;
                }
                //System.out.println("Index of match :"+negative);
                //indexOf returns the index of the number if it finds a match or else it returns -1
            }
            if(negative != -1)
            {
                //System.out.println("Returned: "+negative);
                return negative;
            }
            else
            {
                //remainder = temp % 10;
                temp = temp / 10;
            }
        }
        //System.out.println("Outside Function Value :"+negative);
        //System.out.println("Or Returned: "+negative);
        return negative;
    }
}
