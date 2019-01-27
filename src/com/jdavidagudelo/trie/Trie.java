package com.jdavidagudelo.trie;


import java.util.HashMap;
import java.util.Map;

public class Trie {

    // trie node
    static class TrieNode
    {
        Map<Character, TrieNode> children = new HashMap<>();

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord = false;

        TrieNode(){
        }
    }

    private static int wordCount(TrieNode root){
        int result = 0;
        if(root.isEndOfWord){
            result += 1;
        }
        for(Character key: root.children.keySet()){
            result += wordCount(root.children.get(key));
        }
        return result;
    }

    private static void display(TrieNode root, StringBuilder sb, int level){
        if(root.isEndOfWord){
            System.out.println(sb.toString());
        }
        for(Character key: root.children.keySet()){
            StringBuilder clone = new StringBuilder(sb.toString());
            clone.append(key);
            display(root.children.get(key), clone, level + 1);
        }
    }

    private static TrieNode root;

    private static boolean isEmpty(TrieNode root){
        return root.children.isEmpty();
    }

    private static TrieNode remove(TrieNode root, String key, int depth){
        if(root == null){
            return null;
        }
        if(depth == key.length()){
            if(root.isEndOfWord){
                root.isEndOfWord = false;
            }
            if(isEmpty(root)){
                root = null;
            }
            return root;
        }
        Character index = key.charAt(depth);
        root.children.put(index, remove(root.children.get(index), key, depth + 1));
        if(isEmpty(root) && !root.isEndOfWord){
            root = null;
        }
        return root;
    }

    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    private static void insert(String key)
    {
        char level;
        int length = key.length();
        Character index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level);
            if (pCrawl.children.get(index) == null) {
                pCrawl.children.put(index, new TrieNode());
            }

            pCrawl = pCrawl.children.get(index);
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    // Returns true if key presents in trie, else false
    private static boolean search(String key)
    {
        int level;
        int length = key.length();
        Character index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++)
        {
            index = key.charAt(level);

            if (pCrawl.children.get(index) == null) {
                return false;
            }
            pCrawl = pCrawl.children.get(index);
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    // Driver
    public static void main(String[] args)
    {
        // Input keys (use only 'a' through 'z' and lower case)
        String[] keys = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String[] output = {"Not present in trie", "Present in trie"};


        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++) {
            insert(keys[i]);
        }

        // Search for different keys
        if(search("the")) {
            System.out.println("the --- " + output[1]);
        }
        else {
            System.out.println("the --- " + output[0]);
        }
        remove(root, "the", 0);

        // Search for different keys
        if(search("the")) {
            System.out.println("the --- " + output[1]);
        }
        else {
            System.out.println("the --- " + output[0]);
        }

        if(search("these")) {
            System.out.println("these --- " + output[1]);
        }
        else {
            System.out.println("these --- " + output[0]);
        }

        if(search("their")) {
            System.out.println("their --- " + output[1]);
        }
        else {
            System.out.println("their --- " + output[0]);
        }

        if(search("thaw")) {
            System.out.println("thaw --- " + output[1]);
        }
        else {
            System.out.println("thaw --- " + output[0]);
        }
        System.out.println();
        display(root, new StringBuilder(), 0);
        System.out.println(wordCount(root));
    }
}
