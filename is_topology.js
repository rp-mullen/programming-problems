// problem: implement set methods union, intersection, equality, then write a function to determine whether a set T of subsets of X
// is a topology on X.


    
function union(S,T) {
    var U = [];
    for (var i = 0; i < S.length; i++) {
        U.push(S[i]);
    }
    for (var j = 0; j < T.length; j++) {
        if (!U.includes(T[j])) {
            U.push(T[j]);
        }
    }
    return U.sort();
}
    
function intersection(S,T) {
    var I = [];
    for (var i = 0; i < S.length; i++) {
        for (var j = 0; j < T.length; j++) {
            if (S.includes(T[j]) && !I.includes(T[j])) {
                I.push(T[j]);
            }
            else if (T.includes(S[i]) && !I.includes(S[i])) {
                I.push(S[i]);
            }
        }
    }
    return I.sort();
}
    
function equality(S,T) {
    return S.length === T.length && S.every((val, index) => val === T[index]);
}
    
function inclusion(A,B) {
    var incl = false;
    for (var i = 0; i < A.length; i++) {
        if (equality(A[i],B)) {
            incl = true;
        }
    }
    return incl;
}
    


// Is T a topology of X?
function isTopology(X,T) {
    // print input set and candidate topology.
    console.log("X: " + X);
    console.log("T: " + stringify(T));
    console.log("--------------------------------------------------------------------------");
    
    // (i.) T contains both X and ∅
    let conditionOne;
    let hasNull = false;
    
    for (var i = 0; i < T.length; i++) {
        if (T[i].length === 0) {
            hasNull = true;
        }
    }
    if (T.includes(X) && hasNull) {
        conditionOne = true;
    }
    else {
        conditionOne = false;
    }
    console.log("Condition (i): T contains X and ∅ : true");
    
    
    // (ii.) The union of any number of sets in T is also in T
    let conditionTwo;
    for (var i = 0; i < T.length; i++) {
        for (var j = 0; j < T.length; j++) {
            if (inclusion(T,union(T[i],T[j]))) {
                conditionTwo = true;
            }
            else {
                conditionTwo = false;
            }
        }
    }
    console.log("Condition (ii): Any union of sets in T is also in T : " + conditionTwo);
    
    // (iii.) the intersection of any two sets in T is alos in T    
    let conditionThree;
    for (var i = 0; i < T.length; i++) {
        for (var j = 0; j < T.length; j++) {
            if (inclusion(T,intersection(T[i],T[j]))) {
                conditionThree = true;
            }
            else {
                conditionThree = false;
            }
        }
    }
    console.log("Condition (iii): The intersection of any two sets in T is also in T : " + conditionThree);
    console.log("--------------------------------------------------------------------------");
    if (conditionOne && conditionTwo && conditionThree) {
        console.log("Result: T is a topology on X.")
    }
    else {
        console.log("Result: T is NOT a topology on X.")
    }
}

function stringify(T) {
    var str = ""
    for (var i = 0; i < T.length; i++) {
        if (i === T.length-1) {
            str += "[" + T[i].toString() + "]";
        }
        else {
            str += "[" + T[i].toString() + "], ";
        }
    }
    return str;
}

var X = ['a','b','c','d','e','f'];
var T = [X, [], ['a'], ['c','d'], ['a','c','d'], ['b','c','d','e','f']];

console.log("Is T a topology on X?\n");
console.log(isTopology(X,T));
