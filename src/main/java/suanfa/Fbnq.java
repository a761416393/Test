package suanfa;

public class Fbnq {
    public static void main(String []args){
        System.out.println(FeBo(5));
    }

    public static int FeBo(int n){
        if (n==1|| n==2){
            return 1;
        }else{
           return FeBo(n-1)+FeBo(n-2);
        }

    }
}
