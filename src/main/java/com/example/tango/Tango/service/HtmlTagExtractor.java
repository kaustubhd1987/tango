package com.example.tango.Tango.service;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HtmlTagExtractor{
	
    public static boolean checkTagMatches(String text){
        String[] words = text.split("<{1}/?|>");
        String openingTag = words[1];
        String closingTag = words[words.length-1];
        //System.out.println(openingTag);
        //System.out.println(closingTag);
        return openingTag.equals(closingTag);
    }
    
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
        Pattern pattern
            //= Pattern.compile("<[a-zA-Z0-9\\s]+>[\\w\\s]+</[a-zA-Z0-9\\s]+>");
            = Pattern.compile("<[^<>]+>[^<>]+</[^<>]+>");
		while(testCases>0){
			String line = in.nextLine();
            Matcher matcher = pattern.matcher(line);
            int count = 0;
            while (matcher.find()) {
               String matchedText = matcher.group();
               //System.out.println(matchedText);
               boolean tagMatches = checkTagMatches(matchedText);
               if(tagMatches) {
                   int start = matchedText.indexOf(">") + 1;
                    int end = matchedText.indexOf("</");
                    String tagText = matchedText.substring(start, end);
                    System.out.println(tagText);
                    count++;
               }
            }
            if(count == 0){
                System.out.println("None");
            }
			testCases--;
		}
	}
}




