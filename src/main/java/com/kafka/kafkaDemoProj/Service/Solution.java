package com.kafka.kafkaDemoProj.Service;

class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        while(i<nums.length-1){
            i = i + nums[i];
            if(i==0){
                return false;
            }
        }
        return i==nums.length-1;
    }
}