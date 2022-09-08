package NewCode;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test18 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while(sc.hasNext())
        {
            System.out.println(i++);
            boolean res = true;
            String password = sc.next();
            if(password.length()<8)
            {
                res = false;
            }
            if(isContentQualified(password) || hasDuplicatedString(password))
            {
                res = false;
            }
            if(res)
            {
                System.out.println("OK");
            }
            else
            {
                System.out.println("NG");
            }
        }
    }
    // 判断包括大小写字母.数字.其它符号,以上四种至少三种
    private static boolean isContentQualified(String s)
    {
        int count = 0;
        String[] str = {"[a-z]","[A-Z]","[0-9]","[^a-zA-Z0-9]"};
        for(int i = 0; i < str.length; i++ )
        {
            Pattern pattern = Pattern.compile(str[i]);
            Matcher matcher = pattern.matcher(s);
            if(matcher.find())
                count++;
        }
        return count<3;
    }
    // 不能有相同长度超2的子串重复
    private static boolean hasDuplicatedString(String s)
    {
        for(int i = 0;i < s.length()-3;i++)
        {
            if(s.substring(i+3).contains(s.substring(i,i+3)))
                return true;
        }
        return false;
    }
}
