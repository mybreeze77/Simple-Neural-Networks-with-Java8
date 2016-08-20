package com.sample;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class AdvancedTest {

	public static void main(String... args) throws IOException {
		
		/* Initiate and shuffle data */
		List<Node> nodes = CSVUtil.convertCsvToNode("iris.csv", 4);
		Collections.shuffle(nodes);
		
		/* Divide samples(70%) and tests(30%) */
		int splitPoint = (int) Math.round(nodes.size() * 0.7);
		List<Node> sampleNodes = nodes.subList(0, splitPoint);
		List<Node> testNodes = nodes.subList(splitPoint + 1, nodes.size() - 1);
		
		/* Establish model */
		double[] model = Perceptron.train(sampleNodes);
		
		/* Validation */
		double count = testNodes
				.stream()
				.filter(node -> Perceptron.predict(model, node.getCharacters()) == node.getLabel()).count();

		System.out.println(count / testNodes.size());
	}
	
}
