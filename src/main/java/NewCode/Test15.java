package NewCode;

import java.util.Scanner;

public class Test15 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] sc = str.split(";");
        int[] result = new int[]{0,0};
        for(int i = 0; i < sc.length; i++){
            movePoint(sc[i], result);
        }
        System.out.println(result[0]+","+result[1]);
    }

    private static void movePoint(String sc, int[] result){
        String direction = "";
        int distance = 0;
        try{
            direction = sc.substring(0,1);
            distance = Integer.parseInt(sc.substring(1));
        }catch(Exception e){
            return;
        }
        if(direction.equals("W")){
            result[1] = result[1] + distance;
        }else if(direction.equals("S")){
            result[1] = result[1] - distance;
        }else if(direction.equals("A")){
            result[0] = result[0] - distance;
        }else if(direction.equals("D")){
            result[0] = result[0] + distance;
        }
    }
}
