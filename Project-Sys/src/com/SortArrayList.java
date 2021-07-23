package com;

import java.util.ArrayList; 
import java.util.Collections;   

public class SortArrayList {

 
  public static ArrayList<String> ascending(ArrayList<String> list) {         
    Collections.sort(list);         
    return list;     
  }       

  public static ArrayList<String> descending(ArrayList<String> list) {         
    Collections.sort(list, Collections.reverseOrder());         
    return list;     
  } 
}