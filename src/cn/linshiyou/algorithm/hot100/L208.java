package cn.linshiyou.algorithm.hot100;

/**
 * 208. 实现 Trie (前缀树)
 *
 * @author shiyou.lin
 * @date 2023/5/5
 */
public class L208 {

    public static void main(String[] args) {

    }

    class Trie {

        private Trie[] children;
        /**
         * 为了避免出现下面这种错误，所以需要一个isEnd判断当前这个位置是否存下了一个完整的单词
         *
         * courses
         * course
         */
        private boolean isEnd;

        public Trie() {

            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                int index = ch - 'a';

                if (node.children[index]==null){
                    node.children[index] = new Trie();
                }

                node = node.children[index];
            }

            node.isEnd = true;
        }

        public boolean search(String word) {

            Trie node = searchPrefix(word);
            return node != null && node.isEnd;

        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            for (int i=0; i<prefix.length(); i++){
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index]==null){
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }

}
