package 美团算法大赛;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class 音乐研究 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		List<Integer> first = new ArrayList<>();
		List<Integer> second = new ArrayList<>();
		int firstSize = in.nextInt();
		for(int i=0;i<firstSize;i++){
			first.add(in.nextInt());
		}
		int secondSize = in.nextInt();
		for(int i=0;i<secondSize;i++){
			second.add(in.nextInt());
		}
		
		PriorityQueue<Holder> priorityQueue = new PriorityQueue<>();
		for(int i=0;i<=second.size()-firstSize;i++){
			int dif = (int) Math.pow((double)(first.get(0)-second.get(i)), 2.0);
			Holder holder = new Holder(0, i, dif);
			priorityQueue.add(holder);
		}
		
		while(true){
			Holder holder = priorityQueue.poll();
			if(holder.length==firstSize){
				System.out.println(holder.dif);
				break;
			}
			else{
				holder.length++;
				holder.firstIndex++;
				holder.secondIndex++;
				holder.dif += (int) Math.pow((double)(first.get(holder.firstIndex)-second.get(holder.secondIndex)), 2.0);
				priorityQueue.add(holder);
			}
		}
 	}
	
	
}

class Holder implements Comparable<Holder>{
	int length;
	int firstIndex;
	int secondIndex;
	Integer dif;
	
	public Holder(int firstIndex,int secondIndex,int dif) {
		length = 1;
		this.firstIndex = firstIndex;
		this.secondIndex = secondIndex;
		this.dif = dif;
	}
	
	@Override
	public int compareTo(Holder o) {
		return dif.compareTo(o.dif);
	}
	
	
}
