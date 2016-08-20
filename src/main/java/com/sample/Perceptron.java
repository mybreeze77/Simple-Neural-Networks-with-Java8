package com.sample;

import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Perceptron {
	private static final double x0 = 1;
    private static final double eta = 1;
    private static final int maxTryTimes = 100;

    private static int activationFunction(double input) {
        return input >= 0 ? 1 : -1;
    }

    private static double calculateSigma(double[] inputs, double[] weights) {
        return IntStream
                .range(0, weights.length)
                .mapToDouble(i -> (i == weights.length - 1 ? x0 : inputs[i]) * weights[i])
                .sum();
    }

    /**
     * Train (try to establish a predictable model)
     * @param nodes sample data
     * @return the trained model (weights)
     */
    public static double[] train(List<Node> nodes) {
        double[] weights = new double[nodes.get(0).getCharacters().length + 1];

        boolean isHit = IntStream.range(0, maxTryTimes).anyMatch(times -> {
            System.out.println(String.format("Round %s", times + 1));
            return nodes.stream().allMatch(node -> {
                int result = activationFunction(calculateSigma(node.getCharacters(), weights));

                DoubleStream.of(weights).forEach(System.out::println);
                System.out.println("");

                if(result == node.getLabel()) {
                    return true;
                } else {
					IntStream
						.range(0, weights.length)
						.forEach(i -> weights[i] += eta
									* (node.getLabel() - result)
									* (i == weights.length - 1 ? x0 : node.getCharacters()[i]));
					return false;
                }
            });
        });

        if(!isHit) {
            throw new RuntimeException("Cannot generate a suitable model!");
        }
        return weights;

    }

    /**
     * Predict with established model
     * @param weights i.e. model
     * @param characters
     * @return the result label
     */
    public static int predict(double[] weights, double[] characters) {
        double sum = calculateSigma(characters, weights);
        return activationFunction(sum);
    }
}
