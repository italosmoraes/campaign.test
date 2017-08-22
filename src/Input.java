
public class Input {
	int inputNumber = 0;
	static int id = 0;
	int[] segmentList = null;
	
	public Input(String number){
		id += 1;
		setInputNumber(Integer.parseInt(number));
		
	}

	public int getInputNumber() {
		return inputNumber;
	}

	public void setInputNumber(int inputNumber) {
		this.inputNumber = inputNumber;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Input.id = id;
	}

	public int[] getSegmentList() {
		return segmentList;
	}

	public void setSegmentList(int[] segmentList) {
		this.segmentList = segmentList;
	}
}
