/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stackpractice;

/**
 * Derek Sauri
 */
import java.util.Stack;

public class StackPractice {
    
    public static int[] pushint (int a[], int num){
        int length;
        length = a.length * 2;
        int[] aNew = new int[length];
        for(int i = 0;i < a.length; i++) aNew[i] = a[i];
        aNew[length] = num;
        a = null;
        return aNew;
    }
    public static void peekint (int a[]){
       System.out.println("top of array " + a[a.length]);
    }
    public static int[] popint (int a[]){
        int length = a.length - 1;
        int[] aNew = new int[length];
         for(int i = 0;i < aNew.length; i++) aNew[i] = a[i];
        a= null;
        return aNew;
    }
public static void printInt(int a[]){
    for (int i = 0; i < a.length; i++){
        System.out.println(+ a[i]);
    }
}
    public static void showpush(Stack st, int a){
      st.push(new Integer(a));
      System.out.println("push(" + a + ")");
      System.out.println("stack: " + st);
   }
    
    public static void showpeek(Stack st){
      System.out.println("top element"+st.peek()); 
    }

  public static void showpop(Stack st){
      System.out.print("pop ");
      Integer a = (Integer) st.pop();
      System.out.println(a);
      System.out.println("stack: " + st);
  }
    
   public static < E > void printArray( E[] e )
   {           
         for ( E element : e ){        
            System.out.printf( "%s ", element );
         }
         System.out.println();
   }
 
    public static void main(String[] args){
          // stack class impementation
        Stack st = new Stack();
        Integer[] array = {1,2,3,4,5};
        String[] sray = {"Stacks ","are ", "weird "};
       int[] a = {1,2,3,4,5};
       System.out.println("playing with primitive int array");
       printInt(a);
       int[] a1 = pushint(a, 10);
       peekint(a1);
      int [] a2 = popint(a);
       printInt(a2);
       // stack class operations
        System.out.println("this is putting integers in a stack");
        showpush(st,20);
        showpush(st,21);
        showpush(st,14);
        showpush(st,17);
        showpeek(st);
        showpop(st);
        showpush(st,17);
        showpeek(st);
        showpop(st);
        showpush(st,65);
        showpeek(st);
        showpop(st);
        printArray(array);
        printArray(sray);
        while(st.isEmpty() == false){
           System.out.println("will now empty stack\n");
           st.clear();
        }
         System.out.println("stack is empty\n");
       
        
    }
    
}
