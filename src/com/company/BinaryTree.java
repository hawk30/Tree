package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by gaurav on 19/3/17.
 */
public class BinaryTree {


    public Node root;

    int maxDepth(Node root) {
        if (root == null)
            return -1;

        int hLeft=maxDepth(root.left);
        int hRight=maxDepth(root.right);
        if (hLeft > hRight)
            return 1 + hLeft;
        else
            return
                    1 + hRight;

    }

    int maxElement(Node root) {
        if (root == null)
            return -1;
        int rootVal=root.data;
        int max=Integer.MIN_VALUE;
        int maxLeft=0;
        int maxRight=0;
        maxLeft=maxElement(root.left);
        maxRight=maxElement(root.right);
        if (maxLeft > maxRight)
            max=maxLeft;
        else
            max=maxRight;

        if (rootVal > max)
            max=rootVal;
        return max;

    }

    int maxElementWithoutRecursion(Node root) {
        int rootVal=root.data;
        int max=Integer.MIN_VALUE;
        if (root == null)
            return -1;
        int maxLeft=0, maxRight=0;
        if (root.left != null)
            maxLeft=maxElementWithoutRecursion(root.left);
        if (root.right != null)
            maxRight=maxElementWithoutRecursion(root.right);
        if (maxLeft > maxRight)
            max=maxLeft;
        else
            max=maxRight;
        if (rootVal > max)
            max=rootVal;
        return max;
    }

    boolean searchElement(Node root, int k) {
        if (root == null)
            return false;
        Queue<Node> list=new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node temp=list.poll();
            if (temp.data == k) {
                System.out.println("element is " + k);
                return true;
            }
            if (temp.left != null)
                list.add(temp.left);
            if (temp.right != null)
                list.add(temp.right);
        }
        return false;

    }

    boolean searchElementUsingRecursion(Node root, int k) {
        if (root == null)
            return false;
        if (k == root.data)
            return true;
        else
            return searchElementUsingRecursion(root.left, k) || searchElementUsingRecursion(root.right, k);

    }

    void insertElement(Node root, int k) {

        Node newNode=new Node(k);
        newNode.left=null;
        newNode.right=null;
        if (root == null)
            root=newNode;
        Queue<Node> list=new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node temp=list.poll();
            if (temp.left != null)
                list.add(temp.left);
            else
                temp.left=newNode;
            if (temp.right != null)
                list.add(temp.right);
            else
                temp.right=newNode;
        }
    }

    int sizeBinaryTree(Node root) {
 /*       int sLeft=0, sRight=0;
        Node temp=root;
        while(temp.left!=null){
            sLeft++;
            temp=temp.left;
        }
        while(root.right!=null){
            sRight++;
            root=root.right;
        }
        return sLeft+sRight+1;*/
        if (root == null)
            return 0;
        return sizeBinaryTree(root.left) + 1 + sizeBinaryTree(root.right);
    }

    int sizeOfBinaryTreeWithoutRecursion(Node root) {
        int count=0;
        Queue<Node> list=new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            count++;
            Node temp=list.poll();
            if (temp.left != null)
                list.add(temp.left);
            if (temp.right != null)
                list.add(temp.right);
        }
        return count;
    }

    void deleteTree(Node root) {
        if (root == null)
            return;
        deleteTree(root.left);
        deleteTree(root.right);
        root=null;
    }

    void leverOrder(Node root) {
        if (root == null) return;
        Queue<Node> list=new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node temp=list.poll();
            System.out.println(temp.data);
            if (temp.left != null)
                list.add(temp.left);
            if (temp.right != null)
                list.add(temp.right);
        }

    }

    void reverseLevelOrder(Node root) {
        if (root == null)
            return;
        Queue<Node> list=new LinkedList<>();
        Stack<Node> stk=new Stack<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node temp=list.poll();
            if (temp.right != null)
                list.add(temp.right);
            if (temp.left != null)
                list.add(temp.left);
            stk.push(temp);

        }
        System.out.println("stack size " + stk.size());
        while (!stk.isEmpty()) {
            // System.out.println("hi");
            System.out.println(stk.pop().data);
        }
    }

    int heightBst(Node root) {
        if (root == null)
            return 0;
        int hLeft=0, hRight=0;
        hLeft=heightBst(root.left);
        hRight=heightBst(root.right);
        return hLeft > hRight ? hLeft + 1 : hRight + 1;
    }

    int heightBstWithoutRecursion(Node root) {
       /* if(root == null)
            return 0;
        Node temp1=root, temp2=root;
        int hLeft=0, hRight=0;
        while(temp1.left!=null){
            hLeft++;
            temp1=temp1.left;
        }
        while(temp2.right!=null){
            hRight++;
            temp2=temp2.right;
        }
        return hLeft > hRight ? hLeft+1 : hRight +1;*/
        if (root == null)
            return 0;
        Queue<Node> list=new LinkedList<>();
        list.add(root);
        list.add(null);
        int level=1;
        while (!list.isEmpty()) {
            Node temp=list.poll();
            if (temp == null) {
                if (!list.isEmpty())
                    list.add(null);
                level++;
            } else {
                if (temp.left != null)
                    list.add(temp.left);
                if (temp.right != null)
                    list.add(temp.right);

            }
        }
        System.out.println("levels " + level);
        return level;
    }

    Node deepestNode(Node root) {
        if (root == null)
            return null;
        Queue<Node> list=new LinkedList<>();
        list.add(root);
        Node temp=null;
        while (!list.isEmpty()) {
            temp=list.poll();
            if (temp.left != null)
                list.add(temp.left);
            if (temp.right != null)
                list.add(temp.right);
        }
        return temp;

    }

    Node deleteElement(Node root, int k) {
        if (root == null)
            return root;
        if (k < root.data)
            root.left=deleteElement(root.left, k);
        else if (k > root.data)
            root.right=deleteElement(root.right, k);
        else {
            if (root.left != null && root.right != null) {
                Node temp=root;
                Node minElementRight=minimumElement(root.right);
                root.data=minElementRight.data;
                deleteElement(root.right, minElementRight.data);
            } else if (root.left != null)
                root=root.left;
            else if (root.right != null)
                root=root.right;
            else
                root=null;
        }
        return root;

    }

    Node minimumElement(Node root) {
        if (root == null)
            return root;
        return minimumElement(root.left);
    }

    int numberOfLeaves(Node root) {
        if (root == null)
            return -1;
        Queue<Node> list=new LinkedList<>();
        list.add(root);
        int countLeaves=0;
        while (!list.isEmpty()) {
            Node temp=list.poll();
            if (temp.left == null && temp.right == null)
                countLeaves++;
            if (temp.left != null)
                list.add(temp.left);
            if (temp.right != null)
                list.add(temp.right);
        }
        return countLeaves;
    }

    int moOfFullNodes(Node root) {
        if (root == null)
            return -1;
        Queue<Node> list=new LinkedList<>();
        list.add(root);
        int countFullNodes=0;
        while (!list.isEmpty()) {
            Node temp=list.poll();
            if (temp.left != null && temp.right != null) {
                countFullNodes++;
                if (temp.left != null)
                    list.add(temp.left);
                if (temp.right != null)
                    list.add(temp.right);
            }
        }
        return countFullNodes;

    }

    boolean structuallyIdentical(Node root1, Node root2) {
        if (root1 == null && root2 != null)
            return false;
        else if (root1 != null && root2 == null)
            return false;
        else if (root1 == null && root2 == null)
            return true;
        else
            return root1.data == root2.data && structuallyIdentical(root1.left, root2.left) && structuallyIdentical(root1.right, root2.right);
    }

    int diameter(Node root) {
        if (root == null)
            return 0;
        int hLeft=0, hright=0, dLeft=0, dRight=0;
        hLeft=diameter(root.left);
        hright=diameter(root.right);
        dLeft=diameter(root.left);
        dRight=diameter(root.right);
        return Math.max((hLeft + hright + 1), Math.max(dLeft, dRight));
    }

    int levelWithMaxSum(Node root) {
        if (root == null)
            return 0;
        Queue<Node> list=new LinkedList<>();
        list.add(root);
        list.add(null);

        int maxLevel=0, level=0;
        int currSum=0, maxSum=0;

        while (!list.isEmpty()) {

            Node temp=list.poll();

            if (temp == null) {
                if (currSum > maxSum) {
                    maxSum=currSum;
                    maxLevel=level;

                }
                currSum=0;

                if (!list.isEmpty())
                    list.add(null);
                level++;
            } else {
                currSum+=temp.data;
                if (temp.left != null)
                    list.add(temp.left);
                if (temp.right != null)
                    list.add(temp.right);


            }
        }
        return maxLevel;
    }

    void allRootsToLeafPath(Node root, int sum) {
        if (root == null)
            return;
        ArrayList<Integer> path=new ArrayList<>();
        allRootsToLeafPathRec(root, path, sum);


    }

    void allRootsToLeafPathRec(Node root, ArrayList<Integer> path, int k) {
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPaths(path);
            return;
        }
        if (root.left != null)
            allRootsToLeafPathRec(root.left, new ArrayList<>(path), k);
        // path.remove(path.size()-1);
        if (root.right != null)
            allRootsToLeafPathRec(root.right, new ArrayList<>(path), k);
        //path.remove(path.size()-1);
    }

    void printPaths(ArrayList<Integer> path) {
        for (Integer k : path)
            System.out.print(k);
        System.out.println();
    }

    boolean pathWithGivenSumExists(Node root, int sum) {
        boolean ans=false;
        if (root == null)
            return false;
        sum-=root.data;
        if (sum == 0 && root.left == null && root.right == null)
            return true;
        if (root.left != null)
            ans=ans || pathWithGivenSumExists(root.left, sum);
        if (root.right != null)
            ans=ans || pathWithGivenSumExists(root.right, sum);
        return ans;
    }

    int sumAllElementsBst(Node root) {
        if (root == null)
            return 0;
        int sum=0;
        Queue<Node> list=new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node temp=list.poll();
            sum+=temp.data;
            if (temp.left != null)
                list.add(temp.left);
            if (temp.right != null)
                list.add(temp.right);
        }

        return sum;
    }

    int sumAllElementsBstUsingRecursion(Node root) {
        if (root == null)
            return 0;
        return root.data + sumAllElementsBstUsingRecursion(root.left) + sumAllElementsBstUsingRecursion(root.right);
    }

    Node mirrorOfTree(Node root) {
        if (root == null)
            return null;
        mirrorOfTree(root.left);
        mirrorOfTree(root.right);
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
        return root;

    }

    Node mirrorTreeWithoutRecursion(Node root) {
        if (root == null)
            return root;
        Queue<Node> lst=new LinkedList<>();
        lst.add(root);
        while (!lst.isEmpty()) {
            Node temp=lst.poll();
            Node temp2=temp.left;
            temp.left=temp.right;
            temp.right=temp2;
            if (temp.left != null)
                lst.add(temp.left);
            if (temp.right != null)
                lst.add(temp.right);
        }
        return root;
    }

    boolean chkMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if ((root1 != null && root2 == null) && (root1 == null && root2 != null))
            return false;
        if (root1.data != root2.data)
            return false;
        return chkMirror(root1.left, root2.right) && chkMirror(root1.right, root2.left);

    }

    boolean findPath(Node root, ArrayList<Integer> path, int k) {
        if (root == null)
            return false;
        if (root.data == k)
            path.add(root.data);
        if (root.left != null && findPath(root.left, path, k) || root.right != null && findPath(root.right, path, k))
            return true;

        return false;
    }

    int findLca(Node root, Node a, Node b){
        if(root==null)
            return 0;
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2= new ArrayList<>();
        if(!findPath(root,path1,a.data) || findPath(root, path2, b.data))
            return 0;
        for(int i=0; i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i))
                break;
            return path1.get(i-1);
        }
        return 0;
    }
    Node findLcaSimple(Node root, Node a, Node b){
        if(root==null)
            return root;
        if(root.data==a.data || root.data==b.data)
            return root;
        Node lcaLeft=null, lcaright=null;
        lcaLeft=findLcaSimple(root.left, a,b);
        lcaright=findLcaSimple(root.right,a,b);
        if(lcaLeft!=null && lcaright!=null)
            return root;
        return (lcaLeft!=null) ? lcaLeft: lcaright;
    }
    public static int pIndex=0;
    Node constructBinaryTree(int[] preOrder, int [] inOrder, int iStart, int iEnd){
        if(iStart>iEnd)
            return null;

        Node root=new Node(preOrder[pIndex]);
        pIndex++;
        if(iStart==iEnd)
            return root;
        int index=getInorderIndex(inOrder, iStart,iEnd,root.data );
        root.left=constructBinaryTree(preOrder,inOrder,iStart,index-1);
        root.right=constructBinaryTree(preOrder,inOrder,index+1,iEnd);
        return root;

    }

    int getInorderIndex(int[] inOrder, int iStart, int iEnd, int data){
        for(int i=iStart;i<=iEnd;i++){
            if(inOrder[i]==data)
                return i;
        }
        return -1;
    }
    
}


