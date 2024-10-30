package treeset;

public class TreestTest_301p {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 이진트리 노드에대해 전위 중위 후위 순회를 하는 함수를 구현하기
	private static String[] solution(int[] nodes) {
		String[] result = new String[3];
		result[0] = preorder(nodes,0).trim();
		result[1] = inorder(nodes,0).trim();
		result[2] = postorder(nodes,0).trim();
		return result ;
		
	}
	private static String preorder(int[] nodes,int idx) {
		if (idx>=nodes.length) {
			return "";
			
		}
		// 부모노드 - 왼쪽서브트리 -오른쪽 서브트리 순으로 재귀호출하여 결과를 이어붙여야함
		return nodes[idx]+" "+ preorder(nodes,2*idx+1)+
				preorder(nodes,2*idx+2);
	}
	private static String inorder(int[]nodes,int idx) {
		// 좌 부모 우 노드 순으로 진행한다
		if (idx>=nodes.length)
			return " ";
		return inorder(nodes,idx*2+1)+ nodes[idx] +" " + inorder(nodes,idx*2+2) ;
				// 이런식으로 재귀함수의 활용은 노드트리에서 자주 사용된다
		
	}
	private static String postorder(int[] nodes , int idx) {
		if(idx>=nodes.length)
			return " ";
		// 좌 -우 -부모 순으로 배출한다
		return postorder(nodes,idx*2+1) + postorder(nodes,idx*2+2) + nodes[idx] +" " ;
		
	}

}
