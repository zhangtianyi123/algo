package zty.practise.algo.leetcode700;

import java.util.PriorityQueue;

/**
 * 需要关注的有k个数，构成的k+1个区间
 * 
 * 第一大的数，第二大的数...第k大的数
 * 
 * 所以无法使用常数空间
 * 
 * 可以考虑额外维护一个k空间 考虑第k大这个要求，可以使用优先队列（堆）
 * 
 * 1 使用数组来构建一个容量为k的小顶堆。
 * 2 如果小顶堆满后，再添加元素，那么直接和堆顶元素进行比较。
 * 2.1 如果大于堆顶元素，则重建堆；
 * 2.2 如果小于或等于堆顶元素，则忽略。
 * 3 heap[0]就是第k个最大元素
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode703 {
	
	static class KthLargest {
		int size;
	    private PriorityQueue<Integer> q;

	    /**
	     * 第k大的数正好是堆顶
	     * @param k
	     * @param nums
	     */
	    public KthLargest(int k, int[] nums) {
	        size = k;
	        q = new PriorityQueue(k);
	        for (int num : nums) {
	            add(num);
	        }
	    }

	    public int add(int val) {
	        if (q.size() < size) {
	            q.add(val);
	        } else if (q.peek() < val) {
	        	//如果比堆顶元素大 则弹出最小的，插入这个值
	            q.poll();
	            q.add(val);
	        }
	        return q.peek();
	    }

	}

	static class KthLargest2 {

	    int[] heap;

	    //heap数组中实际存放的元素数量
	    int size = 0;

	    public KthLargest2(int k, int[] nums) {
	        heap = new int[k];
	        for (int num : nums) {
	            add(num);
	        }
	    }

	    public int add(int val) {
	        if (size < heap.length) {
	            heap[size++] = val;
	        } else if(size == heap.length) {
	        	//堆化
	        	makeMinHeap();
	        }else if (heap[0] < val) {
	            //替换堆顶元素
	            heap[0] = val;
	            minHeapFixdown(0);
	        }

	        return heap[0];
	    }

	    /**
	     * 堆化heap数组，建立最小堆
	     * 
	     * 举例
	     *             0
	     *        1        2
	     *     3    4    5     6
	     *    7 8 9 10 11 12 13 14
	     */
	    private void makeMinHeap() {
	        int length = heap.length;
	        //第一个非叶子节点是(length / 2) - 1
	        for (int i = (length / 2) - 1; i >= 0; i--) {
	            minHeapFixdown(i);
	        }
	    }

	    /**
	     * 从i节点开始调整, i节点的子节点为 2*i+1, 2*i+2
	     *
	     * @param i 第i个节点
	     */
	    public void minHeapFixdown(int i) {
	        int temp = heap[i];
	        //i节点的子节点为 2*i+1, 2*i+2
	        int subLeft = 2 * i + 1;
	        while (subLeft < heap.length) {
	            int subRight = subLeft + 1;
	            if (subRight < heap.length && heap[subLeft] > heap[subRight]) {
	                subLeft++;
	            }

	            if (heap[subLeft] >= heap[i]) {
	                break;
	            }
	            heap[i] = heap[subLeft];
	            heap[subLeft] = temp;

	            i = subLeft;
	            subLeft = 2 * i + 1;
	        }

	    }
	}

}
