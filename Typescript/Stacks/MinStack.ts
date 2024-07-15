
class MinStack {

    private stack: number[];
    private minimumByIdx: Map<number, number>;
    private idx: number

    constructor() {
        this.stack = [];
        this.minimumByIdx = new Map();
        this.idx = 0;
    }


    // If no minimum value exists (happens when adding an element to the stack for the first time) - ensure we add the minimum value correctly.
    // [6,5,7] {1: 6, 2: 5, 3: 7}
    push(val: number): void {
        this.stack[this.idx] = val;
        if (this.idx == 0) {
            this.minimumByIdx[this.idx] = val;
        } else {
            const previousMinimum = this.minimumByIdx[this.idx - 1];
            if (val < previousMinimum) {
                this.minimumByIdx[this.idx] = val;
            } else {
                this.minimumByIdx[this.idx] = previousMinimum;
            }
        }
        this.idx++;
    }

    pop(): void {
        this.stack.pop();
        this.idx--;
        delete this.minimumByIdx[this.idx];
    }

    top(): number {
        return this.stack[this.idx - 1];
    }

    getMin(): number {
        return this.minimumByIdx[this.idx - 1];
    }
}
