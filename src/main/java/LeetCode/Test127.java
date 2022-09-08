package LeetCode;

import java.util.*;

public class Test127 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        Solution127 solution = new Solution127();
        int result = solution.ladderLength("hit", "cog", list);
        System.out.println(result);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        List<List<String>> resultList = new LinkedList<List<String>>();
        resultList.add(Collections.singletonList(beginWord));

        List<Integer> countList = new ArrayList<>();

        getLadderLength(resultList, wordList, endWord, countList);

        if (countList.isEmpty()) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int count : countList) {
            if (count < result) {
                result = count;
            }
        }
        return result;
    }

    private static void getLadderLength(List<List<String>> resultList, List<String> wordList, String endWord, List<Integer> countList) {
        if (wordList.isEmpty()) {
            return;
        }

        List<List<String>> resultListTemp = new ArrayList<>();
        resultListTemp.addAll(resultList);

        List<String> wordListTemp = new ArrayList<>();
        wordListTemp.addAll(wordList);

        List<String> lastList = resultListTemp.get(resultListTemp.size() - 1);
        for (String lastWord : lastList) {
            List<String> nextWordList = findNextWord(lastWord, wordListTemp);
            if (nextWordList.isEmpty()) {
                continue;
            }
            if (nextWordList.contains(endWord)) {
                countList.add(resultListTemp.size()+1);
                continue;
            }
            List<List<String>> resultListTempTemp = new ArrayList<>();
            resultListTempTemp.addAll(resultListTemp);
            resultListTempTemp.add(nextWordList);
            getLadderLength(resultListTempTemp, wordListTemp, endWord, countList);
        }
    }


    public static List<String> findNextWord(String targetWord, List<String> wordList) {
        wordList.remove(targetWord);
        List<String> nextWordList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        char[] targetWordChars = targetWord.toCharArray();
        for (String word : wordList) {
            char[] wordChars = word.toCharArray();
            if (targetWordChars.length != wordChars.length) {
                set.add(word);
                continue;
            }
            int count = 0;
            for (int i = 0; i < targetWordChars.length; i++) {
                if (targetWordChars[i] != wordChars[i]) {
                    count += 1;
                }
            }
            if (count == 1) {
                nextWordList.add(word);
                set.add(word);
            }
        }

        for (String repeatWord : set) {
            wordList.remove(repeatWord);
        }

        return nextWordList;
    }
}
//========================================================================================
class Solution127wd {
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] disBegin = new int[nodeNum];
        Arrays.fill(disBegin, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord);
        disBegin[beginId] = 0;
        Queue<Integer> queueBegin = new LinkedList<>();
        queueBegin.offer(beginId);


        int[] disEnd = new int[nodeNum];
        Arrays.fill(disEnd, Integer.MAX_VALUE);
        int endId = wordId.get(endWord);
        disEnd[endId] = 0;
        Queue<Integer> queueEnd = new LinkedList<>();
        queueEnd.offer(endId);

        while (!queueBegin.isEmpty() && !queueEnd.isEmpty()) {
            int queueBeginSize = queueBegin.size();
            for (int i = 0; i < queueBeginSize; i++) {
                int curBeginId = queueBegin.poll();
                if (disEnd[curBeginId] != Integer.MAX_VALUE) {
                    return (disBegin[curBeginId] + disEnd[curBeginId]) / 2 + 1;
                }
                for (int nextBeginId : edge.get(curBeginId)) {
                    if (disBegin[nextBeginId] == Integer.MAX_VALUE) {
                        disBegin[nextBeginId] = disBegin[curBeginId] + 1;
                        queueBegin.offer(nextBeginId);
                    }
                }
            }

            int queueEndSize = queueEnd.size();
            for (int i = 0; i < queueEndSize; i++) {
                int curEndId = queueEnd.poll();
                if (disBegin[curEndId] != Integer.MAX_VALUE) {
                    return (disBegin[curEndId] + disEnd[curEndId]) / 2 + 1;
                }
                for (int nextEndId : edge.get(curEndId)) {
                    if (disEnd[nextEndId] == Integer.MAX_VALUE) {
                        disEnd[nextEndId] = disEnd[curEndId] + 1;
                        queueEnd.offer(nextEndId);
                    }
                }
            }
        }
        return 0;
    }

    private void addEdge(String word) {
        addWord(word);
        int mainId = wordId.get(word);
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < wordChar.length; i++) {
            char wordCharTemp = wordChar[i];
            wordChar[i] = '*';
            String wordTemp = String.valueOf(wordChar);
            addWord(wordTemp);
            int tempId = wordId.get(wordTemp);
            edge.get(tempId).add(mainId);
            edge.get(mainId).add(tempId);
            wordChar[i] = wordCharTemp;
        }
    }

    private void addWord (String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<>());
        }
    }
}
















//========================================================================================
class Solution1272 {
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }

        int[] disBegin = new int[nodeNum];
        Arrays.fill(disBegin, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord);
        disBegin[beginId] = 0;
        Queue<Integer> queBegin = new LinkedList<Integer>();
        queBegin.offer(beginId);

        int[] disEnd = new int[nodeNum];
        Arrays.fill(disEnd, Integer.MAX_VALUE);
        int endId = wordId.get(endWord);
        disEnd[endId] = 0;
        Queue<Integer> queEnd = new LinkedList<Integer>();
        queEnd.offer(endId);

        while (!queBegin.isEmpty() && !queEnd.isEmpty()) {
            int queBeginSize = queBegin.size();
            for (int i = 0; i < queBeginSize; ++i) {
                int nodeBegin = queBegin.poll();
                if (disEnd[nodeBegin] != Integer.MAX_VALUE) {
                    return (disBegin[nodeBegin] + disEnd[nodeBegin]) / 2 + 1;
                }
                for (int it : edge.get(nodeBegin)) {
                    if (disBegin[it] == Integer.MAX_VALUE) {
                        disBegin[it] = disBegin[nodeBegin] + 1;
                        queBegin.offer(it);
                    }
                }
            }

            int queEndSize = queEnd.size();
            for (int i = 0; i < queEndSize; ++i) {
                int nodeEnd = queEnd.poll();
                if (disBegin[nodeEnd] != Integer.MAX_VALUE) {
                    return (disBegin[nodeEnd] + disEnd[nodeEnd]) / 2 + 1;
                }
                for (int it : edge.get(nodeEnd)) {
                    if (disEnd[it] == Integer.MAX_VALUE) {
                        disEnd[it] = disEnd[nodeEnd] + 1;
                        queEnd.offer(it);
                    }
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }
}

//========================================================================================
class Solution127 {
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(beginId);
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }
            List<Integer> edgeList = edge.get(x);
            for (int it : edgeList) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }
}
