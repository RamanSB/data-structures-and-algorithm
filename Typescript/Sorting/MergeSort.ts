

function mergeSort(arr: any[], l: number, r: number): any[] {
    if (l < r) {
        let m: number = Math.floor((r + l) / 2);
        mergeSort(arr, l, m); // Sort the left half of the array.
        mergeSort(arr, m + 1, r); // Sort the right half of the array
        // By this point the left and right halves would've been sorted individually and now we need to merge the halves correctly
        // To get the correct order.
        merge(arr, l, m, r);
    }
    return arr;
}

function merge(arr: any[], l: number, m: number, r: number): void {
    let l1: number = m - l + 1; // It's possible we could have a single element array where m=l, (m-l) = 0, we expect the length to be 1 in this case hence l-m+1 is used. // Length of left array.
    let l2: number = r - m; // Length of right array.

    let left = new Array(l1); // values from l to m
    let right = new Array(l2); // Contains values from m+1 to r

    // Need these ararys to have the correct values.
    for (let i = 0; i < l1; i++) {
        left[i] = arr[l + i];
    }

    for (let j = 0; j < l2; j++) {
        right[j] = arr[m + 1 + j];

    }


    let i = 0, j = 0, k = l;
    //k:  this will be used to modify the array we are sorting.
    while (i < l1 && j < l2) {
        if (left[i] <= right[j]) {
            arr[k] = left[i];
            i++;
        } else {
            arr[k] = right[j];
            j++;
        }
        k++;

    }

    // If i>=l1, we have gone through all of l1 so we must add the remaining elements of the other array in to arr.
    while (i < l1) {
        arr[k] = left[i];
        i++;
        k++;
    }
    while (j < l2) {
        arr[k] = right[j];
        j++;
        k++;
    }

}

console.log(mergeSort([3, 1, 5, 1, 92912, 412, 21, 0], 0, [3, 1, 5, 1, 92912, 412, 21, 0].length - 1))