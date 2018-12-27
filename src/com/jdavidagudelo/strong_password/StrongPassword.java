package com.jdavidagudelo.strong_password;

public class StrongPassword {

    public int minimumAdded(String s){
        String numbers = "0123456789";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-+";
        boolean hasDigit = false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasSpecialCharacter = false;
        for(int i = 0; i < s.length(); i++){
            String current = s.substring(i, i+1);
            hasDigit = hasDigit || numbers.contains(current);
            hasLowerCase = hasLowerCase || lowerCase.contains(current);
            hasUpperCase = hasUpperCase || upperCase.contains(current);
            hasSpecialCharacter = hasSpecialCharacter || specialCharacters.contains(current);
        }
        int count = 0;
        if(!hasDigit){
            count += 1;
        }
        if(!hasLowerCase){
            count += 1;
        }
        if(!hasUpperCase){
            count += 1;
        }
        if(!hasSpecialCharacter){
            count += 1;
        }
        if(s.length() + count < 6){
            count = 6 - s.length();
        }
        return count;
    }

    public static void main(String[] args){
        StrongPassword obj = new StrongPassword();
        System.out.println(obj.minimumAdded("Ab1"));
        System.out.println(obj.minimumAdded("#HackerRank"));
    }
}
