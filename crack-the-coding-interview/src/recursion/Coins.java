package recursion;

/**
 * We have denominations of coins as follows: {25, 10, 5, 1} we have an amount, n and we need to calculate the number
 * of ways we can form n from the denominations of coins we have above.
 *
 * Suppose n is 25, the proposed recursive algorithm will work as such:
 *
 * 1) Pass the amount we are interested in finding the answer for.
 * a) we start with the highest denomination & we reduce multiples of the highest denomination from the initial amount
 * b) we start off by reducing the amount by 0*highestDenomination(0*25) and then 0*(the next denomination) and so on
 * c) when the amount remaining after subtraction of a multiple of the smallest denomination is greater than 0 we subtract
 *    ascending multiples of that denomination until the amount reached is greater than 0 and less than the smallest denomination
 *
 */
public class Coins {

    public static int calculateCoins(int n) {
        int[] denoms = {25, 10, 5, 1};
        return calculateCoins(n, denoms, 0);
    }

    public static int calculateCoins(int amount, int[] denoms, int index) {
        int ways = 0;
        if (index >= 3 && amount >= 0) { //If we are using a denomination of 1 and the amount > 0 we will fully reduce.
            return 1;
        }
        int denom = denoms[index];
        for (int i = 0; amount - denom * i >= 0; i++) { //If the amount of denominations subtracted from the total amount is still greater than 0 continue iterating.
            int remainingAmount = amount - denom * i;
            System.out.format("%d - %dx%d = %d | index:%d\n", amount, denom, i, remainingAmount, index);
            ways += calculateCoins(remainingAmount, denoms, index + 1);
            System.out.println("Ways: " + ways);
        }
        return ways;
    }

    public static void main(String[] args) {
        System.out.println(calculateCoins(25));
    }


}
