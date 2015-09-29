package fancy4.taskie.model;

public class TaskieLogic {
	static String[] data = {"order pizza","finish PS3","finish 5km","kill bill"};
	
	public static String[] getTask() {
		
		return data;
	}
	
	public static String[] getTask2() {
	
		String[] data = {"ordasdfer pizza","fiasdfnish PS3","fisdgewnish 5km","kiasdxzcll bill"};
		return data;
	}
	
	public static String[] getTask3() {
		String[] data = {"pizza","fiasdfnish PS3","fisdgewnish 5km","kiasdxzcll bill"};
		return data;
	}
	public static int getLen() {
		return data.length;
	}
	
	public static void initialize() {
		
	}
	public static String[] execute(String cmd) {
		String[] result = {}; 
		if (cmd == "view all") {
			result = getTask2();
		} else if (cmd == "view 1") {
			result = getTask3();
		}else if (cmd == "view") {
			result = getTask();
		}
		
		System.out.println("received");
		return result;
	}
}
