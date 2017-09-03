package 笔试.微众;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class 矩形判断 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			HashSet<String> set = new HashSet<>();
			HashSet<String> x = new HashSet<>();
			HashSet<String> y = new HashSet<>();
			List<Point> list = new ArrayList<>();
			boolean flag = false;
			for(int i=0;i<4;i++){
				String[] content = in.nextLine().split(" ");
				x.add(content[0]);
				x.add(content[2]);
				y.add(content[1]);
				y.add(content[3]);
				set.add(content[0]+"_"+content[1]);
				set.add(content[2]+"_"+content[3]);
				if((content[0]+"_"+content[1]).equals(content[2]+"_"+content[3]))
					flag = true;
				
				Point point1 = new Point();
				Point point2 = new Point();
				point1.x = Integer.valueOf(content[0]);
				point1.y = Integer.valueOf(content[1]);
				point2.x = Integer.valueOf(content[2]);
				point2.y = Integer.valueOf(content[3]);
 			}
			
			if(flag)
				System.out.println("NO");
			else if(x.size()!=2)
				System.out.println("NO");
			else if(y.size()!=2)
				System.out.println("NO");
			else if(set.size()!=4)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
		
	}
}

class Point{
	int x;
	int y;
}
