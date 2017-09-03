package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 	题目描述：
 	Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * @author zhenlanghuo
 *
 */
public class max_points_on_a_line {
	public static void main(String[] args) {
		Point[] points = {new Point(2,3),new Point(3,3),new Point(-5,3)};
		System.out.println(maxPoints(points));
		
	}
	
	public static int maxPoints(Point[] points) {
	       int max = 0;
	       for(int i=0;i<points.length;i++){
            Map<Double, Integer> map = new HashMap<>();
	           int overlap = 1; //重叠数目
	           int vertical = 0; //垂直点数目
	           int curmax = 1;
	           System.out.println("i:"+i);
	           for(int j=i+1;j<points.length;j++){
	               if(isPointsEquals(points[i],points[j])){
	                   overlap++;
	                   curmax++;
	               }
	               else if(!isPointsSlopeExist(points[i],points[j])){
	            	   vertical++;
	            	   if(curmax<vertical+overlap)
	            		   curmax = vertical+overlap;
	               }
	               else{
	            	   double k = ((double)(points[i].y-points[j].y)/(points[i].x-points[j].x));
	            	   if(Math.abs(k) == 0.0)
	            		   k = 0.0;
	            	   //System.out.println("k:"+k);
	            	   if(map.containsKey(k)){
	            		   Integer sum = map.get(k);
	            		   map.put(k,sum+1);
	            	   }
	            	   else{
	            		   map.put(k,1);
	            	   }
	            	
	            	   if(curmax<Math.max(overlap+map.get(k), overlap+vertical))
	            		   curmax = Math.max(overlap+map.get(k), overlap+vertical);
	               }
	           }
            
	           if(curmax>max)
	        	   max = curmax;
	       }
	       
	       return max;
	    }
	    
	    //两个点是否是同一个点（重叠）
	    public static boolean isPointsEquals(Point x,Point y){
	        if(x.x == y.x && x.y == y.y)
	            return true;
	        else
	            return false;
	    }
	    
	    //两个点的斜率是否存在（垂直x轴）
	    public static boolean isPointsSlopeExist(Point x,Point y){
	        if(x.x == y.x)
	            return false;
	        else
	            return true;
	    }
}

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
