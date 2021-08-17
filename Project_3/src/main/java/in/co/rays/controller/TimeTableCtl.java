package in.co.rays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.rays.dto.BaseDTO;
import in.co.rays.dto.TimeTableDTO;
import in.co.rays.exception.ApplicationException;
import in.co.rays.exception.DuplicateRecordException;
import in.co.rays.model.CourseModelInt;
import in.co.rays.model.ModelFactory;
import in.co.rays.model.SubjectModelInt;
import in.co.rays.model.TimeTableModelInt;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.ServletUtility;

/**
 * The TimeTableCtl Class
 * @author PAWAN PATIDAR
 *
 */
@WebServlet(name="TimeTableCtl",urlPatterns={"/ctl/TimeTableCtl"})
public class TimeTableCtl  extends BaseCtl{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(TimeTableCtl.class);
	
	/* (non-Javadoc)
	 * @see in.co.rays.controller.BaseCtl#preload(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected void preload(HttpServletRequest request) {

		CourseModelInt courseModel=ModelFactory.getInstance().getCourseModel();
		SubjectModelInt subjectModel=ModelFactory.getInstance().getSubjectModel();
		
		
		try {
			List courseList=courseModel.list();
			List sujectList=subjectModel.list();
			
			
			request.setAttribute("courseList", courseList);
			request.setAttribute("sujectList", sujectList);
			
			
			
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	
	
	
	/* (non-Javadoc)
	 * @see in.co.rays.controller.BaseCtl#validate(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected boolean validate(HttpServletRequest request) {
		System.out.println("in timetable validate");

		boolean pass =true;
		
		String  courseId =  request.getParameter("course");
		String  subjectId =  request.getParameter("subject");
		String  semester =  request.getParameter("semester");
		String  Exdate =  request.getParameter("examdate");
		String  examTime =  request.getParameter("examTime");
		String  description =  request.getParameter("description");
		
		if(DataValidator.isNull(courseId))
		{
		  request.setAttribute("course", "Please Select Course");
		  pass=false;
		}
		if(DataValidator.isNull(subjectId))
		{
		  request.setAttribute("subject", "Please Select Subject");
		  pass=false;
		}
		if(DataValidator.isNull(semester))
		{
		  request.setAttribute("semester", "Please Select Semester");
		  pass=false;
		}
		if(DataValidator.isNull(Exdate))
		{
		  request.setAttribute("examdate", "Please Select Exam Date");
		  pass=false;
		}
		if(DataValidator.isNull(examTime))
		{
		  request.setAttribute("examTime", "Please Select Exam Time");
		  pass=false;
		}
		if(DataValidator.isNull(description))
		{
		  request.setAttribute("description", "Please Select desciption");
		  pass=false;
		}
		
		return pass;
	
	}
	

	/* (non-Javadoc)
	 * @see in.co.rays.controller.BaseCtl#populateDTO(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected BaseDTO populateDTO(HttpServletRequest request) {
		   TimeTableDTO dto = new TimeTableDTO();
		   
		    String  courseId =  request.getParameter("course");
			String  subjectId =  request.getParameter("subject");
			String  semester =  request.getParameter("semester");
			String  Exdate =  request.getParameter("examdate");
			String  examTime =  request.getParameter("examTime");
			String  description =  request.getParameter("description");
			
			dto.setId(DataUtility.getLong(request.getParameter("id")));
			dto.setCourseId(DataUtility.getLong(courseId));
			dto.setSubjectId(DataUtility.getInt(subjectId));
			dto.setSemester(DataUtility.getString(semester));
			dto.setDescription(DataUtility.getString(description));
			dto.setExamTime(DataUtility.getString(examTime));
			System.out.println(examTime);
			System.out.println(courseId);
			
			if(!Exdate.equals(""))
			{
				dto.setExamDate(DataUtility.getDate(Exdate));	
			}
		    	
			dto.setExamTime(DataUtility.getString(examTime));
		    
			populateDateTime(dto,request);
			return dto;
	
	}
	
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		long id = DataUtility.getLong(request.getParameter("id"));
		TimeTableDTO dto=null;
		TimeTableModelInt model=ModelFactory.getInstance().getTimeTableModel();
		if(id>0)
		{
		  try {
			dto = model.findByPK(id);
			ServletUtility.setDto(dto, request);
			System.out.println(dto.getDescription());
			
		  } catch (Exception e) {
			e.printStackTrace();
		  }	
		}
		
	 ServletUtility.forward(getView(), request, response);	

	
	}


	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in timetable dopost");
		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));
		
		TimeTableDTO dto = (TimeTableDTO)populateDTO(request);
		TimeTableModelInt model = ModelFactory.getInstance().getTimeTableModel();
		
		if(OP_SAVE.equalsIgnoreCase(op)||OP_UPDATE.equalsIgnoreCase(op)){
		 
			if (OP_SAVE.equalsIgnoreCase(op)) {

				TimeTableDTO bean = (TimeTableDTO) populateDTO(request);

				TimeTableDTO bean1;
				TimeTableDTO bean2;
				TimeTableDTO bean3;
				try {
					bean1 = model.checkByCourseName(bean.getCourseId(), bean.getExamDate());

					bean2 = model.checkBySubjectName(bean.getCourseId(), bean.getSubjectId(), bean.getExamDate());

					bean3 = model.checkBysemester(bean.getCourseId(), bean.getSubjectId(), bean.getSemester(),
							bean.getExamDate());

					if (bean1 == null && bean2 == null && bean3 == null) {

						long pk = model.add(bean);
						bean.setId(pk);
						ServletUtility.setSuccessMessage("Data is successfully saved", request);
					} else {
						bean = (TimeTableDTO) populateDTO(request);
						ServletUtility.setDto(bean, request);
						ServletUtility.setErrorMessage("Exam already exist!", request);
					}

				} catch (ApplicationException e) {
					log.error(e);
					ServletUtility.handleException(e, request, response);
					return;
				} catch (DuplicateRecordException e) {
					ServletUtility.setDto(bean, request);
					ServletUtility.setErrorMessage("Exam already exist!", request);
				}

				  ServletUtility.forward(getView(), request, response);	
			} else if (OP_UPDATE.equalsIgnoreCase(op)) {

				TimeTableDTO bean = (TimeTableDTO) populateDTO(request);

				TimeTableDTO bean4;

				try {

					bean4 = model.checkByExamTime(bean.getCourseId(), bean.getSubjectId(), bean.getSemester(),
							bean.getExamDate(), bean.getExamTime(), bean.getDescription());

					if (id > 0 && bean4 == null) {
						model.update(bean);
						ServletUtility.setDto(bean, request);
						ServletUtility.setSuccessMessage("Data is successfully updated", request);
					} else {
						bean = (TimeTableDTO) populateDTO(request);
						ServletUtility.setDto(bean, request);
						ServletUtility.setErrorMessage("Exam already exist!", request);
					}

				} catch (ApplicationException e) {
					log.error(e);
					ServletUtility.handleException(e, request, response);
					return;
				} catch (DuplicateRecordException e) {
					ServletUtility.setDto(bean, request);
					ServletUtility.setErrorMessage("Exam already exist!", request);
				}

		  ServletUtility.forward(getView(), request, response);	
		}
		else if(OP_CANCEL.equalsIgnoreCase(op))
		{
			ServletUtility.redirect(ORSView.TIME_TABLE_LIST_CTL, request, response);
			return;
		}
				
		else if(OP_DELETE.equalsIgnoreCase(op))
		{
			try {
				model.delete(dto);
				ServletUtility.setSuccessMessage("Data Deleted Successfully", request);
			}catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
			ServletUtility.redirect(ORSView.TIME_TABLE_LIST_CTL, request, response);
			return;
		}else if(OP_RESET.equalsIgnoreCase(op))
		{
			  ServletUtility.redirect(ORSView.TIME_TABLE_CTL, request, response);	
			  return;
		}}

	
	}
	
	/* (non-Javadoc)
	 * @see in.co.rays.controller.BaseCtl#getView()
	 */
	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.TIME_TABLE_VIEW;
	}

	
	
	
	
}
