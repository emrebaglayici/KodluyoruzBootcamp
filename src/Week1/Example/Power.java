package Week1.Example;

public class Power {
    int base;
    int power;
    int value;


    public Power(int base,int power){
        this.base=base;
        this.power=power;
        if(power==0)
            return;
        this.value=1;
        for (int value = 0; value <power ; value++) {
            this.value=this.value*base;
        }
    }

    public static void main(String[] args) {

        Power p=new Power(2,2);
        System.out.println(p.value);
    }
}
