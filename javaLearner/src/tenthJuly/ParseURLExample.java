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
    static Boolean isAdding = false;
   private static String[] splitCSV(String line){
        String[] temp = line.split("\\,");
        ArrayList<String> tempList = new ArrayList<>();
        for (int i  = 0; i < temp.length ; i++){
            switchState(temp[i]);
            StringBuilder element = new StringBuilder();
            element.append(temp[i]);
            while(isAdding){
                i++;
                switchState(temp[i]);
                element.append(",");
                element.append(temp[i]);
            }
            tempList.add(element.toString());
        }
        return tempList.toArray(temp);
    }
    private static void switchState(String temp){
        if (temp.contains("\"")){
            ParseURLExample.isAdding = !isAdding;
        }               
    }
    public static HashMap<String, String> getCID2CompoundMap(File inputFile){
        int CID_NUMBER_COL = 2;
        int COMPOUND_NAME_COL = 36;
        String line = "";
        HashMap<String, String> CID2Compound = new HashMap<>();
        try{
        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        in.readLine();
        while ((line = in.readLine()) != null) {
            // use tab as separator
            String[] column = splitCSV(line);
            CID2Compound.put(column[CID_NUMBER_COL], column[COMPOUND_NAME_COL]);
        }
        } catch(FileNotFoundException e){
            System.out.println("confirm your path");
            System.err.println(e);
        } catch(IOException e){
            System.err.println(e);
        }
        return CID2Compound;
    }
}
