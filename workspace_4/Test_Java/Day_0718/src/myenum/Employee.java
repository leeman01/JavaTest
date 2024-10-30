package myenum;
public enum Employee {
    이몽룡("부장") {
        @Override
        public String work() {
            return "제품에 대한 R&D";
        }
    },
    성춘향("과장") {
        @Override
        public String work() {
            return "판매 제품의 검수";
        }
    },
    김방자("대리") // 공통업무를 처리하게 만듦
        
    ,
    박향단("사원") 
        
    ,
    변사또("이사") {
        @Override
        public String work() {
            return "판매 제품의 검수";
        }
    },
    뺑떡어미("고객");
    	
    
    public String title;

    Employee(String title) {
        this.title = title;
    }
    // 안에 선언된 
    public  String work() {
    	return "완성제품을 판매";
    }
}

