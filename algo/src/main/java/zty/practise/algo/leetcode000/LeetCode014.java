package zty.practise.algo.leetcode000;


/**
 * 字符串前缀 
 * 
 * 第一反应又是字典树
 * 
 * 举例
 * 
 *    x   x
 *    x
 *    x (isWord / x == null)
 *  x   x
 *  x   x
 *  
 *  还是费了一番功夫自己实现字典树
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode014 {

	public String longestCommonPrefix(String[] strs) {
		Trie trie = new Trie();
		for(String str : strs) {
			if(str == null || str.equals(""))
                return "";
			trie.insert(str);
		}
		
		return trie.findPre();
    }
	
	public static void main(String[] args) {
		LeetCode014 s = new LeetCode014();
		String res = s.longestCommonPrefix(new String[] {"", "b"});
		System.out.println("res=" + res);
	}
	/**
	 * 字典树工具类
	 * 
	 * @author zhangtianyi
	 */
	static class Trie {
		
		Node root = new Node(false, '/', 0);
		
		void insert(String word) {
			Node node = root;
			for(int i=0; i<word.length(); i++) {
				Node[] nodes = node.childs;
				if(nodes[word.charAt(i) - 'a'] == null) {
					node.child++;
					nodes[word.charAt(i) - 'a'] = new Node(i == word.length()-1, word.charAt(i), 0);
				} else {
					if(i == word.length()-1)
						nodes[word.charAt(i) - 'a'].isWord = true;
				}
				node = nodes[word.charAt(i) - 'a'];
			}
		}
		
		String findPre() {
			String res = "";
			
			Node node = root;
			while(true) {
				if(node.child != 1 || node.isWord) {
					if(node.c != '/') {
						res += node.c;
					}
					break;
				}
				if(node.c >= 'a' && node.c <= 'z')
					res += node.c;
				for(Node tmp : node.childs) {
					if(tmp != null) {
						node = tmp;
						break;
					}
				}
				
			}
			
			return res;
		}
	}
	
	static class Node {
		boolean isWord;
		int child;
		char c;
		Node[] childs = new Node[26];
		
		Node(boolean isWord, char c, int child) {
			this.isWord = isWord;
			this.c = c;
			this.child = child;
		}
	}
}
