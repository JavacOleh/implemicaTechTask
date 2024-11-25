package task2.console.structure;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString

/*
Class takes some data structure of such definition:
gdansk
2
2 1
3 3

example:
gdansk will be currentCity

size of consoleObjs will be 2

inside consoleObjs:
2 will be cityNeighborIndex
1 will be cost

inside consoleObjs:
3 will be cityNeighborIndex
3 will be cost
*/

public class ConsoleObjs {
    private String currentCity;
    private ConsoleObj[] consoleObjs; //Neighbors

    public ConsoleObjs(String currentCity, ConsoleObj[] consoleObjs) {

        if(currentCity.length() < 10)
            this.currentCity = currentCity;
        else {
            System.out.println("Error in ConsoleObjs.java, currentCity size must be lower than 10!");
        }
        this.consoleObjs = consoleObjs;
    }
}
