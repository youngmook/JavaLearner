/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tenthJuly;

import java.util.*;
import java.net.*;
import java.io.*;

/**
 *
 * @author grinn
 */
public class ParseURLEx2 {

    public static void main(String[] args) throws MalformedURLException, IOException {
        //arguments that are used in this class.
        
        
        File inputFile = new File("E:\\Users\\grinn\\Downloads\\output_csv\\output_csv\\감초(만주감초).csv");
        HashMap<String, String> cid2compMap = ParseURLExample.getCID2CompoundMap(inputFile);
        for(String CID : cid2compMap.keySet()){
            System.out.println(CID + "\t" + cid2compMap.get(CID));
            System.out.println(CID+": "+getSynonymList(CID).toLowerCase().contains(cid2compMap.get(CID).toLowerCase()));
        }
    }
    /*
    @to do: implement this method.
    it gets URL and returns ArrayList of synonyms.
    */
    public static String getSynonymList(String CID) throws MalformedURLException, IOException {
        String result = "";
        URL target = new URL("https://pubchem.ncbi.nlm.nih.gov/summary/summary.cgi?q=nama&cid=" + CID);
        
        /**replace this part with 'getSynonymList' and 'printArray' methods.
        */
        URLConnection con;
        String startingPoint = "</form>";
        String separator = "\t";
        ParseURLEx2 theParser = new ParseURLEx2();
        try {
            con = target.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            // skip lines until it reached to intended lines. loop ends at starting point.
            theParser.__skipLines(in, startingPoint);
            //Starting readLine();
            result = theParser.__getSynonymString(in, separator, startingPoint);
        } catch (Exception e) {
            System.err.println(e);
        }
        return result;
    }; 
    private String __removeTags(String inputLine, String separator) {
        String result = inputLine.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", separator);
        result = result.replaceAll("\\&nbsp;", "");
        return result;
    }

    private void __skipLines(BufferedReader in, String string2MatchWith) throws IOException {
        String tempString = "";
        while (!(tempString = in.readLine()).contains(string2MatchWith)) {
            in.mark(50);
        };
        in.reset();
    }

    private String __getSynonymString(BufferedReader in, String separator, String startingPoint) throws Exception {
        StringBuilder result = new StringBuilder();
        String txtWithoutTag;
        String line;
        if (this.__isAtStartingPoint(in, startingPoint)) {
            while ((line = in.readLine()) != null) {
                txtWithoutTag = this.__removeTags(line, separator);
                result.append(txtWithoutTag);
                result.append(separator);
            }
        }
        return result.toString();
    }

    private Boolean __isAtStartingPoint(BufferedReader in, String startingPoint) throws IOException {
        Boolean result = true;
        result = in.readLine().contains(startingPoint);
        return result;
    }
}