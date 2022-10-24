package cn.linshiyou.algorithm.swordRefersToOffer;

import java.util.*;

/**
 * @Author: LJ
 * @Description: 剑指 Offer II 108. 单词演变
 *
 * 困难：图，bfs
 */
public class zero108 {

    public static void main(String[] args) {

    }

    class Solution {
        Map<String, Integer> wordId = new HashMap<>();
        List<List<Integer>> edge = new ArrayList<>();
        int nodeNum = 0;//结点数量
        

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            for (String word: wordList){
                addEdge(word);
            }
            addEdge(beginWord);
            if (!wordId.containsKey(endWord)) return 0;

            int[] dis = new int[nodeNum];
            Arrays.fill(dis, Integer.MAX_VALUE);

            int beginId = wordId.get(beginWord);
            int endId = wordId.get(endWord);
            dis[beginId] = 0;

            LinkedList<Integer> queue = new LinkedList<>();
            queue.addLast(beginId);

            while (!queue.isEmpty()){
                int x = queue.removeFirst();
                if (x==endId) return dis[endId]/2 + 1;
                for (int it : edge.get(x)){
                    if (dis[it] == Integer.MAX_VALUE){
                        dis[it] = dis[x] + 1;
                        queue.addLast(it);
                    }
                }
            }
            return 0;
        }


        private void addEdge(String word) {
            addWord(word);
            int id1 = wordId.get(word);
            char[] array = word.toCharArray();
            int length = array.length;
            for (int i=0; i<length; i++){
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

        private void addWord(String word) {
            if (!wordId.containsKey(word)){
                wordId.put(word, nodeNum++);;
                edge.add(new ArrayList<>());
            }
        }
    }

}
