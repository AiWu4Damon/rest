package com.tuya.dameng.fan.queue;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * @author 达蒙
 * @version 1.0
 * @date 2022/8/5 5:07 下午
 */
public class DepthFirstSearch {
    
    private volatile int count = 0;

    private static class Node{

        private volatile List<Node> nextNodes;

        private Node(List<Node> nextNodes){
            this.nextNodes = nextNodes;
        }

        public Node(){
        }

        @Override
        public boolean equals(Object o) {
            return this == o;
        }

        @Override
        public int hashCode() {
            return Objects.hash(nextNodes);
        }
    }

    void dfs(Node root, Node target, Stack<Node> stack, Set<Node> setNode){

        stack.push(root);

        if (root.nextNodes == null){return;}
        for (Node nextNode : root.nextNodes) {
            if (setNode.contains(nextNode)){
                break;
            }else {
                setNode.add(nextNode);
            }
            if (nextNode == target){
                count++;
            }
            dfs(nextNode, target, stack, setNode);
        }
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
        node101.nextNodes = Lists.newArrayList(node201, node202);

        node102.nextNodes = Lists.newArrayList(node202, node203);

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
        
        
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();

        depthFirstSearch.dfs(sourceNode, node303, new Stack<>(), new HashSet<>());

        System.out.println("计算的数量：" + depthFirstSearch.count);
    }
}
