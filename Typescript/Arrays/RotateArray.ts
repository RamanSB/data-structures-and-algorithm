/* 
    Problem: Rotate Array.

    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

    Note: Honestly doing this question exhausted me and made me feel somewhat stupid. You'd think dealing with arrays would
    be simple, but I was stumped, I initially thought I could find the most efficient solution by swapping values in place 
    not needing additional memory, but it took me 30 minutes to no avail, I managed to figure out how to do this problem with
    O(N) additional space.

    My brain is thinking two pointers and keeping track of a the swapped value but I couldn't piece it together.
*/



/**
    Intention here is to understand values at index (i) will be moved to (i+k), an issue arises when:
    i+k>=N (where N is the length of the nums array) - here we would get an index out of bounds.
    We need to realise that when i+k>=N, we should actually be moving the element at index i to '(i + k) % N'.

    A point to note is that if k = N, we do not apply rotation because the elements will arrive in the same place, therefore we can deduce that
    trueK = k % N.

    This can be quite simply solved by using an additional array in memory of size N, we know the rotated array is of size N.
    
    We begin by initialising a new array of size N.
    Iterating through the nums array and ensure that we place element at index i to (i + k) % N.
    We then iterate from 0 to N, overwriting the element at each index of the original nums array with the rotatedArray values.

    Space Complexity: O(N) - Additional array used in memory (rotatedArray) of size N.
    Tiem Complexity: O(N) + O(N) ~ O(2N) ~ O(N) two separate for loops iterating through the entire array. 
 */
function rotate(nums: number[], k: number): void {
    const N: number = nums.length;
    const trueK: number = k % N;
    let rotatedArray: number[] = Array(N);
    for (let i: number = 0; i < N; i++) {
        rotatedArray[(i + trueK) % N] = nums[i];
    }

    for (let i: number = 0; i < N; i++) {
        nums[i] = rotatedArray[i];
    }
    console.log(nums);
};


/**
 * Noticed a few patterns: 
 * When K=1, in essence all elements are moved up by one index and the last element is placed at index 0.
 * When K=2, the 2nd last element
 * @param nums 
 * @param k 
 * @returns 
 */
function rotateB(nums: number[], k: number): void {
    const N: number = nums.length;
    const trueK: number = k % N;
    if (trueK == 0) {
        return;
    }
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, trueK - 1);
    reverse(nums, trueK, nums.length - 1);


};

function reverse(nums: number[], start: number, end: number): number[] {

    while (start < end) {
        let temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++
        end--;
    }
    return nums;
}

const nums: number[] = [1, 2, 3, 4, 5, 6, 7]
const k: number = 3;

// rotate(nums, k);
console.log(reverse(nums));
console.log(reverse([1, 2, 3, 4]));