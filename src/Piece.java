public class Piece {
    private Color color;
    private int place;
    public Piece(Color c){
        this.color = c;
        this.place = 0;
    }
    public void Goto(int x){
        this.place = x;
    }
    public int getX(){
        return this.place;
    }
    public Color getColor(){
        return this.color;
    }
}