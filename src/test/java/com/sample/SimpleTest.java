package com.sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleTest {

	public static void main(String... args) throws IOException {
		
		/* Initiate data */
		Node node1 = new Node(new double[]{1, 3}, 1);
        Node node2 = new Node(new double[]{2, 2}, -1);
        Node node3 = new Node(new double[]{1, 2}, -1);
        Node node4 = new Node(new double[]{5, 2}, -1);

        List<Node> sampleNodes = new ArrayList<>();
        sampleNodes.add(node1);
        sampleNodes.add(node2);
        sampleNodes.add(node3);
        sampleNodes.add(node4);

		/* Establish model */
		double[] model = Perceptron.train(sampleNodes);
		
		/* Validation */
		System.out.println(Perceptron.predict(model, new double[]{1, 2}));
		//should be -1
	}
	
}
