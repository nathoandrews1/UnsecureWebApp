package com.example.sap_project_apache;

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


        //This is a loop that will check each character of the string passed into this function
        //It will make sure that known illegal characters that can be used for injection are not
        //passed or used in the system. This way we can return a true or false value and act
        //accordingly anywhere in the program. IF False test failed alert user and redirect back
        //IF true redirect successful
        //This is a known defense against XSS injection and all form input details must be sanitized
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
