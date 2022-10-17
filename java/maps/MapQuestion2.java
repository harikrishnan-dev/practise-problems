//Question:
//Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B.
//For the elements not present in B, append them at last in sorted order.
//Return the array A after sorting from the above method.
//NOTE: Elements of B are unique.


public class MapQuestion2 {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        SortedMap<Integer, Integer> mp = new TreeMap<Integer, Integer>();

//        Store the elements of A in hashmap
        for(int i=0;i<A.size();i++){
            if(mp.containsKey(A.get(i))){
                int v = mp.get(A.get(i));
                v=v+1;
                mp.put(A.get(i), v);
            }else{
                mp.put(A.get(i),1);
            }
        }

//        If the elements of B are present in the hashmap then add them to the answer.
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<B.size();i++){
            if(mp.containsKey(B.get(i))){
                int val = mp.get(B.get(i));
                while(val>0){
                    ans.add(B.get(i));
                    val--;
                }
                mp.put(B.get(i), 0);
            }
        }

//        The remaining keys in the hashmap needs to be added to the answer ensuring the order of the remaining keys are sorted.
//        Since we are using Sorted map the ordering is taken care of
        for (Integer k: mp.keySet()) {
            if (mp.get(k)==0){
                continue;
            }else{
                int m = mp.get(k);
                while(m>0){
                    ans.add(k);
                    m--;
                }
            }
        }

        return ans;
    }
}
