/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework;

/**
 *
 * @author melonPeach
 */
public class Homework1 {
    public static void main(String[] args){
        int minPrincipal=1000; int maxPrincipal=10000;
        double minRate=0.10; double maxRate=0.20;
        int minYear=1; int maxYear=10;
        System.out.println("This program evaluates the investment equation and prints data tables.");
        System.out.println("Year is increased along the horizontal line, from "+minYear+" to "+maxYear);
        System.out.println(" ");
        investment.equation(minPrincipal, maxPrincipal, minRate, maxRate, minYear, maxYear);
    }
}
class investment {
    static void equation(int minPrincipal, int maxPrincipal, double minRate, double maxRate, int minYear, int maxYear) {
        int i; double r=minRate;
        double P=minPrincipal; double V=minPrincipal;
        while(P<=maxPrincipal) {
            r=minRate;
            System.out.println("P="+(int)P+"");     //prints each table by P value
            while((float)r<=maxRate+0.00001) {
                if(((float)r*10)%1==0)
                    System.out.print("r="+(float)r+"    ");     //prints r value; r=0.15000000001처럼 나와서 float으로 형태 변경
                else
                    System.out.print("r="+(float)r+"   ");
                for(i=minYear;i<=maxYear;i++) {
                    V=V*(1+r);
                    if(V<10000)
                        System.out.print(" "+(int)V+" ");       //prints calculated V value
                    else
                        System.out.print((int)V+" ");           //줄을 맞추기 위해 4자리일때와 5자리일때로 나눠서 출력
                    if(i==maxYear)
                    System.out.println(" ");
                }
                V=P+1000;
                r=r+0.01;
            }
            P=P+1000;
            System.out.println(" ");
            System.out.println(" ");
        }
    }
}
