package com.sample;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CSVUtil {

	/**
	 * Covert inputed CSV File to Node POJO
	 * @param file files name of data set
	 * @param characterQty the quantity of characters in data set
	 * @return List of converted Node
	 * @throws IOException
	 */
	public static List<Node> convertCsvToNode(String file, int characterQty) throws IOException {
        List<Node> nodes = new ArrayList<>();

        Reader in = new FileReader(CSVUtil.class.getResource(file).getPath());
        Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);

        records.forEach(record -> {
            double[] d = new double[characterQty];

            IntStream.range(0, characterQty)
                 .forEach(i -> d[i] = Double.parseDouble(record.get(i)));

            nodes.add(new Node(d, Integer.parseInt(record.get(characterQty))));
        });

        return nodes;
    }
	
}
