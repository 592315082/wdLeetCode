package LeetCode;

import java.util.Stack;

public class Combination {
    public static Stack<Integer> stack = new Stack<Integer>();
    public static void main(String[] args) {
        int shu[] = {-1,0,1,2,-1,-4};

        // 4选4 可重复
        f1(shu, 3, 0);
        // 4选4 没有重复
        //f2(shu, 4, 0);
        // 4选3
        //f3(shu, 3, 0, 0);
    }

    /**
     *
     * @param shu 待选择的数组
     * @param targ 要选择多少个次
     * @param cur 当前选择的是第几次
     */
    private static void f1(int[] shu, int targ, int cur) {
        //System.out.println("cur is : " + cur);
        if(cur == targ) {
            System.out.println(stack);
            return;
        }

        for(int i = 0; i < shu.length; i++) {
            stack.add(shu[i]);
            f1(shu, targ, cur+1);
            stack.pop();
        }
    }

    /**
     *
     * @param shu   待选择的数组
     * @param targ  要选择多少个次
     * @param cur   当前选择的是第几次
     */
    private static void f2(int[] shu, int targ, int cur) {
        //System.out.println("cur is : " + cur);
        if(targ == cur) {
            System.out.println(stack);
            return;
        }

        for(int i = 0; i < shu.length; i++) {
            if(!stack.contains(shu[i])) {
                stack.add(shu[i]);
                f2(shu, targ, cur+1);
                stack.pop();
            }
        }
    }

    /**
     *
     * @param shu   元素
     * @param targ  要选多少个元素
     * @param has   当前有多少个元素
     * @param cur   当前选到的下标
     */
    private static void f3(int[] shu, int targ, int has, int cur) {
        if(targ == has) {
            System.out.println(stack);
            return;
        }

        for(int i = cur; i < shu.length; i++ ) {
            if(!stack.contains(shu[i])) {
                stack.add(shu[i]);
                f3(shu, targ, has+1, i);
                stack.pop();
            }
        }
    }
}
