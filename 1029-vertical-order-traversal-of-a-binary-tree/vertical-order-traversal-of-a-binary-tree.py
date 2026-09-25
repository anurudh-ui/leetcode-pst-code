# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: TreeNode | None) -> list[list[int]]:
        nodes = []
        def dfs(node, row, col):
            if not node:
                return
            nodes.append((col, row, node.val))
            dfs(node.left, row + 1, col - 1)
            dfs(node.right, row + 1, col + 1)    
        dfs(root, 0, 0)
        nodes.sort(key=lambda x: (x[0], x[1], x[2]))
        result = []
        current_col = None
        current_column_values = []
        for col, row, val in nodes:
            if col != current_col:
                if current_column_values:
                    result.append(current_column_values)
                current_col = col
                current_column_values = [val]
            else:
                current_column_values.append(val)        
        if current_column_values:
            result.append(current_column_values)
            return result