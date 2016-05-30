class TrieNode {
    // Initialize your data structure here.
    char ch;
    boolean isEnd;
    TrieNode[] children;
    public TrieNode() {

    }
    public TrieNode(char c) {
        this.ch = c;
    }
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return ;
        }
        TrieNode t = root;
        for (int i = 0; i < word.length();i++) {
            char c = word.charAt(i);
            if (t.children == null) {
                t.children = new TrieNode[26];
            }
            int index = c - 'a';
            if (t.children[index] == null) {
                t.children[index] = new TrieNode(c);
            }
            t = t.children[index];
            t.ch = c;
            if (i == word.length() - 1) {
                t.isEnd = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(TrieNode parent, String word) {
        if (word == null || parent == null) {
            return false;
        }
        if (word.length() == 0) {
            return parent.isEnd;
        }
        char c = word.charAt(0);
        int index = c - 'a';
        TrieNode[] children = parent.children;
        if (children == null || children[index] == null) {
            return false;
        }
        return search(children[index], word.substring(1));
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix);
    }
    public boolean startsWith(TrieNode parent, String prefix) {
        if (prefix == null || parent == null) {
            return false;
        }
        if (prefix.length() == 0) {
            return true;
        }
        char c = prefix.charAt(0);
        int index = c - 'a';
        if (parent.children == null || parent.children[index] == null) {
            return false;
        }
        return startsWith(parent.children[index], prefix.substring(1));
    }

    public static void main(String[] argv) {
        Trie trie = new Trie();
        trie.insert("a");
        System.out.println(trie.search("a"));
        System.out.println(trie.startsWith("a"));
    }
}