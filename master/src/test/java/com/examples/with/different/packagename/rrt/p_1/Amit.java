package com.examples.with.different.packagename.rrt.p_1;

public class Amit {
    public int hoo(){return 5;}
    public int boo(){return 5;}
    public int foo(){return 0;}
    public int goo(){return 0;}
    public int doo(int n){
        int ans;
        if( isEven(n))
            ans  = 3 * n;
        else
            ans  = 2 * n;
        return ans;
    }

    public int RTerror(){
        return 1;
    }
    public boolean isEven(int n){
        return n%2 == 0;
    }
}
