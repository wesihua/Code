package test;

public class 枚举类型 {
	public static void main(String args[]) {
		Day day = Day.valueOf("MONDAY");
		
		System.out.println(day.toString());
		
		switch (day) {
		case MONDAY:
			System.out.println("星期一");
			break;
		case TUESDAY:
			System.out.println("星期二");
			break;
		case WEDNESDAY:
			System.out.println("星期三");
			break;
		case THURSDAY:
			System.out.println("星期四");
			break;
		case FRIDAY:
			System.out.println("星期五");
			break;
		case SATURDAY:
			System.out.println("星期六");
			break;
		case SUNDAY:
			System.out.println("星期天");
			break;
		default:
			break;
		}
	}
}

enum Day {
	MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
