//future value recursive function;
package recurve;

/**
 *
 * @author Derek Sauri
 */
public class Recurve {

    public static float saving(float pv, float i, int n){   
     float fv = pv * interest(i, n);
     return fv;
    }
    public static float interest(float i, int n){
        if(n == 0) return 1;
        float a = (1 + i)*interest(i, n - 1);
        return a;
    }
    public static void main(String[] args) {
     float answer = saving(100,50, 2);
     System.out.println("future value: "+answer);
    }
    
}
