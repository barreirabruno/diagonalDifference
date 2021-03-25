package diagonalDifference;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TesteDiagonalDifference {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWritter = new BufferedWriter(new FileWriter("write-here.txt"));
		
		int n = Integer.parseInt(bufferedReader.readLine().trim());
		
		List<List<Integer>> arr = new ArrayList<>();
		
		IntStream.range(0, n).forEach(index -> {
			try {
				arr.add(
	                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
				);
			} catch (Exception e) {
				throw new RuntimeException();
			}
		});
		
		Solution solution = new Solution();
		int result = solution.diagonalDifference(arr);
		
		bufferedWritter.write(String.valueOf(result));
		bufferedWritter.newLine();
		
		bufferedReader.close();
		bufferedWritter.close();
	}
}
