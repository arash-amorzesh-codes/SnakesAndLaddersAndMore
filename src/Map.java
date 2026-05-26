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