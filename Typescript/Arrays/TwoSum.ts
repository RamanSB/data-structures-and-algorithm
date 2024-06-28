/* 
    Problem: TwoSum.

    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order. 
*/


/**
 * Intention here is to start by iterating through the array from the 0-th indexed element.
 * We then subtract the current element from the target and then we search if the elements 
 * after the element we have subtracted from the target contain the resulting value.
 * 
 * Time Complexity: O(n) * O(n-1) ~ O(n^2)
 * Space Complexity: O(1) (No additional space used other than the array)
 * @param nums 
 * @param target 
 * @returns 
 */
function twoSum(nums: number[], target: number): number[] {
    for (let i: number = 0; i < nums.length; i++) {
        let x: number = target - nums[i];
        for (let j = i + 1; j < nums.length; j++) {
            if (x == nums[j]) {
                return [i, j];
            }
        }
    }
    return [];
}

// Alternative approach (Reducing Time complexity & using space/memory)
/**
 * Create a Map of Key (the element) & Value (the index of the element).
 * 
 * Iterate through the array starting from the 0-th index. 
 * Calculate `target - nums[currentIdx]`, Check if the Map has/contains that value. 
 * If so we have completed the task, as we have the currentIndex and then other index from the mapping.
 * Otherwise, add the existing element as a key and the value being it's index and continue.
 */

function twoSumAlternative(nums: number[], target: number): number[] {
    const map: Map<number, number> = new Map();
    for (let i: number = 0; i < nums.length; i++) {
        let reqValue = target - nums[i];
        if (map.has(reqValue)) {
            return [i, map.get(reqValue) as number];
        }
        map.set(nums[i], i);
    }
    return [];
}