public class Piece {
    private Color color;
    private int place;
    private int steps;
    private boolean inswamp;
    public Piece(Color c){
        this.color = c;
        this.steps = 0;
        this.dices = 0;
        this.place = 0;
        this.inswamp = false;
    }
    public boolean isInSwamp() {
        return inswamp;
    }
    public void setInSwamp(boolean inswamp) {
        this.inswamp = inswamp;
    }
    public int getDices() {
        return dices;
    }
    public void setDices(int dices) {
        this.dices = dices;
    }
    private int dices;
    public int getSteps() {
        return steps;
    }
    public void setSteps(int steps) {
        this.steps = steps;
    }
    public int update(){
        if(this.steps==0){
            return 0;
        }else{
            this.steps--;
            this.place++;
            return 1;
        }
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