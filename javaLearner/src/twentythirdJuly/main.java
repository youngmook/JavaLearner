/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package twentythirdJuly;

import java.util.ArrayList;

/**
 *
 * @author grinn
 */
public class main {
    //static class의 활용, class 디자인.
    public static void main(String[] args){
        System.out.println(Person.count);
        Person first = new Person();
        System.out.println(Person.count);
        Person second = new Person();
        Person third = new Person();
        System.out.println(first+"\t"+second+"\t" +third);
    }
    
}
class Person {
    static Integer count = 0;
    Integer id = 0;
    Person(){
        count++;
        id = count;
    }
    public String toString(){
        return id.toString();
    }
}