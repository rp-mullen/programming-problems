"""
problem: Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def partition(self, head, x):
        
        if head is None:
            return
        else:
        
            less = []
            geq = []
        
            tmp = head
            while tmp.next is not None:
                if tmp.val < x:
                    less.append(tmp.val)
                else:
                    geq.append(tmp.val)
                tmp = tmp.next
        
            if tmp.val < x:
                less.append(tmp.val)
            else:
                geq.append(tmp.val)

            res = less + geq
            
            res_list = ListNode(res[0])
            tmp = res_list
        
            for i in range(1,len(res)):
                tmp.next = ListNode(res[i])
                tmp = tmp.next
        
            return res_list

def print_lst(head):
    tmp = head
    while tmp.next is not None:
        print(tmp.val)
        tmp = tmp.next
    print(tmp.val)

def main():
    head = ListNode(1)
    head.next = ListNode(4)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(2)
    head.next.next.next.next = ListNode(5)
    head.next.next.next.next.next = ListNode(2)
    
    print_lst(head)
    
    print(" ")
    
    S = Solution()
    res = S.partition(head,3)
    print_lst(res)
    
    

main()
