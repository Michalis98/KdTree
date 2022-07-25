package kdtree;

public class Kdtree {

	Node root;
	int lvl;

	public void addNode(int x, int y) {
		Node newNode = new Node(x, y);
		lvl = curr_lvl;
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (curr_lvl % 2 == 0) {
					curr_lvl++;
					if (x < focusNode.x) {
						focusNode = focusNode.leftChild;

						if (focusNode == null) {
							parent.leftChild = newNode;
							return;
						}
					} else {
						focusNode = focusNode.rightChild;

						if (focusNode == null) {
							parent.rightChild = newNode;
							return;
						}
					}
				} else if (curr_lvl % 2 == 1) {
					curr_lvl++;
					if (y < focusNode.y) {
						focusNode = focusNode.leftChild;

						if (focusNode == null) {
							parent.leftChild = newNode;
							return;
						}
					} else {
						focusNode = focusNode.rightChild;

						if (focusNode == null) {
							parent.rightChild = newNode;
							return;
						}
					}
				}
			}
		}
	}

	int curr_lvl = 0;

	public Node findNode(int x, int y) {
		lvl = 0;
		curr_lvl = 0;
		Node focusNode = findNode2(root, x, y);
		return focusNode;
	}

	public Node findNode2(Node focusNode, int x, int y) {
		lvl = curr_lvl;
		if (focusNode == null)
			return null;
		if ((focusNode.x == x) && (focusNode.y == y))
			return focusNode;
		if (curr_lvl % 2 == 0) {
			curr_lvl++;
			if (x < focusNode.x) {
				focusNode = findNode2(focusNode.leftChild, x, y);
			} else {
				focusNode = findNode2(focusNode.rightChild, x, y);
			}
		} else {
			curr_lvl++;
			if (y < focusNode.y) {
				focusNode = findNode2(focusNode.leftChild, x, y);
			} else {
				focusNode = findNode2(focusNode.rightChild, x, y);
			}
		}
		return focusNode;
	}
}
