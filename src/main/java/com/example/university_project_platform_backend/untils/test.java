package com.example.university_project_platform_backend.untils;

public class test {
    public int[] a(int[]nums,int target){
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i!=j&&nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }

        }
        return result;
    }
    public static void main(String[] args) {

    }
}
