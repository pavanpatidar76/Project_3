package in.co.rays.model;

import java.util.Date;
import java.util.List;

import in.co.rays.dto.TimeTableDTO;
import in.co.rays.exception.ApplicationException;
import in.co.rays.exception.DuplicateRecordException;

public class TimeTableModelJDBCImpl implements TimeTableModelInt {

	public long add(TimeTableDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void update(TimeTableDTO dto) throws ApplicationException, DuplicateRecordException {
		// TODO Auto-generated method stub

	}

	public void delete(TimeTableDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub

	}

	public TimeTableDTO findByPK(long pk) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List search(TimeTableDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List search(TimeTableDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List list() throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeTableDTO findByCSS(String coursename, String subname, String sem) {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeTableDTO findByCSE(String course, String subject, Date examDate) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeTableDTO checkByCourseName(long CourseId, Date ExamDate) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeTableDTO checkBySubjectName(long CourseId, long SubjectId, Date ExamDate) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeTableDTO checkBysemester(long CourseId, long SubjectId, String semester, Date ExamDate)
			throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeTableDTO name(String emailId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeTableDTO checkByExamTime(long courseId, long subjectId, String semester, Date examDate, String examTime,
			String description) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
