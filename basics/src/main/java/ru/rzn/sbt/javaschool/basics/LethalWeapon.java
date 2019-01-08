package ru.rzn.sbt.javaschool.basics;

public class LethalWeapon {
    public String color;
    private int roundsLeft;
    private Double power;
    private static long nextSerial = 0;
    private final long serial = nextSerial;


    public LethalWeapon(){
        roundsLeft = 12;
        color = "BLACK";
        power = 3.0;
        nextSerial += 1;
    }

    public LethalWeapon(String color, Double power, int roundsLeft){
        this.color = color;
        this.roundsLeft = roundsLeft;
        this.power = power;
        nextSerial += 1;
    }

    public long getSerial(){
        return serial;
    }

    public void setPower(String power){
        this.power = Double.parseDouble(power);
    }

    public Double getPower(){
        return this.power;
    }

    public void reload (int bullets){
        roundsLeft += bullets;
    }

    public void pewPew(){
        roundsLeft -= 2;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(null == obj || obj.getClass() != this.getClass()){
            return false;
        }
        LethalWeapon weapon = (LethalWeapon)obj;
        return color == weapon.color && (power == weapon.power || power != null && power.equals(weapon.getPower()))
                && (roundsLeft == weapon.roundsLeft);
    }

    public int hashCode(){
        final int prime = 31;
        int result = 1;
        return result = prime * roundsLeft*result + ((power != null) ? 0 : power.hashCode());
    }

}
