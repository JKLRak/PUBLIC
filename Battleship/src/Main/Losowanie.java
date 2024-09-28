package Main;

import java.util.Random;
public class Losowanie {
    public static int losuj(int a,int b){
        Random R = new Random();
        return a + R.nextInt(b - a + 1);
    }
}
