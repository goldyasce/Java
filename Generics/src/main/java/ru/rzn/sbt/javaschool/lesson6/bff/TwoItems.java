package ru.rzn.sbt.javaschool.lesson6.bff;

public class TwoItems<T> {
    private T firstObject;
    private T secondObject;

    public TwoItems(T first, T second){
        firstObject = first;
        secondObject = second;
    }

    public T getFirstObject(){
        return firstObject;
    }

    public T getSecondObject() {
        return secondObject;
    }
}
