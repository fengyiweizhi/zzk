package acwing.数据结构.单链表;

import leetcode.LinkListGo;

import java.util.Scanner;

/**
 * 实现一个单链表，链表初始为空，支持三种操作：
 * <p>
 * 向链表头插入一个数；
 * 删除第 k 个插入的数后面的数；
 * 在第 k 个插入的数后插入一个数。
 * 现在要对该链表进行 M 次操作，进行完所有操作后，从头到尾输出整个链表。
 * <p>
 * 注意:题目中第 k 个插入的数并不是指当前链表的第 k 个数。例如操作过程中一共插入了 n 个数，则按照插入的时间顺序，这 n 个数依次为：第 1 个插入的数，第 2 个插入的数，…第 n 个插入的数。
 * <p>
 * 输入格式
 * 第一行包含整数 M，表示操作次数。
 * <p>
 * 接下来 M 行，每行包含一个操作命令，操作命令可能为以下几种：
 * <p>
 * H x，表示向链表头插入一个数 x。
 * D k，表示删除第 k 个插入的数后面的数（当 k 为 0 时，表示删除头结点）。
 * I k x，表示在第 k 个插入的数后面插入一个数 x（此操作中 k 均大于 0）。
 * 输出格式
 * 共一行，将整个链表从头到尾输出。
 * <p>
 * 数据范围
 * 1≤M≤100000
 * 所有操作保证合法。
 * <p>
 * 输入样例：
 * 10
 * H 9
 * I 1 1
 * D 1
 * D 0
 * H 6
 * I 3 6
 * I 4 5
 * I 4 5
 * I 3 4
 * D 6
 * 输出样例：
 * 6 4 6 5
 *
 *建议用数组模拟，以下代码未解决 详情看‘单链表使用数组模拟’
 * @author 风亦未止
 * @date 2022/12/3 14:44
 */
public class 单链表 {
    static class LinkList {
        public int val;
        public LinkList next;

        public LinkList() {

        }
        public LinkList(int val) {
            this.val = val;
        }
        public LinkList(int val, LinkList next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        LinkList linkList = null;
        while (m > 0) {
            String op = scanner.next();
            if ("H".equals(op)) {
                int x = scanner.nextInt();
                LinkList head = new LinkList(x);
                head.next = linkList;
                linkList = head;
            }
            if ("I".equals(op)) {
                int k = scanner.nextInt();
                int x = scanner.nextInt();
                LinkList temp = linkList;
                while (temp!=null&&k-1!=0) {
                    k--;
                    temp=temp.next;
                }
                LinkList node = new LinkList(x);

                LinkList tempNode = temp.next;
                temp.next=node;
                node.next=tempNode;
            }
            if ("D".equals(op)) {
                int k = scanner.nextInt();
                LinkList cure = linkList;
                LinkList pre = null;
                while (cure!=null&&k!=0) {
                    if(pre==null){
                        pre=cure;
                    }else{
                        pre=pre.next;
                    }
                    cure= cure.next;
                    k--;
                }
                if(pre==null){
                    cure=cure.next;
                    linkList=cure;
                }else{
                    pre.next=cure.next;
                    cure.next=null;
                }

            }
            m--;
        }
        LinkList temp = linkList;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
