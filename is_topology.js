// implement a set class with union and intersection, then write a function to determine whether a set T of subsets of X
//is a topology on X.

class Set {
    constructor(arr) {
        this.elems = [];
        for (var i = 0; i < arr.length; i++) {
            if (!this.elems.includes(arr[i])) {
                this.elems.push(arr[i]);
            }
        }
        
    }
    
    static union(S,T) {
        var U = [];
        for (var i = 0; i < S.elems.length; i++) {
            U.push(S.elems[i]);
        }
        for (var j = 0; j < T.elems.length; j++) {
            if (!U.includes(T.elems[j])) {
                U.push(T.elems[j]);
            }
        }
        return new Set(U.sort());
    }
    
    static intersection(S,T) {
        var I = [];
        for (var i = 0; i < S.elems.length; i++) {
            for (var j = 0; j < T.elems.length; j++) {
                if (S.elems.includes(T.elems[j]) && !I.includes(T.elems[j])) {
                    I.push(T.elems[j]);
                }
                else if (T.elems.includes(S.elems[i]) && !I.includes(S.elems[i])) {
                    I.push(S.elems[i]);
                }
            }
        }
        
        return new Set(I.sort());
    }
}

// is T a topology of X?
function isTopology(X,T) {
    let conditionOne;
    // (i.) X and ∅ are both in T
    if (T.includes(X) && T.includes(new Set([]))) {
        console.log("Contains X and NULL set");
        conditionOne = true;
    }
    else {
        conditionOne = false;
    }
    
    
    // (ii.) The union of any number of sets in T is also in T
    let conditionTwo;
    //console.log("Unions:");
    for (var i = 0; i < T.length; i++) {
        for (var j = 0; j < T.length; j++) {
            //console.log(Set.union(T[i],T[j]));
            if (T.includes(Set.union(T[i],T[j]))) {
                conditionTwo = true;
            }
            else {
                conditionTwo = false;
            }
        }
    }
    
    // (iii.) the intersection of any two sets in T is alos in T
    let conditionThree;
    for (var i = 0; i < T.length; i++) {
        for (var j = 0; j < T.length; j++) {
            if (T.includes(Set.intersection(T[i],T[j]))) {
                conditionThree = true;
            }
            else {
                conditionThree = false;
            }
        }
    }
    
    //console.log(conditionOne);
    //console.log(conditionTwo);
    //console.log(conditionThree);
    
    return (conditionOne && conditionTwo && conditionThree);
    }


var nullSet = new Set([]);
var X = new Set(['a','b','c','d','e','f']);
var T = [X, nullSet, new Set(['a']), new Set(['c','d']), new Set(['a','c','d']), new Set(['b','c','d','e','f'])];

console.log(T.includes(new Set([])));

console.log(isTopology(X,T));
