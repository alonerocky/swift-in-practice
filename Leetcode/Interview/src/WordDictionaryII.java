public class WordDictionaryII {
    public Trie trie;

    public WordDictionaryII() {
        trie = new Trie();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        trie.addWord(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return trie.wildCardSearch(word);
    }

    public static void main(String[] argv) {
        WordDictionaryII dict = new WordDictionaryII();
        dict.addWord("a");
        System.out.println(dict.search("."));
    }

    class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            root.addWord(word);
        }

        public boolean wildCardSearch(String word) {
            return root.wildCardSearch(word);
        }
    }

    class TrieNode {
        public char ch;
        public boolean isEnd;
        public TrieNode[] children;

        public TrieNode() {

        }

        public TrieNode(char c) {
            this.ch = c;
        }

        public void addWord(String s) {
            if (s == null) {
                return;
            }
            TrieNode p = this;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (p.children == null) {
                    p.children = new TrieNode[26];
                }

                if (p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new TrieNode(c);
                }

                if (i == s.length() - 1) {
                    p.children[c - 'a'].isEnd = true;
                }
                p = p.children[c - 'a'];
            }
        }

        public boolean wildCardSearch(String s) {
            if (s == null) {
                return false;
            } else if (s.length() == 0) {
                return isEnd;
            } else if (children != null) {
                char c = s.charAt(0);

                if (c == '.') {
                    for (int i = 0; i < children.length; i++) {
                        TrieNode child = children[i];
                        if (child != null && child.wildCardSearch(s.substring(1))) {
                            return true;
                        }
                    }
                } else if (children[c - 'a'] != null) {

                    return children[c - 'a'].wildCardSearch(s.substring(1));
                }
            }

            return false;

        }

    }
}