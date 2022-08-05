package com.tuya.dameng.fan.queue;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 达蒙
 * @version 1.0
 * @date 2022/8/5 3:17 下午
 *
 * 广度优先搜索
 */
public class BreadthFirstSearch {

    private static class Node{

        private volatile List<Node> nextNodes;

        private Node(List<Node> nextNodes){
            this.nextNodes = nextNodes;
        }

        public Node(){
        }
    }


    /**
     * Return the length of the shortest path between root and target node.
     */
    int bfs(Node root, Node target) {
        // store all nodes which are waiting to be processed
        Queue<Node> queue = new LinkedBlockingQueue<>();
        // number of steps neeeded from root to current node
        int step = 0;
        // initialize
        queue.offer(root);
        // BFS
        while (!queue.isEmpty()) {
            step++;
            // iterate the nodes which are already in the queue
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node cur = queue.poll();
                if (target == cur){return step;}
                if (cur.nextNodes != null){
                    for (Node nextNode : cur.nextNodes) {
                        queue.offer(nextNode);
                    }
                }
            }
        }
        return -1;          // there is no path from root to target
    }


    public static void main(String[] args) {
        Node sourceNode = new Node();

        Node node101 = new Node();
        Node node102 = new Node();
        Node node103 = new Node();
        sourceNode.nextNodes = Lists.newArrayList(node101, node102, node103);


        Node node201 = new Node();
        Node node202 = new Node();
        Node node203 = new Node();
        node101.nextNodes = Lists.newArrayList(node201);

        node102.nextNodes = Lists.newArrayList(node202);

        node103.nextNodes = Lists.newArrayList(node203);

        Node node301 = new Node();
        Node node302 = new Node();
        Node node303 = new Node();
        node201.nextNodes = Lists.newArrayList(node301);

        node202.nextNodes = Lists.newArrayList(node302);

        node203.nextNodes = Lists.newArrayList(node303);



        Node node401 = new Node();
        Node node402 = new Node();
        node301.nextNodes = Lists.newArrayList(node401);

        node302.nextNodes = Lists.newArrayList(node402);

        BreadthFirstSearch search = new BreadthFirstSearch();
        System.out.println(search.bfs(sourceNode, node402));
    }





}
