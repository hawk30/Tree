package com.company;

import com.sun.xml.internal.bind.v2.util.QNameMap;

import java.util.*;

/**
 * Created by gaurav on 19/3/17.
 */
public class BinaryTree {


    public static int pIndex = 0;
    public Node root;

    //1. find max depth of left subtree
    //2. find max depth of right subtree
    //3. find max among them
    int maxDepth(Node root) {
        if (root == null)
            return -1;

        int hLeft = maxDepth(root.left);
        int hRight = maxDepth(root.right);
        if (hLeft > hRight)
            return 1 + hLeft;
        else
            return
                    1 + hRight;

    }
    // max element using recursion:
    //1. compare the values of root, it's left subtree and it's right sub tree
    //2. find max among them
    //3. do this recursively for all the nodes
    int maxElement(Node root) {
        if (root == null)
            return -1;
        int maxLeft = 0;
        int maxRight = 0;
        int rootVal = root.data;
        maxLeft = maxElement(root.left);
        maxRight = maxElement(root.right);
        if (maxLeft > rootVal)
           rootVal=maxLeft;
        if(maxRight>rootVal)
            rootVal=maxRight;
        return rootVal;


    }

    int maxElementWithoutRecursion(Node root) {
        if(root==null)
            return -1;
        Queue<Node> queue= new LinkedList<>();
        queue.add(root);
        int max= Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            Node temp=queue.poll();
            if(temp.data>max)
                max=temp.data;
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
        return max;
    }

    boolean searchElement(Node root, int k) {
        if (root == null)
            return false;
        Queue<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node temp = list.poll();
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

    //1. compare element with the root
    //2. if it's not equal, compare with it's left child and right child
    //3. do this recursilvely for all nodes
    boolean searchElementUsingRecursion(Node root, int k) {
        if (root == null)
            return false;
        if (k == root.data)
            return true;
        else
            return searchElementUsingRecursion(root.left, k) || searchElementUsingRecursion(root.right, k);

    }

    //1. find the 1st null left/ right child
    //2. insert there
    void insertElement(Node root, int k) {

        Node newNode = new Node(k);
        newNode.left = null;
        newNode.right = null;
        newNode.data=k;
        if (root == null)
            root = newNode;
        Queue<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node temp = list.poll();
            if (temp.left != null)
                list.add(temp.left);
            else
                temp.left = newNode;
            if (temp.right != null)
                list.add(temp.right);
            else
                temp.right = newNode;
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
        int count = 0;
        Queue<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            count++;
            Node temp = list.poll();
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
        root = null;
    }

    void leverOrder(Node root) {
        if (root == null) return;
        Queue<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node temp = list.poll();
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
        Queue<Node> list = new LinkedList<>();
        Stack<Node> stk = new Stack<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node temp = list.poll();
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
        int hLeft = 0, hRight = 0;
        hLeft = heightBst(root.left);
        hRight = heightBst(root.right);
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
        Queue<Node> list = new LinkedList<>();
        list.add(root);
        list.add(null);
        int level = 1;
        while (!list.isEmpty()) {
            Node temp = list.poll();
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
        Queue<Node> list = new LinkedList<>();
        list.add(root);
        Node temp = null;
        while (!list.isEmpty()) {
            temp = list.poll();
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
            root.left = deleteElement(root.left, k);
        else if (k > root.data)
            root.right = deleteElement(root.right, k);
        else {
            if (root.left != null && root.right != null) {
                Node temp = root;
                Node minElementRight = minimumElement(root.right);
                root.data = minElementRight.data;
                deleteElement(root.right, minElementRight.data);
            } else if (root.left != null)
                root = root.left;
            else if (root.right != null)
                root = root.right;
            else
                root = null;
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
        Queue<Node> list = new LinkedList<>();
        list.add(root);
        int countLeaves = 0;
        while (!list.isEmpty()) {
            Node temp = list.poll();
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
        Queue<Node> list = new LinkedList<>();
        list.add(root);
        int countFullNodes = 0;
        while (!list.isEmpty()) {
            Node temp = list.poll();
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
        int hLeft = 0, hright = 0, dLeft = 0, dRight = 0;
        hLeft = diameter(root.left);
        hright = diameter(root.right);
        dLeft = diameter(root.left);
        dRight = diameter(root.right);
        return Math.max((hLeft + hright + 1), Math.max(dLeft, dRight));
    }

    int levelWithMaxSum(Node root) {
        if (root == null)
            return 0;
        Queue<Node> list = new LinkedList<>();
        list.add(root);
        list.add(null);

        int maxLevel = 0, level = 0;
        int currSum = 0, maxSum = 0;

        while (!list.isEmpty()) {

            Node temp = list.poll();

            if (temp == null) {
                if (currSum > maxSum) {
                    maxSum = currSum;
                    maxLevel = level;

                }
                currSum = 0;

                if (!list.isEmpty())
                    list.add(null);
                level++;
            } else {
                currSum += temp.data;
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
        ArrayList<Integer> path = new ArrayList<>();
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
        boolean ans = false;
        if (root == null)
            return false;
        sum -= root.data;
        if (sum == 0 && root.left == null && root.right == null)
            return true;
        if (root.left != null)
            ans = ans || pathWithGivenSumExists(root.left, sum);
        if (root.right != null)
            ans = ans || pathWithGivenSumExists(root.right, sum);
        return ans;
    }

    int sumAllElementsBst(Node root) {
        if (root == null)
            return 0;
        int sum = 0;
        Queue<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node temp = list.poll();
            sum += temp.data;
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
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;

    }

    Node mirrorTreeWithoutRecursion(Node root) {
        if (root == null)
            return root;
        Queue<Node> lst = new LinkedList<>();
        lst.add(root);
        while (!lst.isEmpty()) {
            Node temp = lst.poll();
            Node temp2 = temp.left;
            temp.left = temp.right;
            temp.right = temp2;
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

    int findLca(Node root, Node a, Node b) {
        if (root == null)
            return 0;
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        if (!findPath(root, path1, a.data) || findPath(root, path2, b.data))
            return 0;
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i))
                break;
            return path1.get(i - 1);
        }
        return 0;
    }

    Node findLcaSimple(Node root, Node a, Node b) {
        if (root == null)
            return root;
        if (root.data == a.data || root.data == b.data)
            return root;
        Node lcaLeft = null, lcaright = null;
        lcaLeft = findLcaSimple(root.left, a, b);
        lcaright = findLcaSimple(root.right, a, b);
        if (lcaLeft != null && lcaright != null)
            return root;
        return (lcaLeft != null) ? lcaLeft : lcaright;
    }

    Node constructBinaryTree(int[] preOrder, int[] inOrder, int iStart, int iEnd) {
        if (iStart > iEnd)
            return null;

        Node root = new Node(preOrder[pIndex]);
        pIndex++;
        if (iStart == iEnd)
            return root;
        int index = getInorderIndex(inOrder, iStart, iEnd, root.data);
        root.left = constructBinaryTree(preOrder, inOrder, iStart, index - 1);
        root.right = constructBinaryTree(preOrder, inOrder, index + 1, iEnd);
        return root;

    }

    int getInorderIndex(int[] inOrder, int iStart, int iEnd, int data) {
        for (int i = iStart; i <= iEnd; i++) {
            if (inOrder[i] == data)
                return i;
        }
        return -1;
    }

    boolean ancestorOfNode(Node root, int data) {
        if (root == null)
            return false;
        if (root.data == data)
            return true;
        if (ancestorOfNode(root.left, data) || ancestorOfNode(root.right, data)) {
            System.out.print(root.data);
            return true;
        }
        return false;

    }

    void zigzagTraversalBst(Node root) {
        if (root == null)
            return;
        Stack<Node> currLevel = new Stack<Node>();
        Stack<Node> nextLevel = new Stack<Node>();
        boolean left2right = true;
        currLevel.add(root);
        while (!currLevel.isEmpty()) {
            Node temp = currLevel.pop();
            System.out.print(temp.data + " ");

            if (left2right) {
                if (temp.left != null)
                    nextLevel.push(temp.left);
                if (temp.right != null)
                    nextLevel.push(temp.right);
            } else {
                if (temp.right != null)
                    nextLevel.push(temp.right);
                if (temp.left != null)
                    nextLevel.push(temp.left);
            }
            if (currLevel.isEmpty()) {
                left2right = !left2right;
                currLevel = nextLevel;
                nextLevel = new Stack<Node>();
            }
        }

    }

    void printingTreeInReverseOrder(Node root) {
        if (root == null)
            return;
        Queue<Node> lst = new LinkedList<>();
        Stack<Node> stk = new Stack<>();
        lst.add(root);
        while (!lst.isEmpty()) {
            Node temp = lst.poll();
            stk.push(temp);
            if (temp.left != null)
                lst.add(temp.left);
            if (temp.right != null)
                lst.add(temp.right);
        }
        while (!stk.isEmpty())
            System.out.print(stk.pop().data);
    }

    void reverseZigZag(Node root) {
        if (root == null)
            return;
        Stack<Node> curr = new Stack<>();
        Stack<Node> next = new Stack<>();
        Stack<Node> reverse = new Stack<>();
        curr.push(root);
        boolean left2right = true;
        while (!curr.isEmpty()) {
            Node temp = curr.pop();
            reverse.push(temp);
            if (left2right) {
                if (temp.left != null)
                    next.push(temp.left);
                if (temp.right != null)
                    next.push(temp.right);

            } else {
                if (temp.right != null)
                    next.push(temp.right);
                if (temp.left != null)
                    next.push(temp.left);
            }
            if (curr.isEmpty()) {
                left2right = !left2right;
                curr = next;
                next = new Stack<>();
            }

        }
        while (!reverse.isEmpty())
            System.out.print(reverse.pop().data);
    }

    void verticalSUmBinaryTree(Node root) {
        if (root == null)
            return;
        HashMap<Integer, Integer> map = new HashMap<>();
        int hd = 0;
        verticalSUmBinaryTreeUtils(root, map, hd);
        if (map.entrySet() != null)
            System.out.println(map.entrySet());

    }

    void verticalSUmBinaryTreeUtils(Node root, HashMap<Integer, Integer> map, int hd) {
        if (root == null)
            return;
        verticalSUmBinaryTreeUtils(root.left, map, hd - 1);
        int prevSum = (map.get(hd) == null) ? 0 : map.get(hd);
        map.put(hd, prevSum + root.data);
        verticalSUmBinaryTreeUtils(root.right, map, hd + 1);
    }

    int noOfTreesWithNNodes(int n) {
        if (n <= 0)
            return -1;
        return (int) Math.pow(2, n) - n;
    }

    Node giverPreOrderTraversal(int[] preOrder, int i) {
        //leaf nodes are represented by 'L' and internal nodes are represented by 'I;
        // further each node can have either 2 children or 0 child
        //i.e if a node has 1 child then it's sibling also exists
        if (preOrder == null)
            return null;
        Node newNode = new Node(preOrder[i]);
        newNode.left = null;
        newNode.right = null;
        if (preOrder[i] == 'L')
            return newNode;
        i += 1;
        newNode.left = giverPreOrderTraversal(preOrder, i);
        i += 1;
        newNode.right = giverPreOrderTraversal(preOrder, i);
        return newNode;
    }

    void verticalOrderTraversal(Node root) {
        if (root == null)
            return;
        TreeMap<Integer, String> map = new TreeMap<>();
        int hd = 0;
        verticalOrderTraversalUtils(root, map, hd);
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


    void verticalOrderTraversalUtils(Node root, TreeMap<Integer, String> map, int hd) {
        if (root == null)
            return;


        if (map.get(hd) == null)
            map.put(hd, String.valueOf(root.data));
        else
            map.put(hd, String.valueOf(root.data + map.get(hd)));
        verticalOrderTraversalUtils(root.left, map, hd - 1);
        verticalOrderTraversalUtils(root.right, map, hd + 1);

    }

    void InOredrWithoutRecursion(Node root) {
        if (root == null)
            return;
        Stack<Node> stk = new Stack<Node>();
        while (true) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            while (stk.isEmpty())
                return;
            root = stk.pop();
            System.out.print(root.data + " ");
            root=root.right;
        }

    }
    void preOrderTraversalWithoutRecursion(Node root){
        if(root==null)
            return;
        Stack<Node> stk= new Stack<>();
        while (true){
            while(root!=null){
                System.out.print(root.data+" ");
                stk.push(root);
                root=root.left;
            }
            if(stk.isEmpty())
                return;
            root=stk.pop();
            root=root.right;
        }
    }
    void postOrderTraversalWithoutRecursion(Node root){
        if(root==null)
            return;
        Stack<Node> stk1= new Stack<>();
        Stack<Node> stk2= new Stack<>();
        stk1.push(root);
        while(!stk1.isEmpty()){
            stk2.push(stk1.pop());
            stk1.push(root.left);
            stk1.push(root.right);

        }
        while(!stk2.isEmpty())
            System.out.print(stk2.pop().data);
    }
}



