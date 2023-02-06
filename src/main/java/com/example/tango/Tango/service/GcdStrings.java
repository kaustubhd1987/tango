package com.example.tango.Tango.service;

class GcdStrings {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.equalsIgnoreCase(str2)){
            return str1;
        }
        int length1 = str1.length();
        int length2 = str2.length();
        if(length1 == length2) {
            return "";
        }
        
        int smallLength = length1 < length2 ? length1 : length2;
        int largeLength = length1 > length2 ? length1 : length2;
        int gcdLength = fingGcd(smallLength, largeLength);
        System.out.println("GCD: "+gcdLength);
        //String small = length1 < length2 ? str1 : str2;
        //String large = length1 > length2 ? str1 : str2;
        String gcd = str1.substring(0,gcdLength);
        int count1 = getFrequency(gcd, str1);
        int count2 = getFrequency(gcd, str2);
        System.out.println("count1: "+count1);
        System.out.println("count2: "+count2);
        int expCount1 = str1.length() / gcdLength;
        int expCount2 = str2.length() / gcdLength;
        if(count1 == expCount1 && count2 == expCount2) {
            return gcd;
        }
       
        return "";
    }
    private static int fingGcd(int small, int large ) {
        int gcd = small;
        for(int i = small; i > 1 ; i--) {
            if(small%i == 0 && large%i == 0 ){
                return i;
            }
        }
        return 1;
    }
   /* private static int getFrequency(String subString, String mainString ) {
        Pattern pattern = Pattern.compile(subString);
        Matcher match = pattern.matcher(mainString);
        int startIndex = 0, count = 0;
        while(match.find(startIndex)){
            count++;
            startIndex = match.start() + 1;
        }
        return count;
    }*/
    private static int getFrequency(String subString, String mainString ) {
        return mainString.split(subString, -1).length -1;
    }
}
