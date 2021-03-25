package diagonalDifference;

import java.util.ArrayList;
import java.util.List;

public class Solution {	
	public int diagonalDifference(List<List<Integer>> arr) {
		List<List<Integer>> flippedMatrix = new ArrayList<>();
		List<Integer> LtoRDiagonal = new ArrayList<Integer>();
		List<Integer> RtoLDiagonal = new ArrayList<Integer>();
		int LtoRDiagonalTotal = 0;
		int RtoLDiagonalTotal = 0;
		for(int i = 0; i < arr.size(); i++) {
			List<Integer> matrixLine = arr.get(i);
			LtoRDiagonal.add(matrixLine.get(i));
		}
		for(int dc = arr.size()-1; dc >= 0; dc--) {
			flippedMatrix.add(arr.get(dc));
		}
		for(int i = 0; i < flippedMatrix.size(); i++) {
			List<Integer> matrixLine = flippedMatrix.get(i);
			RtoLDiagonal.add(matrixLine.get(i));
		}
		LtoRDiagonalTotal = sumDiagonal(LtoRDiagonal);
		RtoLDiagonalTotal = sumDiagonal(RtoLDiagonal);
		int differenceBetweenDiagonals = RtoLDiagonalTotal - LtoRDiagonalTotal;
		return Math.abs(differenceBetweenDiagonals);
	}
	
	private int sumDiagonal(List<Integer> diagonal) {
		int handle = 0;
		for(int i=0; i< diagonal.size(); i++) {
			handle += diagonal.get(i);
		}
		return handle;
	}
}
