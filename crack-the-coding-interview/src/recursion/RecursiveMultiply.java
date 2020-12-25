package recursion;

/**
 * Recursive function to multiply two positive integers without using the * operator.
 *
 * Can use addition, subtraction & bit shifting.
 *
 * Thoughts: multiplying 2*3 = 6 = (2+2+2) (Repetitive addition)
 */
public class RecursiveMultiply {

    public static void main(String[] args){
        System.out.println(new RecursiveMultiply().multiply(2, 8));
    }

    int multiply(int value, int multiplier){
        if(multiplier==0){
            return 0;
        }
        return value + multiply(value, multiplier-1);
    }
}
