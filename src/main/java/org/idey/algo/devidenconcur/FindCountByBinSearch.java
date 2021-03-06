package org.idey.algo.devidenconcur;

public class FindCountByBinSearch {

    //O(logN) complexity
    public static <T> int findCountFirst(T[] array, Predicate<T> predicate){
        int count=0;
        if(array!=null && array.length!=0){
            long start =0;
            long end = array.length -1;
            while(end>=start){
                int middle = (int)((end + start)/2);
                if((middle == array.length -1 ||
                        !predicate.process(array[middle+1])) && predicate.process(array[middle])){
                    count = middle+1;
                    break;
                }else{
                    if(!predicate.process(array[middle])){
                        end = middle -1;
                    }else{
                        start = middle +1;
                    }
                }
            }
        }
        return count;
    }


    //O(logN) complexity
    public static <T> int findCountLast(T[] array, Predicate<T> predicate){
        int count=0;
        if(array!=null && array.length!=0){
            long start =0;
            long end = array.length -1;
            while(end>=start){
                int middle = (int)((end + start)/2);
                if((middle == 0 ||
                        !predicate.process(array[middle-1])) && predicate.process(array[middle])){
                    count = array.length - middle;
                    break;
                }else{
                    if(!predicate.process(array[middle])){
                        start = middle +1;
                    }else{
                        end = middle -1;
                    }
                }
            }
        }
        return count;
    }



    public static void main(String[] args){
        System.out.println(findCountFirst(new Integer[]{2,4,109,107,105,111,121,123}, new Predicate<Integer>() {
            @Override
            public boolean process(Integer obj) {
                return (obj % 2)==0;
            }
        }));

        System.out.println(findCountLast(new Integer[]{1,2,4,6,122,124}, new Predicate<Integer>() {
            @Override
            public boolean process(Integer obj) {
                return (obj % 2)==0;
            }
        }));

    }


}
