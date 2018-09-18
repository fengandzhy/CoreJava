package com.citi.hz41382.java.caculator.md01.test;

import com.citi.hz41382.java.caculator.md01.caculate.Calculator;

public class MainClass {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {

//        if (args == null || args.length == 0) {
//            System.out.println("Error Input!");
//            return;
//        }
//        System.out.println(new Calculator().calculate("(2+12-3)*2+sin2"));
//        System.out.println(new Calculator().calculate("sin2+(2+12-3)*2"));
    	System.out.println(new Calculator().calculate("2+(-2)+(2+12-3)*2"));
//        System.out.println(new Calculator().calculate("sin2+11*2"));
//        System.out.println(new Calculator().calculate("sin10"));
//        System.out.println(new Calculator().calculate("(2+12-3)*2"));
//        System.out.println(new Calculator().calculate("sinsinsin24"));
//        System.out.println(new Calculator().calculate("(sinsinsin2)"));
//        
//        System.out.println(new Calculator().calculate("sin2*3"));
//        System.out.println(new Calculator().calculate("sin6"));
//        System.out.println(new Calculator().calculate("sin(sin2)"));
//        System.out.println(new Calculator().calculate("sin(sin(sin2))"));
    }
}
