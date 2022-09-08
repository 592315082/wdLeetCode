package LeetCode;

public class Test07 {

    // prsf
    //private static final
    public static void main(String[] args) {
        int result = reverse(-1230);
        System.out.println(result);
        String aa = "111";
        String[] aas = new String[]{"11","22","33"};
        // iter itar fori forr
        // ifn ifnn
    }


    public static int reverse(int x) {
        String input = String.valueOf(x);
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        if (sb.substring(sb.length()-1, sb.length()).equals("-")) {
            sb = sb.insert(0, "-");
            input = sb.substring(0, sb.length()-1);
        } else {
            input = new String(sb);
        }
        int result;
        try{
            result = Integer.parseInt(input);
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }
}
