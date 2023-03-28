class Solution {
    public static int romanToInt(String s) {
        int outInt = 0;
        ArrayList <Integer> compList = getCompList(s);
        //outInt = compList.get(1);
        compList = resolveOrder(compList);
        outInt = getSum(compList);
        return outInt;
    }

    public static ArrayList <Integer> getCompList(String s){
       ArrayList <Integer> compList = new ArrayList<Integer>();
       for(int charCtr = 0; charCtr < s.length(); charCtr++){
           char currChar = s.charAt(charCtr);
           int comp = 0;
           switch (currChar){
               case 'I':
                   comp = 1;
                   break;
               case 'V':
                   comp = 5;
                   break;
               case 'X':
                   comp = 10;
                   break;
               case 'L':
                   comp = 50;
                   break;
               case 'C':
                   comp = 100;
                   break;
               case 'D':
                   comp = 500;
                   break;
               case 'M':
                   comp = 1000;
                   break;
           }
           compList.add(comp);
       }
       return compList;
    }
    
    public static ArrayList <Integer> resolveOrder(ArrayList<Integer> compList){
        try {
            for(int compCtr = 0; compCtr < compList.size() - 1; compCtr++){
                int currComp = compList.get(compCtr);
                int nextComp = compList.get(compCtr+1);
                if(currComp < nextComp){
                    compList.set(compCtr + 1, nextComp - currComp);
                    compList.remove(compCtr);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return compList;
    }

    public static int getSum(ArrayList<Integer> compList){
        int outInt = 0;
        for(int compCtr = 0; compCtr < compList.size(); compCtr++){
            outInt += compList.get(compCtr);
        }
        return outInt;
    }
}
