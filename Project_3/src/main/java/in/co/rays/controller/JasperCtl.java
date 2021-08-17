package in.co.rays.controller;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.impl.SessionImpl;

import in.co.rays.dto.UserDTO;
import in.co.rays.util.HibDataSource;
import in.co.rays.util.JDBCDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Servlet implementation class Jasper
 * 
 * @author PAWAN PATIDAR
 *
 */

@WebServlet(name = "JasperCtl", urlPatterns = { "/ctl/JasperCtl" })
public class JasperCtl extends BaseCtl {

	public JasperCtl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("DoGet Jasper  Report");
	try {
		JasperReport jasperReport = JasperCompileManager.compileReport("E:\\07_07_21 Project new 3\\Project_3\\src\\main\\webapp\\report\\Blank_A4.jrxml");
		
		HttpSession session = request.getSession(true);
		UserDTO dto = (UserDTO) session.getAttribute("user");
		dto.getFirstName();
		dto.getLastName();
		
		Map<String, Object> map = new HashMap();
		
		map.put("user",dto.getFirstName() + " " + dto.getLastName() );
		

		Connection conn = null;
		
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.system");
		
		String Database = rb.getString("DATABASE");
		if ("Hibernate".equalsIgnoreCase(Database)) {
			conn = ((SessionImpl) HibDataSource.getSession()).connection();
		}

		if ("JDBC".equalsIgnoreCase(Database)) {
			conn = JDBCDataSource.getConnection();
		}
	
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);
	byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);
	response.setContentType("application/pdf");
	response.getOutputStream().write(pdf);
	response.getOutputStream().flush();
} catch (Exception e) {
	e.printStackTrace();
}

		
	}
	
	
	
	
	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
