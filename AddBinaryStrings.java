package in.dsadec.com.GFG_DSAQuestions;

public class AddBinaryStrings {
    public static void main(String[] args)
    {
        System.out.println(addBinary("1101", "111"));
    }
    static String addBinary(String s1, String s2) {
        // code here
        int i=s1.length()-1;
        int j=s2.length()-1;
        int carry=0;
        int total=0;
        StringBuilder sb= new StringBuilder();
        while(j>=0||i>=0)
        {
            int a=0;
            int b=0;
            if(i>=0)
            {
                a=s1.charAt(i)-'0';
            }
            else
            {
                a=0;
            }

            if(j>=0)
            {
                b=s2.charAt(j)-'0';
            }
            else
            {
                b=0;
            }
            total=a+b+carry;
            if(total==0)
            {
                carry=0;
                sb.append("0");
            }
            else if(total==1)
            {
                carry=0;
                sb.append("1");
            }
            else if(total==2)
            {
                carry=1;
                sb.append("0");
            }
            else
            {
                carry=1;
                sb.append("1");

            }
            i--;
            j--;
        }
        if(carry==1)
        {
            sb.append("1");
        }
        while(sb.charAt(sb.length()-1)=='0')
        {
            sb.setLength(sb.length()-1);
        }
        return sb.reverse().toString();
    }
}

