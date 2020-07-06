package com.nexgrid.board.dataControl;

public class Pageging {

    private int skipPageStart;
    private int skipPageEnd;

    public int getSkipPageStart() {
        return skipPageStart;
    }

    public void setSkipPageStart(int skipPageStart) {
        this.skipPageStart = skipPageStart;
    }

    public int getSkipPageEnd() {
        return skipPageEnd;
    }

    public void setSkipPageEnd(int skipPageEnd) {
        this.skipPageEnd = skipPageEnd;
    }

    @Override
    public String toString() {
        return "Pageging{" +
                "skipPageStart=" + skipPageStart +
                ", skipPageEnd=" + skipPageEnd +
                '}';
    }
}
