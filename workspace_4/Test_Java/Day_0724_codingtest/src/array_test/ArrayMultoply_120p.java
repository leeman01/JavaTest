package array_test;
// 이건 걍 잘모르겟다 ㅋㅋ
public class ArrayMultoply_120p {

	public static void main(String[] args) {
		int [][] arr1 = {{1,4},{3,2},{4,1}};
		int [][] arr2 = {{3,3},{3,3}};
		int[][] target =solution(arr1,arr2);
		for(int i=0;i<target.length;++i) {
			for (int j=0 ; j<target[0].length;++j) {
				System.out.print(target[i][j]+",");
			}
		}
	}
	// arr1의 열의 개수가 arr2의 행의 개수와 동일해야 계산이 가능하다
	private static int[][] solution(int [][] arr1,int [][] arr2){
		int num = arr1.length ; // 행길이
		int cn = arr1[0].length ;// 열길이
		int num1 = arr2.length ;
		int cn1 = arr2[0].length ;
		int [][] target = new int [num][cn1];
		for(int i=0 ; i<num ; ++i) {
			for(int j=0 ; j<cn1;++j) {
				for (int k=0; k<cn ;++k) {
					target[i][j] +=arr1[i][k]*arr2[k][j];
				}
			}
		}
		return target;
		
		
	}
}
