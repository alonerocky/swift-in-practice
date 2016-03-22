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

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insertII(String word) {
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
    
    public void insert(String word) {
        insert(root, word);
    }
    
    private void insert(TrieNode root, String word) {
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
            insert(t, word.substring(1));
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
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
