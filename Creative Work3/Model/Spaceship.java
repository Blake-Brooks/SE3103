package Model;

public abstract class Spaceship {
    private float x;
    private float y;
    public Spaceship(){

    }

    public Spaceship(float x, float y){
        this.x = x;
        this.y = y;
    }

    public abstract void fireWeapon();
    public abstract void thrusters();
}
