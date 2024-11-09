package access;



public class SpeakerMain {
    public static void main(String[] args) {
        Speaker speaker = new Speaker(90);
        speaker.volumeUp();
        speaker.showVolume();

        speaker.volumeUp();
        speaker.showVolume();
        // 필드에 직접접근 함
        System.out.println("직접 볼륨필드 접근");
//        speaker.volume = 200; // 이렇게하면 스피커 터져버림 ==> 끔찍한 비극을 막기위해 private으로 필드접근을 막아버림
        speaker.showVolume();



    }
}
