package testDB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Grade implements Serializable {
	private svClassroomId idKey;
	private float midterm;
	private float finalTerm;
	private float otherPoint;
	private float total;
	private int Id;
	public Grade() {
		// TODO Auto-generated constructor stub
		
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

	public svClassroomId getidKey() {
		return idKey;
	}

	public void setidKey(svClassroomId idkey) {
		idKey = idkey;
	}
	public Grade(svClassroomId key, float GK,float CK,float Other,float Sum) {
		idKey = key;
		midterm = GK;
		finalTerm = CK;
		otherPoint = Other;
		total = Sum;
	}
	public Grade(int id,SV sv, Classroom cl, float GK,float CK,float Other,float Sum) {
		idKey = new svClassroomId(sv,cl);
		midterm = GK;
		finalTerm = CK;
		otherPoint = Other;
		total = Sum;
		Id = id;
	}
	public void output() {
		SV sv = idKey.getMssv();
		System.out.println("Mssv: "+sv.getMssv());
		System.out.println("Họ tên: "+sv.getName());
		System.out.println("Điểm giữa kỳ: "+midterm);
		System.out.println("Điểm cuối kỳ: "+finalTerm);
		System.out.println("Điểm khác: "+otherPoint);
		System.out.println("Tổng điểm: "+total);
		
	}
	

}
