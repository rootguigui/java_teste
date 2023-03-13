package models;

import java.util.ArrayList;

public class Family {
    private long id;
    private ArrayList<Member> members = new ArrayList<>();
    private int points = 0;

    public Family(long id) {
        this.id = id;
    }

    public ArrayList<Member> getMembers() { return members; }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public void addPoints(int newPoints) {
        this.points += newPoints;
    }

    public int getPoints() {
        return this.points;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Family{" +
                "members=" + members.toString() +
                ", points=" + points +
                '}';
    }
}
