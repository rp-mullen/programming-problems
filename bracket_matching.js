// problem: given a string of brackets, write a method that determines whether each
// bracket in the string is part of a matching pair (is 'closed').

function isClosed(s) {
    // instantiate map of brackets
    const brkts = new Map();
    brkts.set('{','}');
    brkts.set('(',')');
    brkts.set('[',']');
    
    // create running stack of open brackets and pop them when a closing bracket of the right kind
    // is found in the correct position
    var st = new Stack();
    for (var i = 0; i < s.length; i++) {
        var ch = s[i];
        if (ch === "{" || ch === "(" || ch === "[") {
            st.push(ch);
        }
        else {
            if (st.size !== 0) {
                var top = st.peek();
                if((ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '[')) {
                    st.pop();
                }
                else {
                    return false;
                }
            
            }
            else {
                return false;
            }
        }
    }
    // if the stack is empty by the end of the string, all brackets have been matched and the string is "closed" (true). else, "open" (false).
    if (st.size === 0) {
        return true;
    }
    else {
        return false;
    }
}

// Stack and Node classes were implemented from scratch because js has no native stack structure.
class Node {
    constructor(data, next=null) {
        this.data = data;
        this.next = next;
    }
}

class Stack {
    constructor(maxSize=1000) {
        this.maxSize = maxSize;
        this.top = null;
        this.size = 0;
    }
    
    peek() {
        return this.top.data;
    }
    
    push(n) {
        if (!this.top) {
            this.top = new Node(n);
            this.size++;
        }
        else {
            var tmp = this.top;
            var newNode = new Node(n);
            this.top = newNode;
            this.top.next = tmp;
            this.size++;
        }
    }
    
    pop() {
        if (this.top) {
            var tmp = this.top;
            this.top = this.top.next;
            this.size--;
            return tmp;
            
        }
        else {
            console.log("Stack underflow!");
        }
    }
    
    print() {
        var str = "";
        var tmp = this.top;
        str += (tmp.data + ", ");
        
        while (tmp.next !== null) {
            tmp = tmp.next;
            if (tmp.next === null) {
                str += tmp.data;
            }
            else {
            str += (tmp.data + ", ");
            }
                
        }
        str += "";
        console.log(str);
    }
    
}

// tests
console.log("Input: [[]] - Output: " + isClosed("[[]]"));
console.log("Input: [[]]] - Output: " + isClosed("[[]]]"));
console.log("Input: ()() - Output: " + isClosed("()()"));
console.log("Input: {{{ - Output: " + isClosed("{{{"));
