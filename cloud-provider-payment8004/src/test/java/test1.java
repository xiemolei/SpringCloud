import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : xiemogaminari
 * create at:  2020-06-13  00:57
 * @description:
 */
public class test1 {
    public class ListDelDemo {
        @Test
        public void ArrayListHeadDelTest() {
            List<String> arrList = new ArrayList<String>();
            for (int i = 0; i < 100; i++) {
                arrList.add("Hello World!!");
            }
            List<String> arrList2 = arrList;
            long startTime = System.currentTimeMillis();
            long startMemory = Runtime.getRuntime().freeMemory();
            for (int i = 0; i < arrList.size(); i++) {
                arrList2.remove(i); // 头部删除
                i--;
            }
            long endTime = System.currentTimeMillis();
            long endMemory = Runtime.getRuntime().freeMemory();
            System.out.println("ArrayList头部删除十万个数据所花费的时间：" + (endTime - startTime) + "毫秒");
            System.out.println("ArrayList头部删除操作消耗内存:" + (endMemory - startMemory) + "b");
        }

        @Test
        public void LinkedListDelTest() {
            List<String> lnklist = new LinkedList<String>();
            for (int i = 0; i < 100000; i++) {
                lnklist.add("Hello World!");
            }
            List<String> lnkList2 = lnklist;
            long startTime = System.currentTimeMillis();
            long startMemory = Runtime.getRuntime().freeMemory();
            for (int i = 0; i < lnklist.size(); i++) {
                lnkList2.remove(i);
                i--;
            }
            long endTime = System.currentTimeMillis();
            long endMemory = Runtime.getRuntime().freeMemory();
            System.out.println("LinkedList删除十万个数据所花费的时间：" + (endTime - startTime) + "毫秒");
            System.out.println("LinkedList删除操作消耗内存:" + (endMemory - startMemory) + "b");
        }

        @Test
        public void ArrayListDelTailTest() {
            List<String> arrList = new ArrayList<String>();
            for (int i = 0; i < 100000; i++) {
                arrList.add(0, "Hello World!!");// 头部插入
            }
            List<String> arrList2 = arrList;
            long startTime = System.currentTimeMillis();
            long startMemory = Runtime.getRuntime().freeMemory();
            for (int i = arrList.size() - 1; i >= 0; i--) {
                arrList2.remove(i); // 尾部删除
            }
            long endTime = System.currentTimeMillis();
            long endMemory = Runtime.getRuntime().freeMemory();
            System.out.println("ArrayList尾部删除十万个数据所花费的时间：" + (endTime - startTime) + "毫秒");
            System.out.println("ArrayList尾部删除操作消耗内存:" + (endMemory - startMemory) + "b");
        }
    }

}