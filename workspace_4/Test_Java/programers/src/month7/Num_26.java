/*
 * 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 
 * 더한 결과가 됩니다. 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, 
 * solution을 완성해주세요.

제한 조건
행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
 */

package month7;

import java.util.Arrays;

public class Num_26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr1= {{1,2},{2,3}};
		int [][] arr2= {{3,4},{5,6}};
		System.out.println(Arrays.deepToString(solution(arr1,arr2)));

	}
	private static int[][] solution(int[][]arr1,int[][]arr2){
		int[][] answer = new int [arr1.length][arr1[0].length];
		for(int i=0;i<arr1.length;++i) {
			for(int z=0 ; z< arr1[i].length;++z) {
				answer[i][z] = arr1[i][z] + arr2[i][z] ;
			}
		}
		return answer;
	}

}
