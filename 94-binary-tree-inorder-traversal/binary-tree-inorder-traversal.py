class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        
        def traverse(node):
            if not node:
                return
            traverse(node.left)        
            result.append(node.val)    
            traverse(node.right)       
            
        traverse(root)
        return result