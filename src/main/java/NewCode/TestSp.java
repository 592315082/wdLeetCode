package NewCode;

import java.util.Scanner;

public class TestSp
{
    private static char[] alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j',
            'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            String result = "";
            char[] word = str.toCharArray();
            for(int i = 0;i < word.length; i++){
                char letter = word[i];
                boolean upperCaseFlag = false;
                if(Character.isUpperCase(letter)){
                    upperCaseFlag = true;
                    //转小写
                    letter += 32;
                }
                for(int j = 0; j < alphabet.length; j++){
                    if(alphabet[j] == letter){
                        int k = j + 4;
                        if(k > 25)
                            k = k -26;
                        if(upperCaseFlag){
                            result += String.valueOf(alphabet[k]).toUpperCase();
                        }else{
                            result += String.valueOf(alphabet[k]);
                        }
                        break;
                    }
                }
            }
            System.out.println(result);
        }
    }

}