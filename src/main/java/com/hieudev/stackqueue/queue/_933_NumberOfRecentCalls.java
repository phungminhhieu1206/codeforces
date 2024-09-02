package com.hieudev.stackqueue.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Đếm số lượng cuộc gọi trong 3s
 * Input:
 * + Mảng ghi lại các lần nhận request: ["RecentCounter","ping","ping","ping","ping"]
 * + Mảng lưu tgian nhận request (ms): [[],[1],[100],[3001],[3002]]
 * Output: [null, 1, 2, 3, 3]
 * (Là số lần đã nhận cuộc gọi trong 3000ms kể từ thời điểm 'ping' trở về trước)
 * -------------------------------------------------------------------------------
 * Giải pháp:
 * Mỗi lần ping sẽ lưu vào queue, và kiểm tra phần tử đầu tiên nếu vẫn thỏa mãn dưới 3000ms thì giữ lại,
 * ngược lại thì xóa khỏi queue.
 * Số lượng phần tử trong queue sau khi xóa/ko xóa phần tử đầu queue chính là sl cuộc gọi trong 3000ms
 * kể từ thi điểm tính trở về trước.
 *
 * -> Giải phaps trên có 1 lỗ hổng: "Nếu ko phải 1 mà >1 phần tử đầu của queue hiện tại ko thỏa mãn?
 * Do đó thay đổi thành: Tại mỗi ping mới, sẽ xóa các queue không thỏa mãn mốc 3000ms
 */
public class _933_NumberOfRecentCalls {
    private Queue<Integer> myQueue;
    public static final int DISTANCE_TIME = 3000; //ms

    public static void main(String[] args) {

    }

    // _933_NumberOfRecentCalls() Initializes the counter with zero recent requests
    public _933_NumberOfRecentCalls() {
        this.myQueue = new LinkedList<>();
    }

    /**
     * int ping(int t) Adds a new request at time t, where t represents some time in
     * milliseconds, and returns the number of requests that has happened in the past
     * 3000 milliseconds (including the new request). Specifically, return the number
     * of requests that have happened in the inclusive range [t - 3000, t].
     */
    public int ping(int t) {
        int startTime = t - DISTANCE_TIME;
        myQueue.add(t);
        // xóa tất cả các giá trị không thỏa mãn khoảng 3000ms trở lại
        while (myQueue.peek() < startTime) {
            myQueue.remove();
        }
        return myQueue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
