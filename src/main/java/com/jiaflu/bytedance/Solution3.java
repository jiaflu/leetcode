package com.jiaflu.bytedance;

import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        //int[] arr={4,7,2,9,5,2};
        //int[] arr={4,7,2,9};
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        int max[]=maxMethod(arr,0,arr.length-1,arr.length%2);
        //System.out.println(max[0]+" "+max[1]);

        System.out.println(Math.max(max[0], max[1]));
    }

    private static int[] maxMethod(int[] arr, int i, int j,int m) {
        int[] result=new int[2];
        if(i>j){
            return result;
        }
        if(i==j){
            result[1-m]=arr[i];
            return result;
        }
        if(i==j-1){
            result[m]=Math.max(arr[i], arr[j]);
            result[1-m]=Math.min(arr[i],arr[j]);
            return result;
        }
        if((j-i)%2==1-m){
            int max=arr[i]+maxMethod(arr,i+1,j,m)[0];
            int s=i+1;
            int e=j;
            int t=arr[j]+maxMethod(arr,i,j-1,m)[0];
            if(max<t){
                max=t;
                s=i;
                e=j-1;
            }
            result[0]=max;
            result[1]=maxMethod(arr,s,e,m)[1];
        }
        if((j-i)%2==m){
            int max=arr[i]+maxMethod(arr,i+1,j,m)[1];
            int s=i+1;
            int e=j;
            int t=arr[j]+maxMethod(arr,i,j-1,m)[1];
            if(max<t){
                max=t;
                s=i;
                e=j-1;
            }
            result[1]=max;
            result[0]=maxMethod(arr,s,e,m)[0];
        }
        return result;

    }

}
