import java.util.HashMap;
import java.util.Iterator;

public class WordDictionary {
    private Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        trie.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return trie.searchNodeWildCard(word);
    }
}
class TrieNode {
    // Initialize your data structure here.
    char ch;
    HashMap<Character, TrieNode> children ;
    boolean isLeaf;
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }
    public TrieNode(char c) {
        this();
        this.ch = c;
    }
}
 class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            TrieNode t ;
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;
            if (i == word.length() - 1) {
                t.isLeaf = true;
            }
        }
    }

    public void insertRecursive(TrieNode root, String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        char first = word.charAt(0);
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t;
        if (children.containsKey(first)) {
            t = children.get(first);
        } else {
            t = new TrieNode(first);
            children.put(first, t);
        }
        if (word.length() == 1) {
            t.isLeaf = true;
        } else {
            insertRecursive(t, word.substring(1));
        }

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        if (node != null && node.isLeaf) {
            return true;
        } else {
            return false;
        }
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        if (node != null) {
            return true;
        } else {
            return false;
        }
    }

    private TrieNode searchNode(String word) {
        if (word == null) {
            return null;
        }
        TrieNode t = null;
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else{
                return null;
            }
        }
        return t;

    }

    public boolean searchNodeWildCard(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        return search(root, word);
    }


    private boolean search(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isLeaf;
        }
        char first = word.charAt(0);
        HashMap<Character, TrieNode> children = root.children;
        if (children.containsKey(first)) {
            return search(children.get(first), word.substring(1));
        } else if (first == '.') {
            for (char key: children.keySet()) {
                TrieNode node = children.get(key);
                if (search(node, word.substring(1))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
