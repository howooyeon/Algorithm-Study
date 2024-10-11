import java.util.PriorityQueue;

class Solution {
    static int count = 0;
    static PriorityQueue<Integer> heap = new PriorityQueue<>();

    public int solution(int[] scoville, int K) {
        arrayToQueue(heap, scoville); 

        while (heap.peek() < K) {
            if (heap.size() < 2) return -1; 
            makeSpicy(heap);
        }

        int answer = count;
        return answer;
    }

    public static void arrayToQueue(final PriorityQueue queue, final int[] array) { 
        for (int a : array) {
            queue.add(a);
        }
    }

    public static void makeSpicy(final PriorityQueue queue) {
        int a = (int) queue.poll();
        int b = (int) queue.poll();
        int c = a + 2 * b;

        queue.add(c);
        count++;
    }
}