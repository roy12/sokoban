package Model;

public class MoveUp implements Movement {
	
public MoveUp(Level lvl) {
	Pointer2D to1, to2;
	to1 =new Pointer2D(lvl.getPl());
	to1.setX(to1.getX()-1);
	to2 =new Pointer2D(lvl.getPl());
	to2.setX(to2.getX()-2);
	
	@SuppressWarnings("unused")
	MovementPolicy mp = new MovementPolicy(lvl,lvl.getPl(),to1,to2);
}

}
