package com.jiaflu.leetcode.trie;


/**
 * 题目：实现 Tire（前缀树）
 *实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 *
 * 解答：
 * - 前缀树又称字典树，是一种有序树，用于保存关联数组，其中的键通常是字符串。与二叉查找树不同，键不是直接保存在节点中，而是由节点所在树中的位置决定。一个节点的所有子孙都有相同的前缀，也就是这个节点对应的字符串，而根节点对应空字符串。
 * - Trie 树的节点结构
 *   - Trie 树是一个有根的树，其节点具有以下字段：
 *     - 最多 R 个指向子节点的链接，其中每个链接对应字母表数据集中的一个字母。本文中假定 R 为 26；
 *     - 布尔字段：以指定节点是对应键的结尾还是只是键前缀；
 * - 向 Tire 树中插入键
 *   - 链接存在：沿着链接移动到树的下一个子层，算法继续搜索下一个键字符。
 *   - 链接不存在：创建一个新的节点，并将它与父节点的链接相连，该链接与当前的键字符相匹配。
 *   - 重复以上步骤，直到到达键的最后一个字符，然后将当前节点标记为结束节点，算法完成。
 * - 在 Tire 树中查找键
 *   - 每个键在 trie 中表示为从根到内部节点或叶的路径。我们用第一个键字符从根开始，检查当前节点中与键字符对应的链接。有两种情况：
 *     - 存在链接：则移动到该链接后面路径中的下一个节点，并继续搜索下一个键字符；
 *     - 不存在链接：若已无键字符，且当前结点标记为 `isEnd`，则返回 true。否则有两种可能，均返回 false :
 *       - 还有键字符剩余，但无法跟随 Tire 树种的键路径，找不到键。
 *       - 没有键字符剩余，但当前结点没有标记为 `isEnd`。也就是说，待查找键只是Trie树中另一个键的前缀。
 *
 */
public class $208_Implement_Trie_Prefix_Tree {

    class TrieNode {
        private TrieNode[] links;
        private final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get (char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    private  TrieNode root;
    /** Initialize your data structure here. */
    public $208_Implement_Trie_Prefix_Tree() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }


    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }


}
