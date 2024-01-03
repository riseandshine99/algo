package leetcode.curated170;

import java.util.Deque;
import java.util.LinkedList;

public class HitCounter {
    private Deque<Integer> hits;

    public HitCounter() {
        hits = new LinkedList<>();
    }

    public void hit(int timestamp) {
        hits.addLast(timestamp);
    }

    public int getHits(int timestamp) {
        while(!hits.isEmpty() && hits.getFirst() <= timestamp - 300) {
            hits.removeFirst();
        }
        return hits.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
