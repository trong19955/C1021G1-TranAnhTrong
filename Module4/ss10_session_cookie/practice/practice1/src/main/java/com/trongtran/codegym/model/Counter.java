package com.trongtran.codegym.model;

import java.util.Objects;

public class Counter {
    private int count;
    public Counter(){
    }
    public  Counter(int count){
        this.count =count;
    }
    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }
    public int increment(){
        return count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Counter counter = (Counter) o;
        return count == counter.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
