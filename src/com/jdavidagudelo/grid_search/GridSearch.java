package com.jdavidagudelo.grid_search;


public class GridSearch {
    public String getPatternExistenceString(String[] g, String[] p) {
        int R = g.length;
        int C = g[0].length();
        int r = p.length;
        int c = p[0].length();
        for(int i = 0; i <= R - r; i++){
            int start = 0;
            String current = p[0];
            while(start <= C - c) {
                boolean equals = true;
                for(int k = 0; k < current.length(); k++){
                    equals = equals && current.charAt(k) == g[i].charAt(start + k);
                }
                if(equals){
                    for(int k = 1; k < p.length; k++){
                        String s = p[k];
                        for(int l = 0; l < s.length(); l++){
                            equals = equals && s.charAt(l) == g[i + k].charAt(start + l);
                        }
                    }
                    if(equals){
                        return "YES";
                    }
                }
                start++;
            }

        }
        return "NO";
    }
    public static void main(String[] args) {
        String[] g = {"7283455864",
                "6731158619",
                "8988242643",
                "3830589324",
                "2229505813",
                "5633845374",
                "6473530293",
                "7053106601",
                "0834282956",
                "4607924137"};
        String[] p = {"9505",
                "3845",
                "3530"};
        GridSearch obj = new GridSearch();
        String result = null;//obj.getPatternExistenceString(g, p);
        //System.out.println(result);
        String[] gx = {"123412",
                "561212",
                "123634",
                "781288"};
        String[] px = {"12",
                "34"};
        result = obj.getPatternExistenceString(gx, px);
        System.out.println(result);

    }
}
