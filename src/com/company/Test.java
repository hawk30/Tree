package com.company;

/**
 * Created by gaurav on 19/3/17.
 */
public class Test {
    public static void main(String[] args) {
        BinaryTree tree= new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        //tree.root.left.right.right.left = new Node(71);
        System.out.println("max depth "+ tree.maxDepth(tree.root));
        //System.out.println("max element "+ tree.maxElement(tree.root));
        //System.out.println("max element "+ tree.maxElementWithoutRecursion(tree.root));
        //System.out.println("element found ? "+ tree.searchElement(tree.root,4));
        //System.out.println("element found ? "+ tree.searchElementUsingRecursion(tree.root,648));
        //tree.insertElement(tree.root,67);
        //tree.insertElement(tree.root,80);
        System.out.println("max element "+ tree.maxElementWithoutRecursion(tree.root));
        System.out.println("size of binary tree "+ tree.sizeBinaryTree(tree.root));
        System.out.println("size of binary tree without recursion "+ tree.sizeOfBinaryTreeWithoutRecursion(tree.root));
        //tree.deleteTree(tree.root);
        //System.out.println("size of binary tree without recursion "+ tree.sizeOfBinaryTreeWithoutRecursion(tree.root));
        //System.out.println("level order");
        //tree.leverOrder(tree.root);
        //tree.reverseLevelOrder(tree.root);
        //System.out.println("size of binary tree without recursion "+ tree.sizeOfBinaryTreeWithoutRecursion(tree.root));
        //System.out.println("height "+tree.heightBst( tree.root));
       // System.out.println("height without recursion "+ tree.heightBstWithoutRecursion(tree.root));
        //tree.heightBstWithoutRecursion(tree.root);
        //System.out.println("deepest node "+ tree.deepestNode(tree.root).data);
    //    System.out.println("delete element "+ tree.deleteElement(tree.root, 7).data);
        //System.out.println("max element "+ tree.maxElementWithoutRecursion(tree.root));
        //System.out.println("no of leaves "+ tree.numberOfLeaves(tree.root));
        //System.out.println("no of full nodes "+ tree.moOfFullNodes(tree.root));
        //System.out.println("diameter "+ tree.diameter(tree.root));
        //System.out.println("level with max sum "+ tree.levelWithMaxSum(tree.root));
        //System.out.printf("all path from root to leaf");
       // tree.allRootsToLeafPath(tree.root, 9);
        /*System.out.println("path with given sum "+tree.pathWithGivenSumExists(tree.root,9));
        System.out.println(" sum of all elements in bst "+ tree.sumAllElementsBst(tree.root));
        System.out.println("sum all ements using recirsion "+ tree.sumAllElementsBstUsingRecursion(tree.root));
        System.out.println("mirror of a tree "+ tree.mirrorOfTree(tree.root));
        System.out.println("mirror of a tree without recursion "+ tree.mirrorTreeWithoutRecursion(tree.root));
        System.out.println("if two trees are mirror "+ tree.chkMirror(tree.root,tree.root));*/
       // System.out.println("lca "+ tree.findLca(tree.root,tree.root.left, tree.root.right.right));
       // System.out.println("lca "+ tree.findLcaSimple(tree.root,tree.root.left, tree.root.right.right).data);
        int [] inOrder = {2,5,6,10,12,14,15};
        int [] preOrder = {10,5,2,6,14,12,15};
       // System.out.println("construct tree "+ tree.constructBinaryTree(preOrder,inOrder,0, inOrder.length-1).data);
        //tree.ancestorOfNode(tree.root,7);
        //tree.zigzagTraversalBst(tree.root);
        tree.printingTreeInReverseOrder(tree.root);
    }
}
