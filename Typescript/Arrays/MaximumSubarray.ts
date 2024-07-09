
function maxSubArray(nums: number[]): number {
    let N = nums.length;
    let pairs: number[][] = generatePairs(N);
    let maxSubArray = Number.MIN_SAFE_INTEGER;
    for (let pair of pairs) {
        let subarrayLen = calculateSubarrayLength(nums, pair);
        if (subarrayLen > maxSubArray) {
            maxSubArray = subarrayLen;
        }
    }
    return maxSubArray;
}

function generatePairs(n: number): number[][] {
    let pairs: number[][] = [];
    for (let i = 0; i < n; i++) {
        for (let j = i; j < n; j++) {
            pairs.push([i, j]);
        }
    }

    console.log(`${pairs.length} pairs generated`);
    return pairs;
}

function calculateSubarrayLength(nums: number[], pairs: number[]): number {
    let sum = 0;
    for (let i = pairs[0]; i <= pairs[1]; i++) {
        sum += nums[i];
    }
    console.log(`Length of SubArray[${JSON.stringify(pairs)}]: ${sum}`);
    return sum;
}

let numbers: number[] = [5, 4, -1, 7, 8];
maxSubArray(numbers);


function maxSubArrayB(nums: number[]): number {
    let local = 0;
    let global = Number.MIN_SAFE_INTEGER;
    for (let i = 0; i < nums.length; i++) {
        local = Math.max(nums[i], local + nums[i]);
        if (local > global) {
            local = global;
        }
    }
    return global;

}