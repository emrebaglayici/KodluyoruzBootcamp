package Week2.EnumExample;

public enum Transport {
    CAR(120),TRUCK(90),MOTORBIKE(150),AIRPLANE(1000);
    private int maxSpeed;
    Transport(int maxSpeed){
        this.maxSpeed=maxSpeed;
    }
    public int getMaxSpeed(){
        return this.maxSpeed;
    }
}
