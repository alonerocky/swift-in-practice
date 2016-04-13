public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insertI(String word) {
        insert(word, root);
    }
    //recursive
    public void insert(String word, TrieNode root) {
        if (word == null || word.length() == 0 ) {
            return;
        }
        if (root.children == null) {
            root.children = new TrieNode[26]; //a-z
        }
        char c = word.charAt(0);
        if (root.children[c-'a'] == null) {
            root.children[c-'a'] = new TrieNode(c);
        }
        if (word.length() == 1) {
            root.children[c-'a'].isEnd = true;
            return;
        }
        insert(word.substring(1), root.children[c-'a']);
    }
    
    //non recursive
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            if (p.children == null) {
                p.children = new TrieNode[26];
            }
            char c = word.charAt(i);
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new TrieNode(c);
            }
            if (i == word.length() - 1) {
                p.children[c - 'a'].isEnd = true;
            }
            p = p.children[c - 'a'];
            
        }
        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = search(word, root);
        return p != null && p.isEnd == true;
    }
     
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return search(prefix, root) != null;
    }
    
    //non recursive
    private TrieNode searchI(String word, TrieNode root) {
        if (word == null) {
            return null;
        }
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.children == null || p.children[c - 'a'] == null) {
                return null;
            }
            p = p.children[c - 'a'];
            
        }
        return p;
    }
    private TrieNode search(String word, TrieNode root) {
        if (word == null) {
            return null;
        }
        if (word.length() == 0) {
            return root;
        }
        char c = word.charAt(0);
        if (root.children == null || root.children[c-'a'] == null) {
            return null;
        }
        return search(word.substring(1), root.children[c-'a']);
    }
     
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
