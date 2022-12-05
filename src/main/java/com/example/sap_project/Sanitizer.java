package com.example.sap_project;

import java.util.ArrayList;

public class Sanitizer {
    static ArrayList<Character> illegalChars = new ArrayList<>();

    public Sanitizer()
    {
        illegalChars.add('<');
        illegalChars.add('>');
        illegalChars.add('?');
        illegalChars.add('#');
        illegalChars.add('&');
        illegalChars.add('$');
        illegalChars.add('|');
        illegalChars.add('/');
    }

    public static Boolean checkString(String in)
    {
        StringBuffer buffer = new StringBuffer(in);

        for(int i = 0; i < buffer.length() - 1; i++)
        {
            if(illegalChars.contains(buffer.charAt(i)))
            {
                //False means it failed the test
                return false;
            }
        }

        //True means it passed the test.
        return true;
    }
}
