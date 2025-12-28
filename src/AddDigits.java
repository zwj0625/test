public class AddDigits {
    public static void main(String[] args) {

    }

    public static int addDigits(int num){
        int res = 0;
        while(num!=0){
            res += num%10;
            num = num/10;
        }
        num = res;
        if(num<10){
            return num;
        }
        return addDigits(num);
    }
}

