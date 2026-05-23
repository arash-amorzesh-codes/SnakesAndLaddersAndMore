import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;
public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("welcome to our game!\n=================================\nhow many players want to play?\t");
        int num = 0;
        while (true) {
            try{num = sc.nextInt();}catch(InputMismatchException ime){
                System.out.print("a number please!\t");
            }
            if (num>8){
                System.out.print("the maximum number of players is 8:\t");
            }else if(num<=0){
                System.out.print("come on, what are you saying?\t");
            }else if(num==1){
                System.out.print("1player mode is not ready\t");
            }else{
                break;
            }
        }
        String[] pl = new String[num];
        sc.nextLine();//erasing buffer
        for(int i=0;i<num;i++){
            System.out.print("enter player ");
            System.out.print(i+1);
            System.out.print("\'s name:\t");
            pl[i] = sc.nextLine();
        }
        Map map = new Map(pl,100);
        Random rander = new Random();
        Piece[] ps = new Piece[num];
        ps = map.getPieces();
        int con = 1;
        while (con == 1) {
            for(int i=0;i<num&con==1;i++){
                System.out.print("player ");System.out.print(i+1);System.out.print("\'s turn:(press enter)");
                sc.nextLine();
                int dice = rander.nextInt(6) + 1;
                System.out.print(dice);System.out.println("!!!");
                ps[i].Goto(ps[i].getX()+dice);
                System.out.print("X:");
                System.out.println(ps[i].getX());
                String str = map.checkWin();
                if(str!=null){
                    map.endGame(str);
                    sc.close();
                    return;
                }
            }
        }
        //never reachs
        sc.close();
    }
}