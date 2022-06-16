// problem: given a linked list with nodes defined in the following way, return the list with its middle node removed.

#include <iostream>

using namespace std;

struct ListNode {
     int val;
     ListNode *next;
     ListNode() : val(0), next(nullptr) {}
     ListNode(int x) : val(x), next(nullptr) {}
     ListNode(int x, ListNode *next) : val(x), next(next) {}
 };
 
class Solution {
public:
    ListNode* deleteMiddle(ListNode* head) {
        int idx = 0;
        ListNode *tmp = head;
        
        int size = 1;
        while (tmp->next != nullptr) {
            tmp = tmp->next;
            size++;
        }
        
        if (size > 1) {
            tmp = head;
            while (idx != ((size / 2)-1)) {
                tmp = tmp->next;
                idx++;
            }
            tmp->next = tmp->next->next;
        }
        else {
            head = nullptr;
        }
        
        return head;
    }
};

void printList(ListNode* head) {
    ListNode *tmp = head;
    cout << "[";
    while (tmp->next != nullptr) {
        cout << tmp->val << " ";
        tmp = tmp->next;
    }
    cout << tmp->val << "]" << endl;
}

int main() {
    
    ListNode* head = new ListNode(1);
    ListNode* tmp = new ListNode();
    tmp = head;
    
    for (int i = 2; i < 10; i++) {
        tmp->next = new ListNode(i);
        tmp = tmp->next;
    }
    
    Solution *S = new Solution();
    
    cout << "Input:" << endl;
    
    printList(head);
    
    cout << "Remove Middle:" << endl;
    
    S->deleteMiddle(head);
    
    printList(head);
    
    
}
