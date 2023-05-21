package gida.simulators.labs.first.resources;

import java.util.LinkedList;

import gida.simulators.labs.first.entities.Entity;

public class CustomQueue implements Queue {

    private int id;
    private java.util.Queue<Entity> queue;
    public int maxSize;

    public CustomQueue(int id){
        this.id = id;
        this.queue = new LinkedList<>();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public void enqueue(Entity entity) {
        this.queue.add(entity);

        if(this.queue.size()>this.maxSize){
            this.setMaxSize(this.queue.size());
        }
    }

    @Override
    public Entity checkNext() {
        return this.queue.peek();
    }

    @Override
    public Entity next() {
        return this.queue.poll();
    }

    @Override
    public String toString() {
        return "id: " + this.id + " -> " + this.queue.toString();
    }
}
