import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class test1
{
    public static int user_num;
    public static ArrayList<Integer> oprt_index = new ArrayList<Integer>();
    public static ArrayList<String> country_code = new ArrayList<String>();
    public static ArrayList<Integer> int_code = new ArrayList<Integer>();
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
        ArrayList<String> country_value = new ArrayList<String>();
        ArrayList<Integer> int_value = new ArrayList<Integer>();
        ArrayList<Integer> calc_ind = new ArrayList<Integer>();
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
                //System.out.println("Loop 1");
                //tokens = null;
            }
			else if(tokens.length < 2 && tokens[0] != "Operator")
            {
                //System.out.println(tokens[0]);
                test1.user_num = Integer.valueOf(tokens[0]);
                //System.out.println("Loop 2");
                break;
            }
            else if(tokens[0] != "Operator" && tokens.length > 1)
            {
                count++;
                //int temp_code = Integer.valueOf(tokens[0]); 
                //test1.country_code.add(temp_code);
                test1.country_code.add(tokens[0]);
                //int temp_value = Integer.valueOf(tokens[1]);
                //country_value.add(temp_value);
                country_value.add(tokens[1]);
                //System.out.println("Loop 3");
            }
		}
        // Conversion of String ArrayList to Integer ArrayList
       // for(String convert_val : oprt_name)
        //{
          //  System.out.println(convert_val);
        //}
        
        for(String convert_val : country_code)
        {
            int_code.add(Integer.parseInt(convert_val));
        }
        for(String convert_val : country_value)
        {
            int_value.add(Integer.parseInt(convert_val));
        }
        
        //Filtering out the longest match and finding lowest cost
        
        for(int j=1;j<oprt_index.size();j++)
        {
            index_ret = test1.longest_match(j-1,j);
            calc_ind.add(index_ret);
        }
        for(int k=0;k<calc_ind.size();k++)
        {
            int temp2 = calc_ind.get(k);
            if(temp2 != -1)
            {
                calc_final.add(int_value.get(temp2));
            }
            else
            {
                calc_final.add(temp2);
            }
        }
        final_value = Collections.min(calc_final);
        temp3 = calc_final.indexOf(final_value);
        final_operator = oprt_name.get(temp3);
        System.out.println("Cheapest Operator: "+final_operator+" at a value of "+final_value);
	}
    
    // Function for finding longest match in each operator
    
    public static int longest_match(int low, int high)
    {
        int temp = test1.user_num;
        int remainder;
        int negative = -1;
        //for(int i=1;i<)
        while(temp > 0)
        {
            for(int k = oprt_index.get(low);k < oprt_index.get(high);k++)
            {
                negative = test1.int_code.indexOf(temp);
            }
            if(negative != -1)
            {
                return negative;
            }
            else
            {
                remainder = temp % 10;
                temp = temp / 10;
            }
        }
        return negative;
    }
}
