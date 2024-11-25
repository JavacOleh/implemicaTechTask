package task2.console.structure;

import lombok.ToString;

@ToString

/*
Class takes some data structure of such definition:
gdansk
2
2 1
3 3

example:
2 is cityNeighborIndex
1 cost

example 2:
3 is cityNeighborIndex
3 cost
*/
public class ConsoleObj {
    private int cost;
    private int cityNeighborIndex;

    public ConsoleObj(int cost, int cityNeighborIndex) {
        if (cost > 0)
            this.cost = cost;
        else {
            System.out.println("Error: Cost \"" + cost + "\" must be bigger than 0!!");
            return;
        }
        this.cityNeighborIndex = cityNeighborIndex;
    }

    public int getCost() {
        return this.cost;
    }

    public int getCityNeighborIndex() {
        return this.cityNeighborIndex;
    }
}
