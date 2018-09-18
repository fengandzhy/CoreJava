/**
 * 字符串的读出，分解等共通处理。
 * 可以初步判断表达式是否合法。
 */
package com.citi.hz41382.java.caculator.md01.util;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * @author
 *
 */
public class StringUtil {

    /**
     * 分解字符串
     * 对于输入的字符串，通过给定的识别标志来分词
     *
     * @param inputStr String 待分解的字符串
     * @return 分词后的结果
     */
    public static String[] getFenciSymbol(String inputStr) {

        // 判断是否是合法表达式
        if (!isCorrectInput(inputStr)) {
            throw new RuntimeException();
        }

        // 结果集合
        List<String> resultList = new ArrayList<String>();
        resultList.add(inputStr);

        // 临时存放分词后结果的集合
        List<String> tmpFenciList = new ArrayList<String>();
        tmpFenciList.add(inputStr);

        // 根据指定的字符对参数字符串进行分词
        for (String zifu : Constant.ALL_REGEX_YSF) {

            // 原始字符（非正则表达式的表示形式）
            String yuanshiZifu = Constant.YSF_FROM_REGEX.get(zifu);
            int initLength = tmpFenciList.size();
            for (int i = 0; i < initLength; i++) {
                String fenciStr = tmpFenciList.get(i);

                // 对字符串进行初次分解
                String[] tmpFenciArray = fenciStr.split(zifu, -1);

                // 无法再分或者只包括分词本身时，本次分词完成
                if (tmpFenciArray.length == 1) {

                    // 将分解结果添加到总的分词结果集的末尾
                    tmpFenciList.add(fenciStr);
                    continue;
                }

                // 本次分词的临时结果集
                List<String> tmpHuanyuanList = new ArrayList<String>();
                for (int j = 0; j < tmpFenciArray.length; j++) {
                    String tmpFenciArrayStr = tmpFenciArray[j];

                    // 有空字符串时，说明该串是分词字符，则用分词字符替换
                    if ("".equals(tmpFenciArray[j])) {
                        tmpFenciArray[j] = zifu;
                    }

                    // 将处理后的结果添加到临时结果集中
                    tmpHuanyuanList.add(tmpFenciArray[j].trim());

                    // 如果位置不是最后一个，并且该位置的分词结果不是空串时，
                    // 说明该结果之后是分词字符，则在临时结果集中添加分词字符
                    if (j < tmpFenciArray.length - 1 && !tmpFenciArrayStr.equals("")) {
                        tmpHuanyuanList.add(zifu);
                    }
                }

                // 将临时结果集的所有结果添加到总的分词结果集的末尾
                tmpFenciList.addAll(tmpHuanyuanList);

                // 最后一个字符的特殊处理：如果被分词的字符串的最后一个项目是分词时，
                // 从分词结果中去掉最后一个结果（冗余部分）
                if (fenciStr.substring(fenciStr.length() - yuanshiZifu.length()).equals(yuanshiZifu)) {
                    tmpFenciList.remove(tmpFenciList.size() - 1);
                }
            }

            // 从总的分词结果集中将本次循环用的分词子集去掉，以避免重复解析
            for (int i = 0; i < initLength; i++) {
                tmpFenciList.remove(0);
            }
        }

        // 替换正则表达式形式的字符为普通字符：例如：【\+】→【+】
        for (int i = 0; i < tmpFenciList.size(); i++) {
            if (Constant.YSF_FROM_REGEX.containsKey(tmpFenciList.get(i))) {
                tmpFenciList.set(i, Constant.YSF_FROM_REGEX.get(tmpFenciList.get(i)));
            }
        }

        // 负数（例：-2）和正数（+5）的识别与替换
        replaceFuAndZhengSymbol(tmpFenciList);

        // 处理后的分词中，去掉空字符串
        ListIterator<String> listIter = tmpFenciList.listIterator();
        while (listIter.hasNext()) {

            // 取得当前分词
            String newFenciStr = (String)listIter.next();

            // 如果是空字符串的时候
            if ("".equals(newFenciStr)) {

                // 删除该分词
                listIter.remove();
            }
        }

        return tmpFenciList.toArray(new String[0]);
    }

    /**
     * 负号和正号的识别与替换
     * 正号/负号的位置：首字符或者前面是左括号，后面是数字或者左括号
     *
     * @param objList List<String> 替换目标，并保存替换后的结果
     */
    private static void replaceFuAndZhengSymbol(List<String> objList) {

        // 负数（例：-2）和正数（+5）的识别与替换
        // 负数的识别：【-】如果是首字符或者前面是左括号并且后面是数字的话，则是负号，
        // 将其与后面的数字合并
        for (int i = 0; i < objList.size(); i++) {

            // 当前分词取得
            String nowFenciStr = objList.get(i);

            if ("-".equals(nowFenciStr) || "+".equals(nowFenciStr)) {

                // XmlAccessorType后分词x
                String nextFenci = objList.get(i + 1);

                // 如果是首字母并且后一个分词是数字的话，则合并该两个分词
                if (i == 0) {
                    objList.set(i, nowFenciStr.concat(nextFenci));
                    objList.set(i + 1, "");
                }
                else {

                    // 取得前分词
                    String preFenci = objList.get(i - 1);

                    // 前面是左括号并且后面是数字的话, 则合并该两个分词
                    if (Constant.LEFT_BRACKET.equals(preFenci) && !Constant.REGEX_FROM_YSF.containsKey(nextFenci)) {
                        objList.set(i, nowFenciStr.concat(nextFenci));
                        objList.set(i + 1, "");
                    }

                    // 如果前面是左括号，并且后面也是左括号时，在该分词前面插入【数字：0】
                    // 例如：8+(-(8-2))→8+(0-(8-2))
                    else if (Constant.LEFT_BRACKET.equals(preFenci) && Constant.LEFT_BRACKET.equals(preFenci)) {
                        objList.add(i, "0");
                    }
                }
            }
        }
    }

    /**
     * 对于有括号（“(”和“)”）的分词结果，取得括号之间的部分。
     * 只取得一层，并返回子数组
     *
     * @param obj 原始分词数组
     * @param startIndex 子串查询的起始位置
     * @return 去掉一层括号的子串
     */
    public static String[] getInfoBetweenBracket(String[] obj, int startIndex) {

        // 子串起始位置
        int subStartIndex = -1;

        // 子串终了位置
        int subEndIndex = 0;

        Stack<String> tmpStack = new Stack<String>();
        for (int i = startIndex; i < obj.length; i++) {

            // 如果是左括号时
            if (Constant.LEFT_BRACKET.equals(obj[i])) {

                tmpStack.push(obj[i]);

                // 保存第一个左括号的位置
                subStartIndex = subStartIndex == -1 ? i : subStartIndex;
            }

            // 如果是右括号时
            else if (Constant.RIGHT_BRACKET.equals(obj[i])) {
                tmpStack.pop();

                // 如果堆栈为空，则说明该子串检索完毕
                if (tmpStack.isEmpty()) {

                    // 保存右括号的位置
                    subEndIndex = i;
                    break;
                }
            }
        }

        // 取得子串
        String[] subArray = new String[subEndIndex - subStartIndex - 1];
        System.arraycopy(obj, subStartIndex + 1, subArray, 0, subArray.length);
        return subArray;
    }

    /**
     * 判断输入字符串是否是合法表达式
     * 标准：只包括数字和指定的运算符
     *
     * @param inputStr 输入字符串
     * @return 是否是正确的表达式:false/true
     */
    public static boolean isCorrectInput(String inputStr) {

        inputStr = inputStr.trim();

        // 根据指定的字符对参数字符串进行判断
        for (String zifu : Constant.ALL_REGEX_YSF) {

            // 将所有合法字符替换掉
            inputStr = inputStr.replaceAll(zifu, "");
        }

        // 替换掉数字和小数点
        inputStr = inputStr.replaceAll("\\d+", "").replaceAll("\\.", "");

        // 如果结果字符串的长度大于0，则包括非法字符
        if (inputStr.length() > 0) {
            return false;
        }

        return true;
    }
}
