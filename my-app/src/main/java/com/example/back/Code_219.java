package com.example.back;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.*;

public class Code_219 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);


        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("void run ...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, executorService);

        voidCompletableFuture.whenComplete( (v, e) -> {
            if (Objects.isNull(e)) {
                System.out.println("success");
            }
        } ).exceptionally( e -> {
            e.printStackTrace();
            return null;
        });


    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int count = 0;
        int preIndex = 0;
        if (k == 0) {
            return false;
        }

        HashMap<Integer, Boolean> integerIntegerHashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            count++;
            if (integerIntegerHashMap.get(nums[i]) != null) {
                return true;
            }
            integerIntegerHashMap.put(nums[i], true);
            if (count >= k + 1) {
                integerIntegerHashMap.remove(nums[preIndex++]);
            }
        }
        return false;
    }
}
