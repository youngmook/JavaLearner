/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package friday1;
import java.util.*;
import static java.util.Arrays.asList;
/**
 *
 * @author syshin
 */
public class ContainerBasis {
    public static void main(String[] args){
        java.util.ArrayList<String> studentList = new java.util.ArrayList<String>();
        studentList.add("김민성");
        studentList.add("서명원");
        studentList.add("신승연");
        studentList.addAll(Arrays.asList("이힣","유홓","점심"));
        System.out.println(studentList.get(0));
        System.out.println();
        System.out.println();
        System.out.println();
        HashMap<Integer, String> studentMap = new HashMap<>();
        studentMap.put(1, "서명원");
        studentMap.put(0, "김민성");
        studentMap.put(2, "신승연");
        System.out.println(studentMap.get(2));
        for(String student : studentList){
            System.out.println(student);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        for(Integer SN : studentMap.keySet()){
            System.out.println(studentMap.get(SN));
        }
    }
}
