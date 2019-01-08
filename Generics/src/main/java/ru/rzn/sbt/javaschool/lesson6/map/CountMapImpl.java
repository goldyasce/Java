package ru.rzn.sbt.javaschool.lesson6.map;

import java.util.*;

public class CountMapImpl<T> implements CountMap<T> {
    private TreeMap<T, Integer> map;

    public CountMapImpl(){
        this.map = new TreeMap<>();
    }

    @Override
    public void add(T o) {
        if(map.containsKey(o)){
            map.replace(o, map.get(o) + 1);
        }else{
            map.put(o, 1);
        }
    }

    @Override
    public int getCount(T o) {
        if(map.containsKey(o)){
            return map.get(o);
        }else{
            return 0;
        }
    }

    @Override
    public int remove(T o) throws  NullPointerException {
        int res = 0;
        try{
            if(map.containsKey(o)){
                res = map.get(o);
                if(res == 1){
                    map.remove(o);
                }else{
                    map.replace(o, map.get(o) - 1);
                }
            }
        }catch(NullPointerException npe){
            throw npe;
        }
        return res;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap source) throws NullPointerException {
        try{
            if(source != null){
                CountMapImpl<T> elements = (CountMapImpl<T>) source;
                for(Map.Entry<T, Integer> maps : elements.map.entrySet()){
                    T currentKey = maps.getKey();
                    if(map.containsKey(currentKey)){
                        map.replace(currentKey, map.get(currentKey) + maps.getValue());
                    }else{
                        map.put(currentKey, maps.getValue());
                    }
                }
            }else{
                throw new NullPointerException();
            }
        }catch(NullPointerException npe){
            throw npe;
        }
    }

    @Override
    public Map toMap() {
        TreeMap<T, Integer> result = new TreeMap<>();
        for (Map.Entry<T, Integer> entry : map.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    @Override
    public void toMap(Map destination) throws NullPointerException {
        if (destination != null) {
            destination.clear();
            for (Map.Entry<T, Integer> entry : map.entrySet()) {
                destination.put(entry.getKey(), entry.getValue());
            }
        } else throw new NullPointerException();
    }
}
