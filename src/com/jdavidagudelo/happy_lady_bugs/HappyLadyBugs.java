package com.jdavidagudelo.happy_lady_bugs;


public class HappyLadyBugs {

    private String getLadyBugsHappy(String s){
        int[] f = new int[26];
        s = s.toLowerCase();
        int empty = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != '_') {
                f[s.charAt(i) - 'a']++;
            }
            else{
                empty++;
            }
        }
        if(empty > 0){
            for(int fi: f){
                if(fi == 1){
                    return "NO";
                }
            }
            return "YES";
        }
        boolean isHappy = true;
        for(int i = 0; i < s.length(); i++){
            isHappy = isHappy && ((i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) || (
                    i > 0 && s.charAt(i) == s.charAt(i - 1)));
        }
        return isHappy? "YES": "NO";
    }
    public static void main(String[] args){
        HappyLadyBugs obj = new HappyLadyBugs();
        System.out.println(obj.getLadyBugsHappy("RBY_YBR"));
    }
}
