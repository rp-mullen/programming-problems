// problem: given an input string and a set of indices,
// reorder the chars of the string according to the indices vector.

#include <iostream>
#include <vector>

std::string restoreString(std::string s, std::vector<int>& indices);

// test code
int main() {
  std::string s = "codeleet";
  std::vector<int> indices = {4, 5, 6, 7, 0, 2, 1, 3};

  std::cout << restoreString(s, indices) << std::endl;
}

// algorithm {O(N), O(N)}
std::string restoreString(std::string s, std::vector<int>& indices) {
  std::string result = "";
  for (int i = 0; i < s.length(); i++) {
    result += " ";
  }
  for (int i = 0; i < indices.size(); i++) {
    result[indices[i]] = s[i];
  }

  return result;
}
