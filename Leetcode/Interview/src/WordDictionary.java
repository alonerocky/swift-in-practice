import java.util.HashMap;
import java.util.Iterator;

public class WordDictionary {
    private Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        trie.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return trie.search(word);
    }

    public static void main(String[] argv) {
        WordDictionary w = new WordDictionary();
        w.addWord("a");
        System.out.println(w.search("."));
    }


    class TrieNode {
        char ch;
        boolean isEnd;
        TrieNode[] children;
        public TrieNode() {}
        public TrieNode(char c) {
            this.ch = c;
        }

    }
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (p.children == null) {
                    p.children = new TrieNode[26];
                }
                if (p.children[c-'a'] == null) {
                    p.children[c-'a'] = new TrieNode(c);
                }
                if (i == word.length() - 1) {
                    p.children[c-'a'].isEnd = true;
                }
                p = p.children[c-'a'];
            }
        }
        public boolean search(String word) {
            return search(root, word);
        }
        public boolean search(TrieNode r, String word) {
            if (word == null || r == null) {
                return false;
            } else if (word.length() == 0) {
                return root.isEnd;
            }
            char first = word.charAt(0);
            if (first == '.') {
                if (r.children == null) {
                    return false;
                }
                for (char c = 'a'; c <= 'z'; c++) {
                    if (r.children[c-'a'] != null &&
                            search(r.children[c-'a'], word.substring(1))) {
                        return true;
                    }
                }

            } else {
                if (r.children == null) {
                    return false;
                }
                if (r.children[first-'a'] == null) {
                    return false;
                }
                return search(r.children[first-'a'], word.substring(1));
            }
            return false;
        }
    }
}