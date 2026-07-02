public class x2House implements WayObject{
    private int place;
    public x2House(int place){
        this.place = place;
    }
    public void update(Piece p){
        if(this.place==p.getX()){
            System.out.println(p.getColor().toString() + " can roll dice one more");
            p.setDices(p.getDices()+1);
        }
    }
}
