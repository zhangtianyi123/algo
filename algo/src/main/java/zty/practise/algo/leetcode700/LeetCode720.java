package zty.practise.algo.leetcode700;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 成功的用两种方式实现了
 * 
 * 一种是排序+set
 * 一种是字典树!
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode720 {

	public static void main(String[] args) {
		LeetCode720 s = new LeetCode720();
		
		s.longestWord(new String[] {"a","banana","app","appl","ap","apply","apple"});
	}
	/**
	 * 排序？
	 * 
	 * 借助 set  
	 * 
	 * 
	 * 方法2： 字典树+dfs深度优先搜索
	 * 
	 * @param words
	 * @return
	 */
	public String longestWord1(String[] words) {
		Arrays.sort(words);
		Set<String> set = new HashSet<>();
		boolean flag = true;
		
		//找符合要求条件下最长的单词 再比较字典序
		//按照提意的字典序必须在相同长度下比较才有意义
		int max = 0;
		String minWord = "a";
		
		for(int i=0; i<words.length; i++) {
			String word = words[i];
			if(word.length() == 1) {
				set.add(word);
				//至少存在一个
				flag = false;
				max = 1;
				minWord = word;
			} 
		}
		
		if(flag) {
			return "";
		}
		
		for(int i=0; i<words.length; i++) { 
			String word = words[i];
			if(word.length() > 1) {
				if(set.contains(word.substring(0, word.length() - 1))) {
					set.add(word);
					if(word.length() > max) {
						max = word.length();
						minWord = word;
					}
					
				}
			}
		}
		
		if(set.size() > 0) {
			for(String word : set) {
				if(word.length() == max) {
					if(word.compareTo(minWord) < 0) {
						minWord = word;
					}
				}
			}
			
			return minWord;
		}
		
		return "";
    }
	
	public String longestWord(String[] words) {
		Trie trie = new Trie();
		
		for(String word : words) {
			trie.insert(word);
		}
		
		//判断一个字符串是不是从根节点到叶子节点的每个节点都是word
		//树的深度优先搜索
		int max = 0;
		String res = "a";
		for(String word : words) {
			if(trie.isWord(word)) {
				if(word.length() > max) {
					max = word.length();
					res = word;
				}
			}
		}
		
		for(String word : words) {
			if(word.length() == max && trie.isWord(word)) {
				if(res.compareTo(word) > 0) {
					res = word;
				}
			}
		}
		
		return res;
	}
	
	/**
	 * 字典树工具类
	 * 
	 * @author zhangtianyi
	 *
	 */
	static class Trie {
		
		Node root = new Node(false, '/', true);
		
		void insert(String word) {
			Node node = root;
			for(int i=0; i<word.length(); i++) {
				Node[] nodes = node.childs;
				if(nodes[word.charAt(i) - 'a'] == null) {
					nodes[word.charAt(i) - 'a'] = new Node(i == word.length()-1, word.charAt(i), i == word.length()-1);
				} else {
					//nodes[word.charAt(i) - 'a'].isWord = i == word.length()-1;
					if(i == word.length()-1)
						nodes[word.charAt(i) - 'a'].isWord = true;
					nodes[word.charAt(i) - 'a'].isLeaf = i == word.length()-1;
				}
				node = nodes[word.charAt(i) - 'a'];
			}
		}
		
		boolean isWord(String word) {
			if(word == null || word == "") {
				return false;
			}
			
			if(word.length() == 1)
				return true;
			
			Node node = root;
			for(int i=0; i<word.length(); i++) {
				Node[] nodes = node.childs;
				if(!nodes[word.charAt(i) - 'a'].isWord)
					return false;
				node = nodes[word.charAt(i) - 'a'];
			}
			
			return true;
		}
	}
	
	static class Node {
		boolean isWord;
		boolean isLeaf;
		char c;
		Node[] childs = new Node[26];
		
		Node(boolean isWord, char c, boolean isLeaf) {
			this.isWord = isWord;
			this.c = c;
			this.isLeaf = isLeaf;
		}
	}
}
