package com.jdavidagudelo.sherlock_valid_string;

import java.util.*;

public class SherlockValidString {
    private String isValid(String s){
        int[] f = new int[26];
        for(int i = 0; i < s.length(); i++){
            f[s.charAt(i) - 'a']++;
        }
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for(int fi: f){
            if(fi > 0){
                Integer v = frequencies.get(fi);
                if(v == null){
                    v = 0;
                }
                frequencies.put(fi, v + 1);
            }
        }
        if(frequencies.size() > 2){
            return "NO";
        }
        if(frequencies.size() == 2){
            int[] d = new int[2];
            int[] v = new int[2];
            int k = 0;
            for(int key: frequencies.keySet()){
                d[k] = frequencies.get(key);
                v[k] = key;
                k += 1;
            }
            return Math.abs(v[0] - v[1]) <= 1  && (d[0] == 1 || d[1] == 1) || (d[0] == 1 && v[0] == 1 || d[1] == 1 && v[1] == 1)? "YES": "NO";
        }
        return "YES";
    }
    public static void main(String[] args){
        SherlockValidString obj = new SherlockValidString();
        System.out.println(obj.isValid("aabbcd"));
        System.out.println(obj.isValid("aabbccddeefghi"));
        System.out.println(obj.isValid("abcdefghhgfedecba"));
        System.out.println(obj.isValid("aaaabbcc"));
        System.out.println(obj.isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd"));
        System.out.println(obj.isValid("aaaaabc"));
    }
}
