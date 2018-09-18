package com.citi.hz41382.java.caculator.md01.test;

import com.citi.hz41382.java.caculator.md01.caculate.Calculator;
import com.citi.hz41382.java.caculator.md01.tree.Tree;
import com.citi.hz41382.java.caculator.md01.util.StringUtil;

public class TestClass {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();
        testCalc(getTestObj());
        long endTime = System.currentTimeMillis();
//        System.out.println(endTime - startTime);
    }

    /**
     * 分词测试
     *
     */
    public static void testFenci(String obj) {
        String[] result = StringUtil.getFenciSymbol(obj);

        printArray(result);
    }

    /**
     * 构造树测试
     *
     */
    public static void testCreateTree(String obj) {
        String[] ysfStr = StringUtil.getFenciSymbol(obj);
        Tree sampleTree = new Tree();

        if (sampleTree.insert(ysfStr)) {
            String[] treeStr = sampleTree.getTreeInfoForView();
            StringBuilder temStr = new StringBuilder();
            for (String ss : treeStr) {
                temStr.append(ss);
            }

            System.out.println(temStr.toString());
            System.out.println(obj.equals(temStr.toString()));
        }
    }

    /**
     * 计算测试
     *
     */
    public static void testCalc(String obj) {
        String calcResult = new Calculator().calculate(obj);
        System.out.println(calcResult);
    }

    /**
     * 生成运算式
     *
     */
    public static String getTestObj() {
        //String obj = "2*(4*(-(8+9))+4)-80/3*(9%5)-tan30*ctg270-sin(4^3)*lg29";
    	String obj = "2+3-(2+12-3)*2";
    	StringBuilder sb = new StringBuilder(obj);
        for (int i = 0; i < 0; i++) {
            sb.append("+").append(obj);
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void printArray(String[] array) {
        for (String ss : array) {
            System.out.print(ss.concat(","));
        }
    }
}
