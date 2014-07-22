/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package homework;

import java.util.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author syshin
 */
public class Homework3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        ReadCSV.readCSV();
        /* ParseURL.parseURL();
        Boolean isExist = ParseURL.getSynonymList(ParseURL.target).contains();
        for(String s:ReadCSV.col1) {
            System.out.println(s+": "+isExist);
        } */
    }
    
}

class ReadCSV {
    public static void readCSV() {
        String line = "";
        ArrayList<String> col1 = new ArrayList<String>();
        ArrayList<Integer> col2 = new ArrayList<Integer>();
        try{
        File inputFile = new File("C:\\Users\\syshin\\Desktop\\2012163036\\2014 실험방\\output_csv\\감초(만주감초).csv");
        File outputFile = new File("C:\\Users\\syshin\\Desktop\\2012163036\\2014 실험방\\output_csv\\aaa.csv");
        BufferedReader in = new BufferedReader(new FileReader(inputFile));
        while ((line = in.readLine()) != null) {
                        line.replaceAll("\"\\s\""," ");
		        // use comma as separator
			String[] column = line.split("\\,");
                            if (!"Structure".equals(column[2]) && !"PUBCHEM_COORDINATE_TYPE[2]".equals(column[36])) {
                                col1.add(column[36]);
                                col2.add(Integer.parseInt(column[2]));    
                            }
        }
        BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
        for (int i = 0; i<col1.size(); i++){
            System.out.println(col1.get(i) + "," + col2.get(i));
            out.write(col1.get(i) + "," + col2.get(i));
        }
        out.close();
        } catch(FileNotFoundException e){
            System.err.println(e);
        } catch(IOException e){
            System.err.println(e);
        }
    }
}
/*
class ParseURL {
    
    public static String parseURL() throws MalformedURLException, IOException {
        //arguments that are used in this class.
        
            URL target = new URL("https://pubchem.ncbi.nlm.nih.gov/summary/summary.cgi?q=nama&cid="+ReadCSV.col2.get(i));
        
        //replace this part with 'getSynonymList' and 'printArray' methods.
        
        String synonymString=null;
        URLConnection con;
        String startingPoint = "</form>";
        String separator = "\t";
        ParseURL theParser = new ParseURL();

        try {
            con = target.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            // skip lines until it reached to intended lines. loop ends at starting point.
            theParser.__skipLines(in, startingPoint);
            //Starting readLine();
            synonymString=theParser.__getSynonymString(in, separator, startingPoint);
        } catch (Exception e) {
            System.err.println(e);
        }
        return synonymString;
    }
    
    // @to do: implement this method.
    // it gets URL and returns ArrayList of synonyms.
    
    public static ArrayList<String> getSynonymList(URL theURL) throws MalformedURLException, IOException {
        ArrayList<String> result = new ArrayList<String>();
        String synonymString=ParseURL.parseURL();
        String[] synonymArray=synonymString.split("\\t");
        result.add(synonymArray.toString());
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
} */