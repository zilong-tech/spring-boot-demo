package com.demo.web.java;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LFUCache<K, V> {

    /**
     * 容量限制
     */
    private int capacity;

    /**
     * 当前最小使用次数
     */
    private int minUsedCount;

    /**
     * key和数据的映射
     */
    private Map<K, Node> map;
    /**
     * 数据频率和对应数据组成的链表
     */
    private Map<Integer, List<Node>> usedCountMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minUsedCount = 1;
        this.map = new HashMap<>();
        this.usedCountMap = new HashMap<>();
    }

    public V get(K key) {

        Node node = map.get(key);
        if (node == null) {
            return null;
        }
        // 增加数据的访问频率
        addUsedCount(node);
        return node.value;
    }

    public V put(K key, V value) {
        Node node = map.get(key);
        if (node != null) {
            // 如果存在则增加该数据的访问频次
            V oldValue = node.value;
            node.value = value;
            addUsedCount(node);
            return oldValue;
        } else {
            // 数据不存在，判断链表是否满
            if (map.size() == capacity) {
                // 如果满，则删除队首节点，更新哈希表
                List<Node> list = usedCountMap.get(minUsedCount);
                Node delNode = list.get(0);
                list.remove(delNode);
                map.remove(delNode.key);
            }
            // 新增数据并放到数据频率为1的数据链表中
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            List<Node> list = usedCountMap.get(1);
            if (list == null) {
                list = new LinkedList<>();
                usedCountMap.put(1, list);
            }

            list.add(newNode);
            minUsedCount = 1;
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LfuCache{");
        List<Integer> usedCountList = this.usedCountMap.keySet().stream().collect(Collectors.toList());
        usedCountList.sort(Comparator.comparingInt(i -> i));
        int count = 0;
        for (int usedCount : usedCountList) {
            List<Node> list = this.usedCountMap.get(usedCount);
            if (list == null) {
                continue;
            }
            for (Node node : list) {
                if (count > 0) {
                    sb.append(',').append(' ');
                }
                sb.append(node.key);
                sb.append('=');
                sb.append(node.value);
                sb.append("(UsedCount:");
                sb.append(node.usedCount);
                sb.append(')');
                count++;
            }
        }
        return sb.append('}').toString();
    }

    private void addUsedCount(Node node) {
        List<Node> oldList = usedCountMap.get(node.usedCount);
        oldList.remove(node);

        // 更新最小数据频率
        if (minUsedCount == node.usedCount && oldList.isEmpty()) {
            minUsedCount++;
        }

        node.usedCount++;
        List<Node> set = usedCountMap.get(node.usedCount);
        if (set == null) {
            set = new LinkedList<>();
            usedCountMap.put(node.usedCount, set);
        }
        set.add(node);
    }

    class Node {

        K key;
        V value;
        int usedCount = 1;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        LFUCache<String, String> cache = new LFUCache(3);
        cache.put("keyA", "valueA");
        System.out.println("put keyA");
        System.out.println(cache);
        System.out.println("=========================");

        cache.put("keyB", "valueB");
        System.out.println("put keyB");
        System.out.println(cache);
        System.out.println("=========================");

        cache.put("keyC", "valueC");
        System.out.println("put keyC");
        System.out.println(cache);
        System.out.println("=========================");

        cache.get("keyA");
        System.out.println("get keyA");
        System.out.println(cache);
        System.out.println("=========================");

        cache.put("keyD", "valueD");
        System.out.println("put keyD");
        System.out.println(cache);
    }
}