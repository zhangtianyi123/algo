package zty.practise.algo.leetcode500;

/**
 * 
 * 递归处理
 * 
 * 深度
 * 
 * 叶子节点（T/F） 与 非叶子节点 叶子节点 与 叶子节点 非叶子节点与非叶子节点
 * 
 * 如果下属的节点全部都是同一个值 应该梳理归并
 * 
 * @author zhangtianyi
 *
 */
public class LeetCode558 {

	public Node intersect(Node quadTree1, Node quadTree2) {
		Node res = null;

		if (quadTree1.isLeaf && !quadTree2.isLeaf) {
			if (quadTree1.val) {
				res = quadTree1;
			} else {
				res = quadTree2;
			}
		} else if (!quadTree1.isLeaf && quadTree2.isLeaf) {
			if (quadTree2.val) {
				res = quadTree2;
			} else {
				res = quadTree1;
			}
		} else if (quadTree1.isLeaf && quadTree2.isLeaf) {
			boolean nodeVal = quadTree1.val | quadTree2.val;
			res = quadTree1;
			res.val = nodeVal;
		} else {
			res = new Node();
			res.isLeaf = false;
			res.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
			res.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
			res.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
			res.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

			// 如果四个节点同时为叶子节点。并且值为true时,则返回的节点进行合并,合并为一个值为true的叶子节点
			if (res.topLeft.isLeaf && res.topRight.isLeaf && res.bottomLeft.isLeaf && res.bottomRight.isLeaf
					&& res.topLeft.val && res.topRight.val && res.bottomLeft.val && res.bottomRight.val) {
				return new Node(true, true, null, null, null, null);
			}
		}

		return res;
	}

}

class Node {
	public boolean val;
	public boolean isLeaf;
	public Node topLeft;
	public Node topRight;
	public Node bottomLeft;
	public Node bottomRight;

	public Node() {
	}

	public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
		val = _val;
		isLeaf = _isLeaf;
		topLeft = _topLeft;
		topRight = _topRight;
		bottomLeft = _bottomLeft;
		bottomRight = _bottomRight;
	}
}