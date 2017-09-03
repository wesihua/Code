package 笔试.百度;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 寻找三角形 {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = Integer.valueOf(in.nextLine());
		List<Point> points_r = new ArrayList<>();
		List<Point> points_g = new ArrayList<>();
		List<Point> points_b = new ArrayList<>();
		for(int i=0;i<n;i++){
			String[] content = in.nextLine().split(" ");
			Point point = new Point(Integer.valueOf(content[1]), Integer.valueOf(content[2]), Integer.valueOf(content[3]));
			if(content[0].equals("R"))
				points_r.add(point);
			else if(content[0].equals("G"))
				points_g.add(point);
			else if(content[0].equals("B"))
				points_b.add(point);	
		}
		
		double max = Double.MIN_VALUE;
		
		for(int i=0;i<points_r.size();i++){
			for(int j=0;j<points_g.size();j++){
				for(int k=0;k<points_b.size();k++){
					Point point_r = points_r.get(i);
					Point point_g = points_g.get(j);
					Point point_b = points_b.get(k);
					double a = getLength(point_r, point_g);
					double b = getLength(point_r, point_b);
					double c = getLength(point_g, point_b);
					if(a==0||b==0||c==0)
						continue;
					double p = (a+b+c)/2;
					double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
					if(s>max)
						max = s;
				}
			}
		}
		
		if(points_r.size()>=3){
			double temp = cal(points_r);
			if(temp>max)
				max = temp;
		}
		if(points_g.size()>=3){
			double temp = cal(points_g);
			if(temp>max)
				max = temp;
		}
		if(points_b.size()>=3){
			double temp = cal(points_b);
			if(temp>max)
				max = temp;
		}
			
		System.out.println(String.format("%.5f", max));
	}
	
	static double getLength(Point a,Point b){
		return Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2)+Math.pow(a.z-b.z, 2));
	}
	
	static double cal(List<Point> points){
		double max = Double.MIN_VALUE; 
		for(int i=0;i<points.size()-2;i++){
			for(int j=i+1;j<points.size()-1;j++){
				for(int k=j+1;k<points.size();k++){
					Point point_a = points.get(i);
					Point point_b = points.get(j);
					Point point_c = points.get(k);
					double a = getLength(point_a, point_b);
					double b = getLength(point_a, point_c);
					double c = getLength(point_c, point_b);
					if(a==0||b==0||c==0)
						continue;
					double p = (a+b+c)/2;
					double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
					if(s>max)
						max = s;
				}
			}
		}
		
		return max;
	}
}

class Point{
	int x;
	int y;
	int z;
	
	public Point(int x,int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
