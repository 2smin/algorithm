package programmers;

import java.util.*;

public class PG42892 {

    public static void main(String[] args) {

        PG42892 pg = new PG42892();
        int[][] nodeinfo =
                {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}}
                ;
        pg.solution(nodeinfo);
    }

    static int[] preorderArr;
    static int[] lastorderArr;
    static int idx;

    public int[][] solution(int[][] nodeinfo) {

        preorderArr = new int[nodeinfo.length];
        lastorderArr = new int[nodeinfo.length];

        Queue<Node> nodeQueue = new PriorityQueue<>();
        for(int i=0; i<nodeinfo.length; i++){
            Node node = new Node();
            node.num = i+1;
            node.x = nodeinfo[i][0];
            node.y = nodeinfo[i][1];
            nodeQueue.add(node);
        }

        Node root = nodeQueue.poll();
        while(!nodeQueue.isEmpty()){
            createTree(root, nodeQueue.poll());
        }

        preorder(root);
        idx = 0;
        lastorder(root);

        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preorderArr;
        answer[1] = lastorderArr;
        return answer;
    }

    public void createTree(Node root, Node child){
        if(root.x < child.x){
            if(root.rightChild == null){
                root.rightChild = child;
            }else{
                createTree(root.rightChild,child);
            }
        }else{
            if(root.leftChild == null){
                root.leftChild = child;
            }else{
                createTree(root.leftChild,child);
            }
        }
    }

    public void lastorder(Node node){
        if(node.leftChild != null){
            lastorder(node.leftChild);
        }
        if(node.rightChild != null){
            lastorder(node.rightChild);
        }
        lastorderArr[idx++] = node.num;

    }

    public void preorder(Node node){
        preorderArr[idx++] = node.num;
        if(node.leftChild != null){
            preorder(node.leftChild);
        }
        if(node.rightChild != null){
            preorder(node.rightChild);
        }
    }

    public class Node implements Comparable<Node> {

        public int num;
        public int x;
        public int y;

        public Node parent;
        public Node leftChild;
        public Node rightChild;

        @Override
        public int compareTo(Node o) {
            if(this.y == o.y){
                return this.x - o.x;
            }
            return o.y - this.y;
        }
    }

}
