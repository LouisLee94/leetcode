package exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Exam3 {

    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int workNum = in.nextInt();
        int personNum = in.nextInt();
        HashMap<Integer,Integer> works = new HashMap<>();
        int[] worksQue = new int[workNum];
        for (int i = 0; i < workNum; i++) {
            int d = in.nextInt();
            int pi = in.nextInt();
            works.put(d,pi);
            worksQue[i] = d;
        }


        int[] Powers = new int[personNum];
        for (int i = 0; i < personNum; i++) {
            Powers[i] = in.nextInt();
        }
        Arrays.sort(worksQue);

        int maxPi =0;
        for (int i = 0; i < workNum; i++) {
            if (works.get(worksQue[i])>maxPi)maxPi=works.get(worksQue[i]);
            else {
                works.put(worksQue[i],maxPi);
            }
        }

        for (int i = 0; i < personNum; i++) {
            int index = find(Powers[i],worksQue);
            if (index ==-1){
                System.out.println("0");
            }else System.out.println(works.getOrDefault(worksQue[index],0));
        }
    }

    private static int find(int power, int[] worksD) {
        int lo = 0;
        int hi =worksD.length;
        int mid;
        do {
            mid =(hi+lo)/2;
            if (mid==worksD.length){
                return mid-1;
            }
            if (worksD[mid]==power)return mid;
            else if (worksD[mid]>power){
                hi = mid-1;
            }else {
                lo=mid+1;
            }
        }while (lo<=hi);

        if (worksD[mid]<power){
            return mid;
        }else {
            return mid-1;
        }
    }
}