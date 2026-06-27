public class Swamp implements WayObject{//swamp can not be placed before a special house
    private int place;
    public Swamp(int place){
        this.place = place;
    }
    public void update(Piece p){
        if(this.place==p.getX()&&p.getDices()>=0&&!p.isInSwamp()){
            System.out.println(p.getColor().toString() + " got stuck in swamp and can\'t move next turn");
            p.setInSwamp(true);
        }
    }
}
