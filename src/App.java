import java.util.Random;
import java.util.Scanner;
public class App {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("welcome to our game!\n=================================\nhow many players want to play?\t");
        int num = 0;
        int got = 0;
        try{
            while (got == 0) {
                num = sc.nextInt();
                if (num>8){
                    System.out.print("the maximum number of players is 8:\t");
                }else if(num<=0){
                    System.out.print("come on, what are you saying?\t");
                }else if(num==1){
                    System.out.print("1player mode is not ready\t");
                }else{
                    got = 1;
                }
            }
        }catch(Exception e){
            System.out.println("an error has accoured");
            main(args);
        }
        String[] pl = new String[num];
        sc.nextLine();//erasing buffer
        for(int i=0;i<num;i++){
            System.out.print("enter player ");
            System.out.print(i+1);
            System.out.print("\'s name:\t");
            pl[i] = sc.nextLine();
        }
        WayObject[] wo = new WayObject[10];
        wo[0] = new OneWayPortal(50, 6);//sample
        wo[1] = new OneWayPortal(98, 73);
        wo[2] = new OneWayPortal(26, 99);
        wo[3] = new OneWayPortal(20, 30);
        wo[4] = new OneWayPortal(39, 45);
        wo[5] = new x2House(10);
        wo[6] = new x2House(77);
        wo[7] = new x2House(23);
        wo[8] = new x2House(5);
        wo[9] = new x2House(90);
        Map map = new Map(pl,100,wo);
        Random rander = new Random();
        Piece[] ps = new Piece[num];
        ps = map.getPieces();
        for(int i=0;i<num;i++){
            System.out.print(pl[i]+"\'s color is ");System.out.println(ps[i].getColor());
        }
        int con = 1;
        while (con == 1) {
            int dice;
            for(int i=0;i<num&con==1;i++){
                ps[i].setDices(ps[i].getDices()+1);
                do{
                ps[i].setDices(ps[i].getDices()-1);
                System.out.print(ps[i].getColor()+"\'s turn:(press enter)");
                sc.nextLine();
                dice = rander.nextInt(6) + 1;
                System.out.print(dice);System.out.println("!!!");
                ps[i].setSteps(dice);
                if(dice==6){
                    ps[i].setDices(ps[i].getDices()+1);
                }
                while (ps[i].update()==1);
                map.checkWayObjects();
                for(int j=0;j<num;j++){
                    if(ps[j].getColor()!=ps[i].getColor()&&ps[j].getX()==ps[i].getX()){
                        ps[j].Goto(0);
                        System.out.println(ps[j].getColor().toString() + " was killed by " + ps[i].getColor().toString() );
                    }
                }
                System.out.print("X:");
                System.out.println(ps[i].getX());
                String str = map.checkWin();
                if(str!=null){
                    map.endGame(str);
                    sc.close();
                    return;
                }}while(ps[i].getDices()>0);
            }
        }
        //never reachs
        sc.close();
    }
}