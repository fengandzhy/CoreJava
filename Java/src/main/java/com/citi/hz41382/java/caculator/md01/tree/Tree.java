/**
 * 构造一个二叉树，该二叉树是以下结构：
 * 叶子节点都是数字，非叶子节点都是运算符。
 * 对于双目运算符，左子节点是左操作数，右子节点是右操作数。
 * 对于单目运算符，只有左子节点。
 *
 */
package com.citi.hz41382.java.caculator.md01.tree;

import java.util.ArrayList;
import java.util.List;

import com.citi.hz41382.java.caculator.md01.caculate.Calculator;
import com.citi.hz41382.java.caculator.md01.util.Constant;
import com.citi.hz41382.java.caculator.md01.util.StringUtil;
import com.citi.hz41382.java.caculator.md01.operator.Yunsuanfu;

/**
 * @author
 *
 */
public class Tree {

    /** 根节点 */
    private Node root;

    /** 单目运算符的个数 */
    private int singleCount;

    /** 运算符的个数 */
    private int symbolCount;

    /** 数字的个数 */
    private int dataCount;

    /** 构造方法 */
    public Tree() {
        root = new Node();
        singleCount = 0;
        symbolCount = 0;
        dataCount = 0;
    }

    /**
     * @return root
     */
    public Node getRoot() {
        return root;
    }

    /**
     * @param root 設定する root
     */
    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * @param singleCount 設定する singleCount
     */
    public void setSingleCount(int singleCount) {
        this.singleCount = singleCount;
    }


    /**
     * 数据插入
     * 所有的字符都可插入（但不包括括号）
     * @param strInput String
     * @return true：成功插入，false：插入失败
     */
    public boolean insert(String[] strInput) {

        try {
            insert(strInput, this);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * 向参数指定的树中插入数据
     * 所有的字符都可插入（包括数字和运算符,包括括号）
     * @param strInput String 插入字符数组
     * @param tree Tree 目标树
     */
    private void insert(String[] strInput, Tree tree) {

        // 遍历数组，插入元素，如果是括号的话，则将两个配对括号
        // 之间的元素作为子树插入
        for (int i = 0; i < strInput.length; i++) {
            String input = strInput[i];

            // 插入元素不是左括号时,插入该元素
            if (!Constant.LEFT_BRACKET.equals(input)) {
                insert(input, tree);
            }
            else {

                // 取得括号之间的子字符串数组
                String[] subStrArray = StringUtil.getInfoBetweenBracket(strInput, i);

                // 构造子树
                Tree subTree = new Tree();
                insert(subStrArray, subTree);

                subTree.getRoot().setSubTreeFlg(true);

                // 如果子树过大，则先计算其值
                if (subTree.dataCount + subTree.singleCount + subTree.symbolCount > 1000) {
                    String newInput = new Calculator().calculate(subTree);
                    insert(newInput, tree);

                } else {

                    // 将子树插入到主树中
                    insertSubTree(tree, subTree);
                }

                // 重置索引位置
                i = subStrArray.length + i + 1;
            }
        }
    }

    /**
     * 向参数指定的树中插入数据
     * 所有的字符都可插入（包括数字和运算符）
     * @param str String
     * @param tree 插入树
     */
    private void insert(String str, Tree tree) {

        // 取得左子树
        Node leftNode = tree.getRoot().getLeft();

        if (leftNode != null) {
            Tree leftSubTree = new Tree();
            leftSubTree.setRoot(leftNode);

            Yunsuanfu leftNodeYsf = Constant.YUN_SUAN_FU_SET.get(leftNode.getData());
            if (leftNodeYsf != null &&  (tree.dataCount + tree.singleCount + tree.symbolCount) > 200) {

                // 计算左子树的值
                Node newLeftNode = new Node();
                newLeftNode.setData(new Calculator().calculate(leftSubTree));
                newLeftNode.setParent(tree.getRoot());
                tree.getRoot().setLeft(newLeftNode);
            }
        }

        Node newNode = new Node(str);
        insert(newNode, tree);
    }

    /**
     * 数据插入
     * 所有的字符都可插入（包括数字和运算符）
     * @param node Node 新插入节点
     * @param tree Tree 插入目标树
     */
    private void insert(Node node, Tree tree) {

        // 运算符或者子树插入时
        if (Constant.YUN_SUAN_FU_SET.get(node.getData()) != null) {
            insertSymbol(node, tree);
        }

        // 数字插入时
        else {
            insertNumOrSingle(node, tree);
        }
    }

    /**
     * 数据插入(数字或者单目运算符)
     * @param newNode Node 插入节点
     * @param tree Tree 插入目标树
     */
    private void insertNumOrSingle(Node newNode, Tree tree) {

        // 插入节点
        Yunsuanfu newNodeYsf = Constant.YUN_SUAN_FU_SET.get(newNode.getData());

        // 可否插入新节点的判断
        if (!isCorrectTree(tree)) {
            throw new RuntimeException();
        }

        // 根节点为空时
        if (tree.root.getData() == null) {
            tree.root = newNode;
        }

        // 如果根的右子节点为空时，作为根的右子节点插入
        else if (tree.root.getRight() == null) {
            tree.root.setRight(newNode);
            newNode.setParent(tree.root);
        }

        // 如果根的右子节点不为空时，则沿右子树向下遍历，寻找右子节点
        // 为空的节点，作为右子节点插入
        else {
            Node subRoot = tree.root.getRight();
            while (subRoot != null && subRoot.getData() != null) {
                if (subRoot.getRight() == null) {

                    // 作为右子节点插入
                    subRoot.setRight(newNode);
                    newNode.setParent(subRoot);
                    break;
                }

                // 当前节点不能插入，则继续向下遍历
                subRoot = subRoot.getRight();
            }
        }

        // 数字节点/字符节点的个数累加
        if (newNodeYsf != null && Constant.YSF_PRIORITY_SINGLE.equals(newNodeYsf.getPriorityFlg())) {
            tree.singleCount++;
            tree.symbolCount++;
        }
        else {
            tree.dataCount++;
        }
    }

    /**
     * 数据插入(运算符)
     * @param newNode Node 新插入节点
     * @param  tree Tree 插入目标树
     */
    private void insertSymbol(Node newNode, Tree tree) {

        // 插入节点
        Yunsuanfu newNodeYsf = Constant.YUN_SUAN_FU_SET.get(newNode.getData());

        // 能否插入的判断
        // 新插入节点的计数
        if (Constant.YSF_PRIORITY_SINGLE.equals(newNodeYsf.getPriorityFlg())) {
            tree.singleCount++;
            tree.symbolCount++;

            // 单目运算符插入
            insertNumOrSingle(newNode, tree);
        }
        else {
            tree.symbolCount++;

            // 双目运算符插入
            insertDoubleSymbol(newNode, tree);
        }
    }

    /**
     * 数据插入(子树)
     * @param tree Tree 父节点树
     * @param subTree Tree 子节点树
     */
    private void insertSubTree(Tree tree, Tree subTree) {

        // 能否插入的判断
        // 新插入子树的计数
        tree.singleCount += subTree.singleCount;
        tree.symbolCount += subTree.symbolCount;
        tree.dataCount += subTree.dataCount;

        // 当主树为NULL时
        if (tree.root.getData() == null) {

            // 返回该子树（NULL型子树）
            tree.root = subTree.root;
            return;
        }

        // 构建子树，将所有的子树的父节点都设NULL节点
        Tree nullTree = new Tree();
        nullTree.root.setLeft(subTree.root);
        subTree.root.setParent(nullTree.root);

        Node tmpRoot = tree.root;
        while (true) {

            // 右子节点为空时，将构建的子树作为右子树插入到主树中
            if (tmpRoot.getRight() == null || tmpRoot.getRight().getData() == null) {
                nullTree.getRoot().getLeft().setParent(tmpRoot);
                tmpRoot.setRight(nullTree.getRoot().getLeft());
                break;
            }
            else {

                // 继续向下遍历
                tmpRoot = tmpRoot.getRight();
            }
        }
    }

    /**
     * 数据插入(运算符)
     * @param newNode Node 新插入节点
     * @param tree Tree 插入目标树
     */
    private void insertDoubleSymbol(Node newNode, Tree tree) {

        // 插入节点
        Yunsuanfu newNodeYsf = Constant.YUN_SUAN_FU_SET.get(newNode.getData());

        // 可否插入新节点的判断
        if (!isCorrectTree(tree)) {
            throw new RuntimeException();
        }

        // 根节点是NULL节点时(说明该树是独立子树)
        if (tree.root.getData() == null) {
            tree.root = tree.root.getLeft();
            tree.root.setParent(null);
        }

        // 根节点
        Yunsuanfu rootYsf = Constant.YUN_SUAN_FU_SET.get(tree.root.getData());

        // 根节点是数字或者插入节点的运算符优先级低于等于根节点或者根节点是独立树（被括号包围的运算式）时
        if (rootYsf == null || newNodeYsf.getPriority().compareTo(rootYsf.getPriority()) >= 0 || tree.getRoot().getSubTreeFlg()) {
            tree.root.setParent(newNode);
            newNode.setLeft(tree.root);

            // 重置root根节点
            tree.root = newNode;
        }

        // 插入节点的运算符优先级高于或者等于根节点时
        else if (newNodeYsf.getPriority().compareTo(rootYsf.getPriority()) < 0) {

            // 运算符的插入位置的父节点
            Node tmpRoot = tree.root;
            Yunsuanfu tmpRootRightYsf = Constant.YUN_SUAN_FU_SET.get(tmpRoot.getRight().getData());

            // 右子节点不为空时
            if (tmpRoot.getRight() != null) {

                // 该右子节点是叶子节点或者运算符优先级高于或等于插入节点时,则停止，否则继续查找右子树
                while (!(tmpRootRightYsf == null || (tmpRootRightYsf.getPriority() != null
                        && tmpRootRightYsf.getPriority().compareTo(newNodeYsf.getPriority()) <= 0))) {
                    tmpRoot = tmpRoot.getRight();
                    tmpRootRightYsf = Constant.YUN_SUAN_FU_SET.get(tmpRoot.getRight().getData());
                }

                // 将插入节点设为当前节点的右子节点的父节点
                tmpRoot.getRight().setParent(newNode);
            }

            newNode.setParent(tmpRoot);
            newNode.setLeft(tmpRoot.getRight());
            tmpRoot.setRight(newNode);
        }
    }

    /**
     * 得到计算用表达式（树的根优先表示顺序）
     * （逆波兰式）
     *
     * @return 计算用表达式
     */
    public String[] getTreeInfoForCalc() {

        return getByRootFirst(root).toArray(new String[0]);
    }

    /**
     * 得到表示用表达式（树的左优先表示顺序）
     * （包括：括号的追加，0的追加等操作）
     *
     * @return 表示用表达式
     */
    public String[] getTreeInfoForView() {

        return getByLeftFirst(root).toArray(new String[0]);
    }

    /**
     * 得到子树的信息（根优先）
     *
     * @param node Node 节点
     * @return 按指定顺序输出的子树信息
     */
    private List<String> getByRootFirst(Node node) {
        List<String> treeStrList = new ArrayList<String>();

        if (null == node || node.getData() == null) {
            return treeStrList;
        }

        // 根节点
        treeStrList.add(node.getData());

        // 追加左右子树
        if (!isLeaf(node)) {
            treeStrList.addAll(getByRootFirst(node.getLeft()));
            treeStrList.addAll(getByRootFirst(node.getRight()));
        }

        return treeStrList;
    }

    /**
     * 得到子树的信息（左优先）
     *
     * @param node Node 节点
     * @return 按指定顺序输出的子树信息
     */
    private List<String> getByLeftFirst(Node node) {
        List<String> treeStrList = new ArrayList<String>();

        // 空节点时直接返回
        if (null == node || node.getData() == null) {
            return treeStrList;
        }

        // 如果是独立树时，前面加上括号（【(】）
        if (node.getSubTreeFlg()) {
            treeStrList.add("(");
        }

        // 追加左子树
        if (!isLeaf(node)) {
            treeStrList.addAll(getByLeftFirst(node.getLeft()));
        }

        // 追加根节点
        treeStrList.add(node.getData());

        // 追加右子树
        if (!isLeaf(node)) {
            treeStrList.addAll(getByLeftFirst(node.getRight()));
        }

        // 如果是独立树时，后面加上括号（【)】）
        if (node.getSubTreeFlg()) {
            treeStrList.add(")");
        }

        return treeStrList;
    }

    /**
     * 判断当前树的状态能否插入新节点
     * @param tree Tree 目标树
     * @return true:可以插入 / false:不可插入
     */
    private boolean isCorrectTree(Tree tree) {

        // N（数）+N（单）（包括新插入点）-N（符）（包括新插入点） = 0
        if (tree.dataCount + tree.singleCount - tree.symbolCount != 0) {
            return false;
        }

        return true;
    }

    /**
     * 判断一个节点是否是叶子节点
     * @param node Node 节点
     * @return true:叶子节点 / false:非叶子节点
     */
    private boolean isLeaf(Node node) {

        // 如果数据部是字符的话，则不是叶子节点
        if (Constant.YUN_SUAN_FU_SET.containsKey(node.getData())) {
            return false;
        }

        return true;
    }
}
