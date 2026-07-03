import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class Map {
    private Piece[] pieces;
    private int end;
    private WayObject[] wayObjects;
    private String[] players;
    public Map(String[] players,int end,WayObject[] wayObjects){
        this.players = players;
        this.end = end;
        this.wayObjects = wayObjects;
        this.pieces = new Piece[players.length];
        for(int i=0;i<players.length;i++){
            this.pieces[i] = new Piece(colornum(i+1));
        }
    }
    public void endGame(String winner){
        System.out.println("the winner is : "+winner+"\n");
    }
    public String checkWin(){
        for(int i=0;i<this.pieces.length;i++){
            if (this.pieces[i].getX() >= this.end){
                return this.players[i];
            }
        }
        return null;
    }
    public static Map readFile(String url,String[] players) throws Exception{
        List<String> lines = Files.readAllLines(Path.of(url));
        int n = Integer.parseInt(lines.get(0));
        WayObject[] wayObjects = new WayObject[n];
        int index=0;
        int end = -1;
        for(int i=1;i<lines.size();i++){
            String line = lines.get(i);
            switch (line) {
                case "SNAKE":{
                    int st = Integer.parseInt(lines.get(i+1));
                    int ed = Integer.parseInt(lines.get(i+2));
                    WayObject sl = new OneWayPortal(st,ed);
                    wayObjects[index] = sl;
                    index++;
                    break;}
                case "LADDER":{
                    int st = Integer.parseInt(lines.get(i+1));
                    int ed = Integer.parseInt(lines.get(i+2));
                    WayObject sl = new OneWayPortal(st,ed);
                    wayObjects[index] = sl;
                    index++;
                    break;}
                case "X2HOUSE":{
                    int st = Integer.parseInt(lines.get(i+1));
                    WayObject sl = new x2House(st);
                    wayObjects[index] = sl;
                    index++;
                    break;}
                case "SWAMP":{
                    int st = Integer.parseInt(lines.get(i+1));
                    WayObject sl = new Swamp(st);
                    wayObjects[index] = sl;
                    index++;
                    break;}
                case "END":{
                    end = Integer.parseInt(lines.get(i+1));
                    break;}
                default:
                    break;
            }
        }
        if(end==-1){
            throw new InvalidMapException();
        }
        Map m = new Map(players, end, wayObjects);
        return m;
    }
    public void checkWayObjects(){
        for(int i=0;i<this.wayObjects.length;i++){
            for(int j=0;j<this.pieces.length;j++){
                this.wayObjects[i].update(this.pieces[j]);
            }
        }
    }
    public Piece[] getPieces() {
        return pieces;
    }
    public int getEnd() {
        return end;
    }
    public String[] getPlayers() {
        return players;
    }
    private Color colornum(int i){
        switch (i) {
            case 1:
                return Color.RED;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.YELLOW;
            case 4:
                return Color.GREEN;
            case 5:
                return Color.MAGENTA;
            case 6:
                return Color.WHITE;
            case 7:
                return Color.GRAY;
            case 8:
                return Color.BLACK;
            default:
                System.out.println("this is imposible!");
        }
        return null;
    }
}