package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/**
 * 
 * 	Given a collection of integers that might contain duplicates, S, return all possible subsets.
	Note:
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.

	For example,
	If S =[1,2,2], a solution is:
	[
  		[2],
  		[1],
  		[1,2,2],
  		[2,2],
  		[1,2],
  		[]
	]
 * 
 * @author zhenlanghuo
 *
 */
public class subset_II {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		ArrayList<Integer> nill = new ArrayList<>();
		result.add(nill);
		
		Arrays.sort(num);
		
		for(int i=0;i<num.length;i++) {
			int size = result.size();
			for(int j=0;j<size;j++) {
				ArrayList<Integer> temp = new ArrayList<>(result.get(j));
				temp.add(num[i]);
				result.add(temp);
			}
		}
		
		
		
		Collections.sort(result, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				int o1Size = o1.size();
				int o2Size = o2.size();
				if(o1Size!=o2Size) return Integer.compare(o1Size, o2Size);
				else {
					for(int i=0;i<o1Size;i++) {
						int comp = Integer.compare(o1.get(i), o2.get(i));
						if (comp != 0) return comp;
					}
				}
				return 0;
			}
		});
		
		
		
		return result;
    }
}
