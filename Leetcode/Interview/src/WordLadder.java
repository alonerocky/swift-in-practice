import java.util.*;

/**
 * Created by shoulongli on 4/22/16.
 */
public class WordLadder {

    public static void main(String[] argv) {
        WordLadder test = new WordLadder();
        String[] dict = { "hot","dot","dog","lot","log"};
        //System.out.println(test.ladderLength("hit", "cog", new HashSet<String>(Arrays.asList(dict))));
        System.out.println(test.ladderLength("hit", "cog", new HashSet<String>(Arrays.asList(dict))));
        System.out.println(test.ladderLengthIII("hit", "cog", new HashSet<String>(Arrays.asList(dict))));

        //System.out.println(test.findLaddersII("hit", "cog", new HashSet<String>(Arrays.asList(dict))));
        String[] dict2 = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        System.out.println(test.findLadders("qa", "sq", new HashSet<String>(Arrays.asList(dict2))));
        System.out.println(test.findLaddersII("qa", "sq", new HashSet<String>(Arrays.asList(dict2))));

        String[] dict3 = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
        //System.out.println(test.findLadders("cet", "ism", new HashSet<String>(Arrays.asList(dict3))));
        //System.out.println(test.findLaddersII("cet", "ism", new HashSet<String>(Arrays.asList(dict3))));

//        System.out.println(test.ladderLength("cet", "ism", new HashSet<String>(Arrays.asList(dict3))));
//        System.out.println(test.ladderLengthIII("cet", "ism", new HashSet<String>(Arrays.asList(dict3))));
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            return 1;
        }
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        dict.add(start);
        dict.add(end);
        Deque<String> queue = new ArrayDeque<>();
        queue.add(start);
        int level = 1;
        int currentLevel = 1;
        int nextLevel = 0;
        HashSet<String> used = new HashSet<>();
        used.add(start);
        while(!queue.isEmpty()) {
            String front = queue.pollFirst();
            currentLevel--;

            ArrayList<String> neighbors = getNextWords(front, dict);
            for (int i = 0; i < neighbors.size();i++) {
                String next = neighbors.get(i);
                if (next.equals(end)) {
                    return level + 1;
                }
                if (!used.contains(next)) {
                    used.add(next);
                    queue.add(next);
                    nextLevel++;
                }
            }
            if (currentLevel == 0) {
                level++;
                currentLevel = nextLevel;
                nextLevel = 0;
            }

        }
        return 0;

    }


    public int ladderLengthII(String start, String end, Set<String> dict) {
        if (dict == null) {
            return 0;
        }
        long before = System.currentTimeMillis();
        dict.add(start);
        dict.add(end);

        Deque<Ladder> queue = new ArrayDeque<Ladder>();
        Ladder first = new Ladder(start, 1, null);
        queue.addLast(first);
        int len = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Ladder front = queue.pollFirst();
            if (front.len <= len && front.word.equals(end)) {
                len = front.len;
                return len;
            } else if(front.len < len ){
                ArrayList<String> next = getNextWords(front.word, dict);
                for(int i = 0; i < next.size();i++) {
                    String one = next.get(i);
                    boolean used = false;
                    Ladder p = front;
                    while(p != null) {
                        if (p.word.equals(one)) {
                            used = true;
                            break;
                        }
                        p = p.prev;
                    }
                    if (!used) {
                        if (one.equals(end)) {
                            return front.len + 1;
                        } else {
                            Ladder nextLadder = new Ladder(one, front.len + 1, front);
                            queue.add(nextLadder);
                        }
                    }
                }
            }
        }
        return 0;
    }

    //Recommended
    public int ladderLengthIII(String start, String end, Set<String> dict) {
        if (dict == null) {
            return 0;
        }
        long before = System.currentTimeMillis();
        dict.add(start);
        dict.add(end);
        HashSet<String> used = new HashSet<String>();
        Deque<String> queue = new ArrayDeque<>();
        queue.addLast(start);
        used.add(start);
        int level = 1;
        while(!queue.isEmpty()) {
            level++;
            //handle this level
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize;i++) {
                String one = queue.pollFirst();
                ArrayList<String> neighbors = getNextWords(one, dict);
                for (int j = 0; j < neighbors.size();j++) {
                    String next = neighbors.get(j);
                    if (next.equals(end)) {
                        System.out.println("time: " + (System.currentTimeMillis() - before));
                        return level;
                    }
                    if (!used.contains(next)) {
                        queue.addLast(next);
                        used.add(next);
                    }
                }
            }
        }
        return 0;
    }


    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        long before = System.currentTimeMillis();
        List<List<String>> result = new ArrayList<List<String>>();
        wordList.add(beginWord);
        wordList.add(endWord);
        Deque<ArrayList<String>> queue = new ArrayDeque<ArrayList<String>>();
        ArrayList<String> one = new ArrayList<String>();
        one.add(beginWord);
        queue.addLast(one);
        int len = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            ArrayList<String> front = queue.pollFirst();
            String top = front.get(front.size()-1);
            HashSet<String> used = new HashSet<String>(front);
            if (front.size() <= len && top.equals(endWord)) {
                len = front.size();
                result.add(front);
            } else {
                ArrayList<String> next = getNextWords(top, wordList);
                for (int i = 0; i < next.size(); i++) {
                    String word = next.get(i);
                    if (!used.contains(word)) {

                        if (front.size() + 1 <= len && word.equals(endWord)) {
                            len = front.size() + 1;
                            front.add(word);
                            result.add(front);
                        } else if (front.size() + 1 <= len) {
                            ArrayList<String> cloned = (ArrayList<String>)front.clone();
                            cloned.add(word);
                            queue.addLast(cloned);
                        }
                    }
                }
            }

        }
        System.out.println("time: "+ (System.currentTimeMillis() - before));
        return result;
    }

    public ArrayList<String> convertWordLadder(Ladder ladder) {
        Ladder p = ladder;
        ArrayList<String> result = new ArrayList<>();
        while( p != null) {
            result.add(0, p.word);
            p = p.prev;
        }
        return result;
    }
    public List<List<String>> findLaddersII(String beginWord, String endWord, Set<String> wordList) {
        long before = System.currentTimeMillis();
        List<List<String>> result = new ArrayList<List<String>>();
        wordList.add(beginWord);
        wordList.add(endWord);

        Ladder first = new Ladder(beginWord,1, null);
        Deque<Ladder> queue = new ArrayDeque<>();
        queue.addLast(first);
        int len = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            Ladder front = queue.pollFirst();
            if (front.len <= len && front.word.equals(endWord)) {
                len = front.len;
                result.add(convertWordLadder(front));
            } else {
                ArrayList<String> next = getNextWords(front.word, wordList);
                for (int i = 0; i < next.size();i++) {
                    String one = next.get(i);
                    boolean used = false;
                    Ladder p = front;
                    while(p != null) {
                        if (p.word.equals(one)) {
                            used = true;
                            break;
                        }
                        p = p.prev;
                    }
                    if (!used && front.len +1 <= len) {
                        Ladder nextLadder = new Ladder(one, front.len + 1, front);
                        queue.addLast(nextLadder);
                    }
                }
            }
        }
        System.out.println("time: "+ (System.currentTimeMillis() - before));
        return result;
    }

    class Ladder {
        String word;
        int len ;
        Ladder prev;
        public Ladder(String word, int len, Ladder prev) {
            this.word = word;
            this.prev = prev;
            this.len = len;
        }
    }


    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        char[] chars = word.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                //String nextWord = replace(word, i, c);

                char temp = chars[i];
                chars[i] = c;
                String nextWord = new String(chars);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
                chars[i] = temp;
            }
        }
        return nextWords;
    }



}
