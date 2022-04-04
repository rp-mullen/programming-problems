/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    var subs = "";
    var length = 0;
    var maxLength = 0;
    
    for (var i = 0; i < s.length; i++) {
        if (!subs.includes(s[i])) {
            subs += s[i];
            length = subs.length;
        }
        else {
            if (length > maxLength) {
                maxLength = length;
            }
            subs = s[i]
            i++;
        }
    }
    return maxLength;
}
