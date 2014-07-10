/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package friday1;
import java.util.*;
/**
 * This program calculates summation of principle-interest by differing
 * P,n,r.
 * @variable P: principle value, n: year of deposition, r: rate of interest 
 * @author syshin
 */
public class Principle1 {
    public static void main(String[] args){
        int P=1000,n=1;
        //int v;
        double r=0.1;
     
        printMoneyTable(P,n,r);
        //printMoneyTableForEachP(P,n, r);
    }
    /*
    *This method prints money tables containing Values per each P, n, r;
    */
    public static Integer printMoneyTable(int P,int n,double r){
        int i = 0;
        int newP;
        newP = P;
        for(i=0;i<10;i++){
            newP = P+1000*i;
            printMoneyTableForEachP(newP,n,r);
            System.out.println();
        }
        return 0;
    }
    public static void printMoneyTableForEachP(int P,int n,double r){
        int i = 0,j=0;
        int tempn =0;
        double tempr =0.0;
        
        //printMap(mapVar);
        ArrayList<ArrayList<Integer>> theTable = getMoneyTableArray(P, n, r);
        printArray(theTable);
    }
    public static void printArray(ArrayList<ArrayList<Integer>> input2DArray){
        for(ArrayList element: input2DArray) {
            System.out.println(array2String(element));
        }   
    }
    public static ArrayList<ArrayList<Integer>> getMoneyTableArray(Integer P, int n, double r){
        int i = 0,j=0;
        int tempn =0;
        double tempr =0.0;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(i=0;i<10;i++){
            ArrayList<Integer> listElement= new ArrayList<Integer>();
            for(j=0;j<10;j++){
                tempn = n + i*1;
                tempr = r + j*0.01;
                listElement.add(calculation(P,tempn,tempr));
            }
            result.add(listElement);
        }
        return result;
    }
    public static Integer calculation(int P, int n, double r) {
        double V;
        double Q;             
        Q = Math.pow((1+r), (double)n);
        V = P*Q;
        return (int)V;
    }
    public static String array2String(ArrayList<Integer> array) {
        String resultString = "";
        for(Integer arrayElement:array) {
            resultString = resultString + "\t" +arrayElement.toString();
        }        
        return resultString;
    }
}
class Money{
    int amount;
    String nation;
    Money(){
        this.amount = 2000;
        this.nation = "kor";
    }
    public String toString(){
        return "nation: " + nation+ " " + "amount: " + amount + "\n";
    }
    /*
    for(Money element:moneyArray) {
    System.out.print(element);
    System.out.print("\t");
}
    */
}
