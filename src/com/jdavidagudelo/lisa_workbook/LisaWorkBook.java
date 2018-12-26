package com.jdavidagudelo.lisa_workbook;

public class LisaWorkBook {
    public int getSpecial(int k, int[] problems_per_chapter){
        int n = problems_per_chapter.length;
        int currentPage = 0;
        int count = 0;
        for(int problems: problems_per_chapter){
            int currentIndex = 0;
            while(problems >= k){
                problems -= k;
                currentPage += 1;

                if(currentPage >= currentIndex + 1 && currentPage <= currentIndex + k){
                    count++;
                }
                currentIndex += k;
            }
            if(problems > 0){
                currentPage += 1;
                if(currentPage >= currentIndex + 1 && currentPage <= currentIndex + problems){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] data = {4, 2, 6, 1, 10};
        int k = 3;
        LisaWorkBook obj = new LisaWorkBook();
        int result = obj.getSpecial(k, data);
        System.out.println(result);
    }
}
