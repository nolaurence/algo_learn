package cn.nolaurence.labuladong.bt;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Leetcode341 {
    public static void main(String[] args) {
        System.out.println("hello");
    }
}

class NestedInteger {
    private Integer val;
    private List<NestedInteger> list;

    public NestedInteger(Integer val) {
        this.val = val;
        this.list = null;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.val = null;
        this.list = list;
    }
    public boolean isInteger() {
        return val != null;
    }
    public Integer getInteger() {
        return this.val;
    }
    public List<NestedInteger> getList() {
        return this.list;
    }
}

class NestedIterator implements Iterator<Integer> {
    private LinkedList<NestedInteger> list;
    public NestedIterator(List<NestedInteger> nestedList) {
        // 不直接用nestedList的引用，是因为不确定其底层实现
        // 必须保障是LinkedList，因为要在头部插入元素
        list = new LinkedList<>(nestedList);
    }

    public Integer next() {
        // hasNext()保证了list的第一个元素是整数
        return list.removeFirst().getInteger();
    }

    public boolean hasNext() {
        // 循环拆分列表元素，知道列表第一个元素是证书类型
        while (!list.isEmpty() && !list.get(0).isInteger()) {
            // 当列表开头第一个元素是列表类型时，进入循环
            List<NestedInteger> first = list.removeFirst().getList();
            // 将第一个列表打平并按照顺序添加到开头
            for (int i = first.size() - 1; i >= 0; i--) {
                list.addFirst(first.get(i));
            }
        }
        return !list.isEmpty();
    }
}
