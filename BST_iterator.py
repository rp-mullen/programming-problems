"""
problem: implement an in-order iterator class for a binary search tree
"""

# Definition for a binary tree node.
class TreeNode:
     def __init__(self, val=0, left=None, right=None):
         self.val = val
         self.left = left
         self.right = right


class BSTIterator:

    def __init__(self, root):
        self.root = root
        
        # node stack
        self.q = []
        
        while root is not None:
            self.q.append(root)
            root = root.left
    
    def curr(self):
        # get top of the stack
        return self.q[-1]

    def next(self) -> int:
        curr = self.curr().right
        returnNode = self.curr()
        self.q.pop()
        
        while curr is not None:
            self.q.append(curr)
            curr = curr.left
        return returnNode.val
    
    def iterate(self):
        while not self.isEnd():
            print(str(self.next()) + " ")
    def isEnd(self):
        return not len(self.q)

    def hasNext(self) -> bool:
        return not self.isEnd()

# test code
def init():
    
    """
        test tree
           7
        /     \
      3         15
              /    \
            9       20  
    """
    
    root = TreeNode(7)
    
    root.left = TreeNode(3)
    root.right = TreeNode(15)
    
    root.right.left = TreeNode(9)
    root.right.right = TreeNode(20)
    
    it = BSTIterator(root)
    it.iterate()

init()
