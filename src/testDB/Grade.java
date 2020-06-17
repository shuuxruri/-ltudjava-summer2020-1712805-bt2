package testDB;

public class Grade {
	private Classroom classId;
	private SV Mssv;
	private float midterm;
	private float finalTerm;
	private float otherPoint;
	private float total;
	private int Id;
	public Grade() {
		// TODO Auto-generated constructor stub
		
	}

	public Classroom getClassId() {
		return classId;
	}

	public void setClassId(Classroom classId) {
		this.classId = classId;
	}

	
	/**
	 * @return the midterm
	 */
	public float getMidterm() {
		return midterm;
	}

	/**
	 * @param midterm the midterm to set
	 */
	public void setMidterm(float midterm) {
		this.midterm = midterm;
	}

	/**
	 * @return the finalTerm
	 */
	public float getFinalTerm() {
		return finalTerm;
	}

	/**
	 * @param finalTerm the finalTerm to set
	 */
	public void setFinalTerm(float finalTerm) {
		this.finalTerm = finalTerm;
	}

	/**
	 * @return the otherPoint
	 */
	public float getOtherPoint() {
		return otherPoint;
	}

	/**
	 * @param otherPoint the otherPoint to set
	 */
	public void setOtherPoint(float otherPoint) {
		this.otherPoint = otherPoint;
	}

	/**
	 * @return the total
	 */
	public float getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(float total) {
		this.total = total;
	}

	/**
	 * @return the mssv
	 */
	public SV getMssv() {
		return Mssv;
	}

	/**
	 * @param mssv the mssv to set
	 */
	public void setMssv(SV mssv) {
		Mssv = mssv;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

}
