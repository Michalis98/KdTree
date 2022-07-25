package kdtree;


public class Node {
	int x;
	int y;

	Node leftChild;
	Node rightChild;

	Node(int x, int y) {

		this.x = x;
		this.y = y;

	}

	public String toString() {
		return x + " " + y;
	}

}
