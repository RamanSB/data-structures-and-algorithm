

interface IStack<T> {
    pop(): T | null;
    push(value: T): void
    peek(): T | null
}


class Stack<T> implements IStack<T> {

    private stack: T[] = [];
    private idx: number = 0; // Points to the available index to enter data.

    pop(): T | null {
        if (this.idx == 0) {
            return null;
        }
        const poppedValue = this.stack[--this.idx];
        this.stack.length = this.idx; // This adjusts the length of the stack array.
        return poppedValue;
    }

    push(value: T) {
        this.stack[this.idx++] = value;
    }

    peek(): T | null {
        if (this.idx == 0) {
            return null;
        }
        const peekedValue = this.stack[this.idx - 1];
        console.log(peekedValue);
        return peekedValue;
    }


    printStack(): void {
        let str = "";
        for (let i = 0; i < this.idx; i++) {
            str += this.stack[i] + " ";
        }
        if (str.trim() === "") {
            console.log("Stack is empty");
            console.log(this.stack);

        }
        console.log(str.trim());
    }


}


let stack: Stack<string> = new Stack();

stack.peek();
stack.pop();
stack.push("(");
stack.push("[");
stack.push("<");
stack.printStack();
stack.peek();
stack.push(">")
stack.push("]")
stack.push(")")
stack.printStack();
stack.pop();
stack.pop();
stack.printStack();
stack.pop();
stack.pop();
stack.pop();
stack.pop();
stack.printStack();
stack.pop();
stack.pop();
stack.pop();
stack.printStack();



let regex = /[({[]/;
console.log(regex.test("("));
console.log(regex.test("{"));
console.log(regex.test("["));
console.log(regex.test(")"));
console.log(regex.test("}"));
