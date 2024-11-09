package ref;

public class MethodChange2 {
    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value=10;
        System.out.println(dataA);
        System.out.println(dataA.value);
        changeRefer(dataA);
        System.out.println(dataA.value);



    }
    static void changeRefer(Data dataX){
        System.out.println(dataX);
        dataX.value =20;
    }
}
