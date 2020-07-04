package testDB;

import java.io.Serializable;

public class subjectClassId implements Serializable {

	private Classroom classId;
	private Subject subjectId;
	public subjectClassId() {
		// TODO Auto-generated constructor stub
	}
	public Classroom getClassId() {
		return classId;
	}
	public void setClassId(Classroom ClassId) {
		classId = ClassId;
	}
	public Subject getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Subject subjectId) {
		this.subjectId = subjectId;
	}
	public subjectClassId(Subject sj, Classroom cl)
	{
		classId = cl;
		subjectId = sj;
	}
	public subjectClassId(subjectClassId scl)
	{
		classId = scl.getClassId();
		subjectId = scl.getSubjectId();
	}

}
