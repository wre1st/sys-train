package com;

public class StringBufferPrct {
    public static void main(String[] args)
    {
        StringBuffer s = new StringBuffer("Systems Ltd");
        s.insert(7, "@");
        System.out.println(s);
  
  
        s.insert(8, 2021);
        System.out.println(s); // returns 5Getr41.35ueeksforGeeks

        char dept[] = { 'I', 'n', 't', 'e', 'g','r','a','t','e' };
        
        s.insert(0, ' ');
        // insert character array at offset 9
        s.insert(0, dept);
        System.out.println(s); // returns 5Gpawanetr41.41.3535ueeksforGeeks
    }
}