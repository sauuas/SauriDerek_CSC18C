/*
 * Recursion
 * Derek Sauri
 */
package sum;


public class Sum {

 public static int theSum(int a[],int first,int last){
     if(last - first <= 1) return a[first];
     int mid = (last + first)/2;
     int sum = theSum(a, first, mid) + theSum(a, mid, last);
     return sum;
    }
    public static void main(String[] args) {
        int size = 10;
        int a[] = new int[size];
        for(int i = 0;i < size; i++) a[i] = i + 1;
        //find half the sum
        int res = theSum(a, 0, size);
        System.out.println("the sum: "+res);
    }
    
}
