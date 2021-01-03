## Tree

### B Tree

### B+ Tree

### AVL Tree

### Read Black Tree

### Binary Search Tree

* 插入
    1. 树为空,则设为head
    2. 插入
    3. 小于找left,大于right

* 删除
    1. 如果被删除的节点没有right child node,则left child node replace.
       如果被删除的节点没有left child node,则right child node replace.
    2. 如果有左有右，则找到右节点的最左子节点

* 遍历
    * Perorder traversal (中左右)
      1. visit current
      2. visit left -> step 1.
      3. visit right -> step 2.
    * Inorder traversal (左中右)
    * Postorder traversal (左右中)