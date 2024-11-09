package access;

public class Speaker {
    private int volume; // 이렇게하면? 현재 Speaker객체를 만들면 자동으로 0으로 초기화 => 뭔 짓을 하더라도 이값에 접근 x
// int volume => 이러면 default 값이다 같은 패키지안에서만 값을 허용한다
    //protected 는 패키지와 상속값 까지 허용한다
    Speaker(int volume){
        this.volume = volume ;
    }
    void volumeUp(){
        if(volume>=100){
            System.out.println("음량 최대 더이상은 불가");
        }else{
            volume+=10;
            System.out.println("볼륨 10 증가");
        }
    }
    void volumeDown(){
        volume-=10;
        System.out.println("볼륨 줄이기 호출");
    }
    void showVolume(){
        System.out.println("현재볼륨: " + volume);
    }
}
