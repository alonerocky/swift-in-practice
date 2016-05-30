import java.util.*;

/**
 * Created by shoulongli on 5/8/16.
 */
public class HuffmanEncoding {

    public static void main(String[] argv) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 5);
        map.put('b', 9);
        map.put('c',12);
        map.put('d', 13);
        map.put('e', 16);
        map.put('f', 45);

        HashMap<Character, Integer> map2 = new HashMap<>();
        map2.put(' ', 7);
        map2.put('a', 4);
        map2.put('e',4);
        map2.put('f', 3);
        map2.put('h', 2);
        map2.put('i', 2);
        map2.put('m', 2);
        map2.put('n', 2);
        map2.put('s', 2);
        map2.put('t', 2);
        map2.put('l', 1);
        map2.put('o', 1);
        map2.put('p', 1);
        map2.put('r', 1);
        map2.put('u', 1);
        map2.put('x', 1);



        HuffmanEncoding test = new HuffmanEncoding(map2);
        System.out.println(test.encodings);
        System.out.println(test.decodings);
        //prstu
        System.out.println(test.huffmanDecode("00001101101010110010111"));

    }
    private HashMap<Character, Integer> table;
    private HuffmanTreeNode root;
    private HashMap<Character, String> encodings ;
    private HashMap<String, Character> decodings;
    public HuffmanEncoding(HashMap<Character, Integer> map) {
        this.table = map;
        root = buildHuffmanTree();
        encodings = new HashMap<>();
        decodings = new HashMap<>();
        huffmanEncode(encodings, decodings);
    }
    private HuffmanTreeNode buildHuffmanTree() {

        if (table.size() == 0) {
            return null;
        } else if (table.size() == 1) {
            root = new HuffmanTreeNode(0);
            Map.Entry<Character, Integer> entry = table.entrySet().iterator().next();
            root.left = new HuffmanTreeNode(entry.getKey(), entry.getValue());
            return root;
        }
        Comparator<HuffmanTreeNode> comparator = new Comparator<HuffmanTreeNode>() {
            @Override
            public int compare(HuffmanTreeNode h1, HuffmanTreeNode h2) {
                return h1.frequency - h2.frequency;
            }
        };
        PriorityQueue<HuffmanTreeNode> minHeap = new PriorityQueue<>(comparator);
        Iterator<Map.Entry<Character, Integer>> iterator = table.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry<Character, Integer> entry = iterator.next();
            HuffmanTreeNode node = new HuffmanTreeNode(entry.getKey(), entry.getValue());
            minHeap.offer(node);
        }

        while(minHeap.size() >= 2) {
            HuffmanTreeNode min1 = minHeap.poll();
            HuffmanTreeNode min2 = minHeap.poll();
            HuffmanTreeNode p = new HuffmanTreeNode(min1.frequency + min2.frequency);
            p.left = min1;
            p.right = min2;
            minHeap.offer(p);
        }
        return minHeap.poll();

    }

    public void huffmanEncode(HashMap<Character, String> encode, HashMap<String, Character> decode) {
        HuffmanTreeNode root = buildHuffmanTree();
        huffmanEncode_helper(root, encode, decode,  "");
    }

    public void huffmanEncode_helper(HuffmanTreeNode root, HashMap<Character, String> encodings, HashMap<String, Character> decodings,  String current) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            encodings.put(root.c, current);
            decodings.put(current, root.c);
        }
        huffmanEncode_helper(root.left, encodings, decodings, current+"0");
        huffmanEncode_helper(root.right, encodings, decodings, current+"1");
    }

    public String huffmanDecode(String encode) {
        HuffmanTreeNode p = root;
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < encode.length();i++) {
            char c = encode.charAt(i);

            if (c == '0') {
                p = p.left;
                if (p.left == null && p.right == null) {
                    sb.append(p.c);
                    //reset p = root;
                    p = root;
                }
            } else if (c == '1') {
                p = p.right;
                if (p.left == null && p.right == null) {
                    sb.append(p.c);
                    //reset p = root;
                    p = root;
                }
            }

        }
        return sb.toString();
    }

    class HuffmanTreeNode {
        int frequency;
        char c;
        HuffmanTreeNode left;
        HuffmanTreeNode right;
        public HuffmanTreeNode(char c, int frequency) {
            this.c = c;
            this.frequency = frequency;
        }

        public HuffmanTreeNode(int frequency) {
            this.frequency = frequency;
        }



    }


}
