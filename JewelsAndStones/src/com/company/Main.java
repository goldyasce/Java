package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public int numJewelsInStones(String J, String S) {
        ArrayList<String> listOfJewels = new ArrayList<>();
        ArrayList<String> listOfStones = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < J.length(); i++){
            if(!(i == J.length() - 1)) {
                listOfJewels.add(J.substring(i, i + 1));
            }else{
                listOfJewels.add(J.substring(i));
            }
        }

        for(int i = 0; i < S.length(); i++){
            if(!(i == J.length() - 1)) {
                listOfStones.add(J.substring(i, i + 1));
            }else{
                listOfStones.add(J.substring(i));
            }
        }

        for(String jewel : listOfJewels){
            for(String stone : listOfStones){
                if(jewel == stone){
                    count++;
                }
            }
        }


        return count;
    }

    public int numUniqueEmails(String[] emails) {
        int count = 0;

        for(String email : emails){
            ArrayList<String> listOfMail = new ArrayList<>();
            for(int i = 0; i < email.length(); i++){
                if(email.charAt(i) == '@'){
                    listOfMail.add(email.substring(i, i + 1));
                }else{
                    listOfMail.add(email.substring(i));
                }
            }

            for(String ch : listOfMail){
                if(ch.equals('.')){

                }
            }
        }



        return count;
    }
}
