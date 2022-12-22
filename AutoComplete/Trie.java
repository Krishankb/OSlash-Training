package org.example;

import java.util.*;

public class Trie {

    public class TrieNode {
        Map<Character, TrieNode> children;
        char c;
        boolean isWord;

        public TrieNode(char c) {
            this.c = c;
            children = new HashMap<>();
        }

        public TrieNode() {
            children = new HashMap<>();
        }

        public void insert(String word) {
            if (word == null || word.isEmpty())
                return;
            char firstChar = word.charAt(0);
            TrieNode child = children.get(firstChar);
            if (child == null) {
                child = new TrieNode(firstChar);
                children.put(firstChar, child);
            }

            if (word.length() > 1)
                child.insert(word.substring(1));
            else
                child.isWord = true;
        }

    }

    TrieNode root;

    public Trie(List<String> words) {
        root = new TrieNode();
        for (String word : words)
            root.insert(word);

    }

    public boolean find(String prefix, boolean exact) {
        TrieNode lastNode = root;
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.children.get(c);
            if (lastNode == null)
                return false;
        }
        return !exact || lastNode.isWord;
    }

    public boolean find(String prefix) {
        return find(prefix, false);
    }

    public void suggestHelper(TrieNode root, List<String> list, StringBuffer curr) {
        if (root.isWord) {
            list.add(curr.toString());
        }

        if (root.children == null || root.children.isEmpty())
            return;

        for (TrieNode child : root.children.values()) {
            suggestHelper(child, list, curr.append(child.c));
            curr.setLength(curr.length() - 1);
        }
    }

    public List<String> suggest(String prefix) {
        List<String> list = new ArrayList<>();
        TrieNode lastNode = root;
        StringBuffer curr = new StringBuffer();
        for (char c : prefix.toCharArray()) {
            lastNode = lastNode.children.get(c);
            if (lastNode == null)
                return list;
            curr.append(c);
        }
        suggestHelper(lastNode, list, curr);
        return list;
    }


    public static void main(String[] args) {
        List<String> words = List.of("geeks",   "laptop",   "knowledge", "art",    "portal",
                "to",      "learn", "cannopy",   "best",   "computer","composter","compute",
                "science", "zoom",  "yuppy",   "fire", "ice",
                "being",      "data",  "gold","time","has","look","two","more","write","go","see","number","no","way","could","people","my","than","first","water","been","call","who","oil","its","now","find","long","down","day","did","get","come","made","may","part" );
        Trie trie = new Trie(words);

        List<String> sa = new ArrayList<String>();
        System.out.println("Enter the word: ");
        Scanner sc = new Scanner(System.in);
        String userInput =  sc.nextLine();
        for (int i = 0;i<words.size();i++) {
            if (words.get(i).contains(userInput) ) {
                sa.add(words.get(i));
                System.out.println(words.get(i));
            }
        }
        System.out.println(sa);
        System.out.println(trie.suggest(userInput));
        //System.out.println(trie.suggest("o"));
    }

}
