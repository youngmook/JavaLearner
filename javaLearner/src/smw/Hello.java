/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smw;

/**
 *
 * @author Seomyungwon
 */
public class Hello {
    public static void main(String[] args) {
        int costG = 1850;
        int distance;
        int cost;
        City A = new City(0);
        City B = new City(500);
        Car myCar = new Car("AAAAAA", 10.0);
        
        distance = myCar.run(A, B);
        cost = myCar.getCost(distance, costG);

        System.out.println(cost);
    }
}
class City{
City(int inputValue){
    this.xCoordinate = inputValue;
}
int xCoordinate;
}

class Car {
    
    Car() {
        this.name = "";
        this.costPerK = 0.0;
    }
    
    Car(String inputName, Double inputCostPerK) {
        this.name = inputName;
        this.costPerK = inputCostPerK;        
    }
    
    String name;
    Double costPerK;
    
    int run(City departure, City destination){
        int distance = destination.xCoordinate - departure.xCoordinate;
        System.out.println("We traveled " + distance + " from " + departure + " to " + destination.toString() + ".");
        return distance;
    }
    int getCost(int distance, int costG){
        int result = (int) (distance / this.costPerK * costG);
        return result;
    }
}

