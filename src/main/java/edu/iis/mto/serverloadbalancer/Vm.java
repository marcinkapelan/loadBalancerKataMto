package edu.iis.mto.serverloadbalancer;

public class Vm {
    public Vm(int size) {
        this.size = size;
    }

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
