import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class test1
{
    //Global variables declaration
    
    public static int user_num; //User phone number
    public static ArrayList<Integer> oprt_index = new ArrayList<Integer>(); // Operator index to seperate each operator data i.e. for country code and its value
    public static ArrayList<Integer> country_code = new ArrayList<Integer>(); // Country code of all the operators together
    public static void main(String[]args)
	{
		Scanner input = new Scanner(System.in);
		String next_token = "";
        String[] tokens = new String[2];
        int count = 0, index_ret, temp3;
        double final_value;
        String final_operator = "";
        ArrayList<String> oprt_name = new ArrayList<String>();
        ArrayList<Double> country_value = new ArrayList<Double>(); // Country code value of all the operators together
        ArrayList<Integer> calc_ind = new ArrayList<Integer>(); // Index of the longest match operator
        ArrayList<Integer> final_ind = new ArrayList<Integer>(); // Final index of the least value found for the given user number
        ArrayList<Double> calc_final = new ArrayList<Double>(); // Stores final least value found at the end for the given user number

        //Input Secion to retreive operator data and user number

        while(input.hasNextLine())
		{
			next_token = input.nextLine();
            if(next_token.isEmpty())
            break;
            tokens = next_token.split(" ");
            if(next_token.contains("Operator") || next_token.contains("operator")) // Operator name check
            {
                oprt_name.add(tokens[1]);
                test1.oprt_index.add(count);
                country_code.add(0);
                country_value.add(0.0);
            }
			else if(tokens.length < 2) // Check for user number and start of analysis
            {
                test1.user_num = Integer.valueOf(tokens[0]);
                test1.oprt_index.add(count);
                break;
            }
            else // Storing country code and country code value
            {
                test1.country_code.add(Integer.parseInt(tokens[0]));
                country_value.add(Double.parseDouble(tokens[1]));
            }
            count++;
		}
        
        //Finding lowest cost for the entered user number
        
        for(int j=1;j<oprt_index.size();j++)
        {
            index_ret = test1.longest_match(j-1,j);
            calc_ind.add(index_ret); //returned index for longest match in each operator is stored
        }
        for(int k=0;k<calc_ind.size();k++)
        {
            int temp2 = calc_ind.get(k);
            if(temp2 != -1)
            {
                calc_final.add(country_value.get(temp2));
                final_ind.add(k); //for track of index of match found operators
            }
        }
        final_value = Collections.min(calc_final);
        
        for(int l=0;l<calc_final.size();l++)
        {
            if(final_value == calc_final.get(l))
            {
                final_operator = oprt_name.get(l);
                break;
            }
        }
        System.out.println("Cheapest Operator: "+final_operator+" at a value of "+final_value);
	}
    
    // Function for finding longest match in each operator
    
    public static int longest_match(int low, int high)
    {
        int temp = test1.user_num;
        int remainder;
        int negative = -1;
        low = oprt_index.get(low) + 1;
        high = oprt_index.get(high);
        // Modulo function for number match
        while(temp > 0)
        {
            for(int k = low;k < high;k++)
            {
                //negative = test1.int_code.indexOf(temp);
                if(test1.country_code.get(k) == temp)
                {
                    negative = k;
                }
                //indexOf returns the index of the number if it finds a match or else it returns -1
            }
            if(negative != -1)
            {
                return negative;
            }
            else
            {
                temp = temp / 10;
            }
        }
        return negative;
    }
}
