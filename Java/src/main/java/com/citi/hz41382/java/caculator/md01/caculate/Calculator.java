/**
 * 运算类
 */
package com.citi.hz41382.java.caculator.md01.caculate;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

import com.citi.hz41382.java.caculator.md01.tree.Tree;
import com.citi.hz41382.java.caculator.md01.util.Constant;
import com.citi.hz41382.java.caculator.md01.util.StringUtil;

/**
 * @author
 *
 */
public class Calculator {

    /**
     * 计算参数所给出的运算式
     * 计算出错时，返回null
     *
     * @param yunsuanshi String
     * @return 运算结果,结果为空时，说明运算式错误
     */
    public String calculate(String yunsuanshi) {

        // 计算结果
        String result = "";

        try {

            // 解析运算式
            String[] ysfArray = StringUtil.getFenciSymbol(yunsuanshi);

            // 取得运算式树
            Tree ysfTree = getYsfTree(ysfArray);

            // 取得堆栈
            Stack<String> ysfStack = getYsfStack(ysfTree);
            result = calculate(ysfStack);

            // 输入错误时的处理
            if (result == null || "".equals(result) || "null".equals(result)) {
                throw new Exception();
            }
        } catch (Exception e) {
            result = "Error Input!";
        }
        return result;
    }

    /**
     * 计算参数所给出的运算式
     * 计算出错时，返回null
     *
     * @param ysfTree Tree
     * @return 运算结果,结果为空时，说明运算式错误
     */
    public String calculate(Tree ysfTree) {

        // 计算结果
        String result = "";

        try {

            // 取得堆栈
            Stack<String> ysfStack = getYsfStack(ysfTree);
            result = calculate(ysfStack);
        } catch (Exception e) {
            result = "Incorrect!";
        }
        return result;
    }

    /**
     * 取得运算式的树形式
     *
     * @param ysfArray 运算式数组
     * @return 运算式的树形式
     */
    private Tree getYsfTree(String[] ysfArray) {

        Tree tree = new Tree();
        tree.insert(ysfArray);
        return tree;
    }

    /**
     * 取得运算式树的堆栈构造
     *
     * @param ysfTree 运算式树
     * @return 运算式树的堆栈构造
     */
    private Stack<String> getYsfStack(Tree ysfTree) {

        Stack<String> stack = new Stack<String>();

        // 采用根优先原则构造堆栈
        for (String nodeInfo : ysfTree.getTreeInfoForCalc()) {
            stack.push(nodeInfo);
        }
        return stack;
    }

    /**
     * 计算参数所给出的运算式
     * 计算出错时，返回null
     *
     * @param ysfStack 主堆栈
     * @return 运算结果
     */
    private String calculate(Stack<String> ysfStack) {

        // 临时堆栈的建立
        Stack<String> tmpStack = new Stack<String>();

        // 主堆栈中的元素等于1个，并且临时堆栈为空时停止
        while (ysfStack.size() > 1 || !tmpStack.isEmpty()) {

            // 计算结果
            String calcResult = "";

            // 弹出第一个元素
            String firstObj = ysfStack.pop();

            // 弹出第二个元素
            String secondObj = ysfStack.pop();

            // 第二个元素是运算符时
            if (Constant.YUN_SUAN_FU_SET.get(secondObj) != null) {

                // 第二个元素是单目运算符时，则计算结果
                if (Constant.YUN_SUAN_FU_SET.get(secondObj).getPriorityFlg().equals(
                        Constant.YSF_PRIORITY_SINGLE)) {
                    calcResult = calculate(secondObj, firstObj);

                    // 将结果压回主堆栈
                    ysfStack.push(calcResult);
                    continue;
                }

                // 第二个元素是双目运算符时
                else if (Constant.YUN_SUAN_FU_SET.get(secondObj).getPriorityFlg().equals(
                        Constant.YSF_PRIORITY_DOUBLE)) {

                    // 从临时堆栈中取出一个元素，作为运算的第一个操作符并计算结果
                    String tmpObj = tmpStack.pop();
                    calcResult = calculate(secondObj, firstObj, tmpObj);

                    // 将结果压回主堆栈
                    ysfStack.push(calcResult);
                    continue;
                }
            }

            // 弹出第三个元素
            String thirdObj = ysfStack.pop();

            // 第三个元素是运算符时
            if (Constant.YUN_SUAN_FU_SET.get(thirdObj) != null) {

                // 如果第三个元素是双目运算符时
                if (Constant.YUN_SUAN_FU_SET.get(thirdObj).getPriorityFlg().equals(
                        Constant.YSF_PRIORITY_DOUBLE)) {
                    calcResult = calculate(thirdObj, secondObj, firstObj);

                    // 将结果压回主堆栈
                    ysfStack.push(calcResult);
                    continue;
                }
            }

            // 第三个元素是数字时，第一个元素(肯定是数字)压入临时堆栈
            tmpStack.push(firstObj);

            // 将第三个和第二个元素压回主堆栈（保持原序）
            ysfStack.push(thirdObj);
            ysfStack.push(secondObj);
        }

        return ysfStack.pop();
    }

    /**
     * 计算参数的运算结果
     *
     * @param ysf String 运算符
     * @param param1 String 操作数1
     * @param param2 String 操作数2
     * @return 运算结果
     */
    public String calculate(String ysf, String param1, String param2) {

        String calcResult = null;

        try {
            Class<CalculatorUtil> calculatorClass = CalculatorUtil.class;
            String methodName = Constant.CALC_NAME_FROM_YSF.get(ysf);
            String ysfPriority = Constant.PRIORITY_FROM_YSF.get(ysf);

            Method method = null;

            // 单目运算符的情况
            if (Constant.YSF_PRIORITY_SINGLE.equals(ysfPriority)) {
                method = calculatorClass.getMethod(methodName, String.class);
                calcResult = (String)method.invoke(null, param1);
            }

            // 双目运算符的情况
            else {
                method = calculatorClass.getMethod(methodName, String.class, String.class);
                calcResult = (String)method.invoke(null, param1, param2);
            }

            // 精度设置
            calcResult = dealScale(calcResult);

        } catch (Exception e) {
            return null;
        }

        return calcResult;
    }

    /**
     * 计算参数的运算结果
     *
     * @param ysf String 运算符
     * @param param1 String 操作数1
     * @return 运算结果
     */
    private String calculate(String ysf, String param1) {
        return calculate(ysf, param1, null);
    }

    /**
     * 设置精度
     * @param param1 参数
     * @return 设置精度后的结果
     */
    private String dealScale(String param1) {
        return new BigDecimal(param1).setScale(Constant.SCALE, RoundingMode.UP).toString();
    }
}
