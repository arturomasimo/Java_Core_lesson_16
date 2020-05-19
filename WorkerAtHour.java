package lession16;

public class WorkerAtHour extends Worker implements Salary {
	private int countOfHour;
	private float costPerHour;
	public float premia;// 1-100%

	
	public WorkerAtHour(String pib, String posada, int countOfHour, float costPerHour, float premia) {
		super(pib, posada);
		this.countOfHour = countOfHour;
		this.costPerHour = costPerHour;
		this.premia = premia;
	}

	@Override
	public float calculation() {
		return countOfHour * costPerHour +countOfHour * costPerHour * premia/100;
	}

	@Override
	public String toString() {
		return super.toString() + countOfHour + "*" + costPerHour + " + premia " + premia+ "%]";
	}

	
	
}
