package kdtree;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		
	int TreeSize=100000;
		
	
	Node array2;

	Kdtree theTree = new Kdtree();

	Random smth = new Random();

	for (int i4 = 0; i4 <TreeSize; i4++) {
		theTree.addNode(smth.nextInt(65536), smth.nextInt(65536));
	}

	float sumFailures = 0;
	float numOfFails = 0;
	float SumFind = 0;
	float sumOfFind = 0;

	while ((numOfFails != 100) || (sumOfFind != 100)) {

		int y = smth.nextInt(65536);
		int y1 = smth.nextInt(65536);

		array2 = theTree.findNode(y, y1);

		if ((array2 == null) && (numOfFails != 100)) {
			sumFailures = sumFailures + theTree.lvl;
			numOfFails++;
		}

		if ((array2 != null) && (sumOfFind != 100)) {
			SumFind = SumFind + theTree.lvl;
			sumOfFind++;
		}
	}

	System.out.println(SumFind / 100);
	System.out.println(sumFailures / 100);

	System.out.println("Done");

}
	
}
