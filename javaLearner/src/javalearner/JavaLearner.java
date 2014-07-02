/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalearner;

/**
 *
 * @author grinn
 */
public class JavaLearner {
    private static void println (String input){
        System.out.println(input);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Car myCar = new Car("range rover", 50.0);
        System.out.println(myCar.run(0.0, 10.0));
        System.out.println();
    }

}

class Car {

    Car(String tempName, Double cost) {
        this.name = tempName;
        this.costPerDistance = cost;
    }
    Double costPerDistance = 15.0;
    String name = null;

    Double run(Double departureScalar, Double destinationScalar) {
        Double cost = (destinationScalar - departureScalar) * costPerDistance;
        return cost;
    }
}

class solver {

    Double theProblem(Double P, Double r, Integer N) {
        return 0.0;
    }

    Double loop(Integer finalCondition) {
        for (int i = 0; i < finalCondition; i++) {

        }
        int i = 0;
        while (i != finalCondition) {
            i++;
        }
        if (i<= finalCondition){
            
        }
        return 0.0;
    }

}
