/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package friday1;

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
        for(i=0;i<10;i++){
            for(j=0;j<10;j++){
                tempn = n + i*1;
                tempr = r + j*0.01;
                System.out.print(calculation(P,tempn,tempr));
                System.out.print("\t");
            }
            System.out.println();
        }
    }
    public static Integer calculation(int P, int n, double r) {
        double V;
        double Q;             
        Q = Math.pow((1+r), (double)n);
        V = P*Q;
        return (int)V;
    }
}
