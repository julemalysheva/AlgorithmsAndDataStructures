package lec4_algorithms;

import java.util.ArrayList;
import java.util.List;

public class SimpleTree {
    private Node root;

    //Алгоритмы обхода дерева
    //Обход в глубину
    public boolean contains(int value){
        if (root != null){
        return contains(value, root);
        } else return false;
    }

    private boolean contains(int value, Node node){
        if (node.value == value){
            return true;
        } else {
            for (Node child: node.children) {
                boolean result = contains(value, child);
                if (result){
                    return true;
                }
            }
        }
        return false;
    }

    //Обход в ширину
    public List<Integer> values(){
        List<Integer> result = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            List<Node> children = new ArrayList<>();
            for (Node node: nodes) {
                result.add(node.value);
                children.addAll(node.children);
            }
            nodes = children;
        }
        return result;
    }

    //красно-черное дерево


    private class Node{
        private int value;
        private List<Node> children;
    }

}
