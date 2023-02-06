package com.example.tango.Tango.service;

import java.math.BigDecimal;
import java.util.*;

class BigDecimalSorting{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        BigDecimal[] r = new BigDecimal[n];
        Map<String,BigDecimal> valueMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();
        for(int i=0;i<n;i++){
           r[i]= new BigDecimal(s[i]);
           valueMap.put(s[i], new BigDecimal(s[i]));
           countMap.compute(s[i], (k,v) -> v==null ? 1 : v+1);
        }
        //System.out.println("countmapLength: " + countMap.size());
        String[] sortedEntries = valueMap.entrySet().stream()
            .sorted((v1,v2) -> v2.getValue().compareTo(v1.getValue()))
            .map(e -> e.getKey())
            .toArray(String[]::new);
       
        int totalCount = 0;
        for(int entryIndex = 0; entryIndex < sortedEntries.length; entryIndex++){
            String sortedEntry = sortedEntries[entryIndex];
            int entryCount = countMap.get(sortedEntry);
            //System.out.println("entry: "+sortedEntry);
            //System.out.println("count: "+entryCount);
            for(int countIndex = 1; countIndex <= entryCount; countIndex++) {
                s[totalCount++]= sortedEntry;
            }
        }
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}