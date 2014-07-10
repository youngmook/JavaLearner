/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tenthJuly;
import java.io.*;
import java.util.*;
/**
 *
 * @author grinn
 */
public class ParseURLExample {
    public static void main(String[] args){
        String line = "";
        ArrayList<Double> col1 = new ArrayList<Double>();
        ArrayList<Double> col2 = new ArrayList<Double>();
        try{
        File inputFile = new File("E:\\Dropbox\\Lab Study\\FG\\PP protocol\\0425_all_report\\peakList_IU\\21.csv");
        File outputFile = new File("E:\\Dropbox\\Lab Study\\FG\\PP protocol\\0425_all_report\\peakList_IU\\21COPY.csv");
        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        while ((line = in.readLine()) != null) {
		        // use comma as separator
			String[] column = line.split("\\,");
                        col1.add(Double.parseDouble(column[0]));
                        col2.add(Double.parseDouble(column[1]));
        }
        BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
        for (int i = 0; i<col1.size(); i++){
            System.out.println(col1.get(i) + "," + col2.get(i));
            out.write(col1.get(i) + "," + col2.get(i));
        }
        out.close();
        } catch(FileNotFoundException e){
            System.out.println("confirm your path");
            System.err.println(e);
        } catch(IOException e){
            System.err.println(e);
        }
    }
}
