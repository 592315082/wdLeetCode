package LeetCode;

public class Test1 {

    public static void main(String[] args){
        A a = new A();
        String result = a.addBinary("1010", "1011");
        System.out.println(result);
    }
}


class A {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0; //是否进一位
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += (i >= 0 ? a.charAt(i) - '0' : 0); // 获取字符串a对应的某一位的值 当i<0是 sum+=0（向前补0） 否则取原值 ‘1’的char类型和‘0’的char类型刚好相差为1
            sum +=( j >= 0 ? b.charAt(j) - '0' : 0);// 获取字符串a对应的某一位的值 当i<0是 sum+=0（向前补0） 否则取原值 ‘1’的char类型和‘0’的char类型刚好相差为1
            ans.append(sum % 2);  // 如果二者都为1  那么sum%2应该刚好为0 否则为1
            ca = sum / 2;   // 如果二者都为1  那么ca 应该刚好为1 否则为0
        }
        ans.append(ca == 1 ? ca : "");// 判断最后一次计算是否有进位  有则在最前面加上1 否则原样输出
        return ans.reverse().toString();
    }
}