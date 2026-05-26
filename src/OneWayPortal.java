public class OneWayPortal implements WayObject{
    protected int head;
    protected int tail;
    public OneWayPortal(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }
    public int getHead() {
        return head;
    }
    public int getTail() {
        return tail;
    }
    public boolean isSnake(){
        return this.head>this.tail;
    }
    public void update(Piece p){
        if (p.getX()==this.head){
            p.Goto(this.tail);
            if(this.isSnake()){
                System.out.print(p.getColor()+" was biten by snake and went to ");System.out.println(this.tail);
            }else{
                System.out.print(p.getColor()+" was climed up a ladder to ");System.out.println(this.tail);
            }
        } 
    }
}
