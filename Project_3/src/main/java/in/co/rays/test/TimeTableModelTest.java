package in.co.rays.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.dto.TimeTableDTO;
import in.co.rays.exception.ApplicationException;
import in.co.rays.exception.DuplicateRecordException;
import in.co.rays.model.ModelFactory;
import in.co.rays.model.TimeTableModelHibImpl;
import in.co.rays.model.TimeTableModelInt;

public class TimeTableModelTest {
	
	public static TimeTableModelInt model = new TimeTableModelHibImpl();
	
	//public static TimetableModelInt model = ModelFactory.getInstance().getTimetableModel();

	/**
	 * Main method to call test methods.
	 * 
	 * @param args
	 * @throws ParseException
	 * @throws DuplicateRecordException
	 */
	public static void main(String[] args) throws ParseException, DuplicateRecordException {

		testAdd();
		// testDelete();
		// testUpdate();
		// testFindByPK();
		 //testFindByCSS();
		//testFindByCSE();
		//testSearch();
		// testList();

	}


	/**
	 * Tests add a Timetable
	 * 
	 * @throws ParseException
	 */
	public static void testAdd() throws ParseException {

		try {
			TimeTableDTO dto = new TimeTableDTO();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

			// dto.setId(1L);

			dto.setCourseId(1L);
			dto.setCourseName("BSC");
			dto.setSubjectId(1L);
			dto.setSubjectName("Maths");
			dto.setSemester("3rd");
			dto.setExamTime("1 to 3");
			dto.setExamDate(sdf.parse("22/02/2020"));
			dto.setCreatedBy("pavanpatidar8080@gmail.com");
			dto.setModifiedBy("pavanpatidar8080@gmail.com");
			dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
			dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
			long pk = model.add(dto);
			if (pk == 0) {
				System.out.println("Test add fail");
			} else {
				System.out.println("Test add succ");

			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests delete a Timetable
	 */
	public static void testDelete() {

		try {
			TimeTableDTO dto = new TimeTableDTO();
			long pk = 3L;
			dto.setId(pk);
			model.delete(dto);
			System.out.println("Test Delete succ");

			TimeTableDTO deletedDto = model.findByPK(pk);
			if (deletedDto != null) {
				System.out.println("Test Delete fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests update a Timetable
	 * 
	 * @throws DuplicateRecordException
	 */
	public static void testUpdate() throws DuplicateRecordException {

		try {
			TimeTableDTO dto = model.findByPK(1);
			//dto.setId(1);
			dto.setCourseId(1);
			dto.setSubjectId(1);
			dto.setCreatedBy("root");
			dto.setModifiedBy("root");
			dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
			dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
			model.update(dto);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests find a Timetable by PK.
	 */
	public static void testFindByPK() {
		try {
			TimeTableDTO dto = new TimeTableDTO();
			long pk = 1L;
			dto = model.findByPK(pk);
			if (dto == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(dto.getId());
			System.out.println(dto.getCreatedBy());
			System.out.println(dto.getCreatedDatetime());
			System.out.println(dto.getModifiedBy());
			System.out.println(dto.getModifiedDatetime());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Tests find a Timetable by CSS.
	 */
	/*
	 * public static void testFindByCSS() { try { TimeTableDTO dto = new
	 * TimeTableDTO(); long pk = 1L; dto =
	 * model.findByCSS("Btech","M-Science","3rd"); if (dto == null) {
	 * System.out.println("Test Find By PK fail"); }
	 * System.out.println(dto.getExamDate());
	 * System.out.println(dto.getCourseName()+dto.getSubjectName());
	 * System.out.println(dto.getId()); System.out.println(dto.getCreatedBy());
	 * System.out.println(dto.getCreatedDatetime());
	 * System.out.println(dto.getModifiedBy());
	 * System.out.println(dto.getModifiedDatetime()); } catch (ApplicationException
	 * e) { e.printStackTrace(); }
	 * 
	 * } public static void testFindByCSE() throws ParseException { try {
	 * SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	 * 
	 * 
	 * TimeTableDTO dto = new TimeTableDTO(); dto =
	 * model.findByCSE("Btech","M-Science",sdf.parse("02/10/2021")); if (dto ==
	 * null) { System.out.println("Test Find By PK fail"); } else{
	 * System.out.println(dto.getExamDate());
	 * System.out.println(dto.getCourseName()+dto.getSubjectName());
	 * System.out.println(dto.getId()+"-------------");
	 * System.out.println(dto.getCreatedBy());
	 * System.out.println(dto.getCreatedDatetime());
	 * System.out.println(dto.getModifiedBy());
	 * System.out.println(dto.getModifiedDatetime()); }} catch (ApplicationException
	 * e) { e.printStackTrace(); }
	 * 
	 * }
	 * 
	 */	
	
	/**
	 * Tests get Search
	 */
	public static void testSearch() {

		try {
			TimeTableDTO dto = new TimeTableDTO();
			List list = new ArrayList();
			dto.setCourseName("Btech");
			list = model.search(dto, 0, 0);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				dto = (TimeTableDTO) it.next();
				System.out.println(dto.getId());
			System.out.println(dto.getSubjectName());
				System.out.println(dto.getCreatedBy());
				System.out.println(dto.getCreatedDatetime());
				System.out.println(dto.getModifiedBy());
				System.out.println(dto.getModifiedDatetime());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests get List.
	 */
	public static void testList() {

		try {
			TimeTableDTO dto = new TimeTableDTO();
			List list = new ArrayList();
			list = model.list(0, 10);
			if (list.size() < 0) {
				System.out.println("Test list fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				dto = (TimeTableDTO) it.next();
				System.out.println(dto.getId());
				System.out.println(dto.getCreatedBy());
				System.out.println(dto.getCreatedDatetime());
				System.out.println(dto.getModifiedBy());
				System.out.println(dto.getModifiedDatetime());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

}