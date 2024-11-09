/*
 * 문제 매칭되는 영단어가 필요하다 , 맑은 날 할일을 메소드로 만들기 todo()
 * 놀일을 메소드로 만들기
 */
package myenum;

public enum Weather {
	맑음("sunny"){
		public String todo(){
			return "빨래널기";
		}
		public String toplay() {
			return "술먹기";
		}
	}, 
	안개("foggy"){
		public String todo() {
			return "빨래걷기";
		}
		public String toplay() {
			return " 실내축구하기";
		}
	}, 
	흐림("cloudy"){
		public String todo() {
			return "집에있기";
		}
		public String toplay() {
			return "겜하기";
		}
	}, 
	비("rainy"){
		public String todo() {
			return "칼국수먹기";
		}
		public String toplay() {
			return "집에 돌아가기";
		}
	}
	,눈("snowy"){
		public String todo() {
			return "제설하기";
		}
		public String toplay() {
			return "눈싸움하기";
		}
	};
	public String eng;
	Weather(String eng){
		this.eng = eng;
	}
	public  String todo() {
		return "???";
	}
	
	public  String toplay() {
		return "???";
	}
}
