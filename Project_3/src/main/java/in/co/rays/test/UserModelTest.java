package in.co.rays.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.dto.UserDTO;
import in.co.rays.exception.ApplicationException;
import in.co.rays.exception.DuplicateRecordException;
import in.co.rays.exception.RecordNotFoundException;
import in.co.rays.model.UserModelHibImpl;
import in.co.rays.model.UserModelInt;
import in.co.rays.model.UserModelJDBCImpl;

/**
 * UserModel Test Class
 * 
 * @author PAWAN PATIDAR
 *
 */
public class UserModelTest {

	/**
	 * Model object to test
	 */

	public static UserModelInt model = new UserModelHibImpl();

	// public static UserModelInt model = new UserModelJDBCImpl();

	/**
	 * Main method to call test methods.
	 * 
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws Exception {
		// testAdd();
//         testDelete();
		// testUpdate();
		// testFindByPK();
		// testFindByLogin();
		// testSearch();
		// testList();
		// testGetRoles();
		testAuthenticate();
		// testchangePassword();
		// testRegisterUser();
		// testforgetPassword();
		// testresetPassword();
	}

	/**
	 * Tests add a User
	 * 
	 * @throws ParseException
	 * @throws java.text.ParseException
	 */
	public static void testAdd() throws ParseException {

		try {
			UserDTO dto = new UserDTO();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			// dto.setId(3L);
			dto.setFirstName("Rahul");
			dto.setLastName("Patidar");
			dto.setLoginId("rahul12@gmail.com");
			dto.setPassword("Pass1112");
			dto.setConfirmPassword("Pass1112");
			dto.setDob(sdf.parse("30-08-2002"));
			dto.setRoleId(2L);
			dto.setUnsuccessfullLogin(1);
			dto.setGender("Male");
			dto.setLastLogin((new Timestamp(new Date().getTime())));

			dto.setUserLock("Yes");
			dto.setMobileNo("9933122650");
			dto.setCreatedBy("pavanpatidar8080@gmail.com");
			dto.setModifiedBy("pavanpatidar8080@gmail.com");

			dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
			dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
			long pk = model.add(dto);
			System.out.println("Successfully add");
			System.out.println(dto.getDob());
			UserDTO addedDto = model.findByPK(pk);
			if (addedDto == null) {
				System.out.println("Test add fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests delete a User
	 *//*
		 * public static void testDelete() {
		 * 
		 * try { UserDTO dto = new UserDTO(); long pk = 1L; dto.setId(pk);
		 * model.delete(dto); UserDTO deletedDto = model.findByPK(pk); if (deletedDto !=
		 * null) { System.out.println("Test Delete fail"); } } catch
		 * (ApplicationException e) { e.printStackTrace(); } }
		 */

	/**
	 * Tests update a User
	 */

	public static void testUpdate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			UserDTO dto = new UserDTO();
			dto.setId(1L);
			dto.setFirstName("Pawan");
			dto.setLastName("Patidar");
			dto.setLoginId("pavan8080@gmail.com");
			dto.setPassword("Pass4444");
			dto.setDob(sdf.parse("31-12-1998"));
			dto.setRoleId(1L);
			dto.setUnsuccessfullLogin(2);
			dto.setGender("Male");
			dto.setLastLogin((new Timestamp(new Date().getTime())));
			dto.setUserLock("Yes");
			dto.setMobileNo("1234567890");
			dto.setCreatedBy("Admin");
			dto.setModifiedBy("Admin");
			dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
			dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

			model.update(dto);

			UserDTO updatedDTO = model.findByLogin("pavan8080@gmail.com    ");
			if (!"Pawan".equals(updatedDTO.getFirstName())) {
				System.out.println("Test Update fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests find a User by PK.
	 */

	public static void testFindByPK() {
		try {
			UserDTO dto = new UserDTO();
			long pk = 1L;
			dto = model.findByPK(pk);
			if (dto == null) {
				System.out.println("Test Find By PK fail");

			}
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());
			System.out.println(dto.getDob());
			System.out.println(dto.getRoleId());
			System.out.println(dto.getUnsuccessfullLogin());
			System.out.println(dto.getGender());
			System.out.println(dto.getLastLogin());
			System.out.println(dto.getUserLock());
			System.out.println(dto.getMobileNo());
			System.out.println(dto.getCreatedBy());
			System.out.println(dto.getModifiedBy());
			System.out.println(dto.getCreatedDatetime());
			System.out.println(dto.getModifiedDatetime());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests find a User by Login.
	 */

	public static void testFindByLogin() {
		UserDTO dto = new UserDTO();
		try {
			dto = model.findByLogin("pavan@gmail.com");
			if (dto == null) {
				System.out.println("Test Find By PK fail");
			}
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());
			System.out.println(dto.getDob());
			System.out.println(dto.getRoleId());
			System.out.println(dto.getUnsuccessfullLogin());
			System.out.println(dto.getGender());
			System.out.println(dto.getLastLogin());
			System.out.println(dto.getUserLock());
			System.out.println(dto.getMobileNo());
			System.out.println(dto.getCreatedBy());
			System.out.println(dto.getModifiedBy());
			System.out.println(dto.getCreatedDatetime());
			System.out.println(dto.getModifiedDatetime());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests get List.
	 */
	/*
	 * public static void testList() {
	 * 
	 * try { UserDTO dto = new UserDTO(); List list = new ArrayList(); list =
	 * model.list(); if (list.size() < 0) { System.out.println("Test list fail"); }
	 * Iterator it = list.iterator(); while (it.hasNext()) { dto = (UserDTO)
	 * it.next(); System.out.println(dto.getId());
	 * System.out.println(dto.getFirstName());
	 * System.out.println(dto.getLastName()); System.out.println(dto.getLogin());
	 * System.out.println(dto.getPassword()); System.out.println(dto.getDob());
	 * System.out.println(dto.getRoleId());
	 * System.out.println(dto.getUnSuccessfulLogin());
	 * System.out.println(dto.getGender()); System.out.println(dto.getLastLogin());
	 * System.out.println(dto.getLock()); System.out.println(dto.getMobileNo());
	 * System.out.println(dto.getCreatedBy());
	 * System.out.println(dto.getModifiedBy());
	 * System.out.println(dto.getCreatedDatetime());
	 * System.out.println(dto.getModifiedDatetime()); }
	 * 
	 * } catch (ApplicationException e) { e.printStackTrace(); } }
	 * 
	 *//**
		 * Tests get Roles.
		 */

	/*
	 * public static void testGetRoles() {
	 * 
	 * try { UserDTO dto = new UserDTO(); List list = new ArrayList();
	 * dto.setRoleId(3L); list = model.getRoles(dto); if (list.size() < 0) {
	 * System.out.println("Test Get Roles fail"); } Iterator it = list.iterator();
	 * while (it.hasNext()) { dto = (UserDTO) it.next();
	 * System.out.println(dto.getId()); System.out.println(dto.getFirstName());
	 * System.out.println(dto.getLastName()); System.out.println(dto.getLogin());
	 * System.out.println(dto.getPassword()); System.out.println(dto.getDob());
	 * System.out.println(dto.getRoleId());
	 * System.out.println(dto.getUnSuccessfulLogin());
	 * System.out.println(dto.getGender()); System.out.println(dto.getLastLogin());
	 * System.out.println(dto.getLock()); System.out.println(dto.getMobileNo());
	 * System.out.println(dto.getCreatedBy());
	 * System.out.println(dto.getModifiedBy());
	 * System.out.println(dto.getCreatedDatetime());
	 * System.out.println(dto.getModifiedDatetime()); } } catch
	 * (ApplicationException e) { e.printStackTrace(); } }
	 * 
	 *//**
		 * UserDTO dto = new UserDTO(); Tests get Search
		 */

	public static void testSearch() {

		try {
			UserDTO dto = new UserDTO();
			List list = new ArrayList(); //
			dto.setFirstName("ranjit"); // dto.setLastName("ch");
			dto.setLoginId("ranjitchoudha12ry20@gmail.com");

			list = model.search(dto, 0, 0);
			if (list.size() < 0) {
				System.out.println("Test Serach fail");
			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				dto = (UserDTO) it.next();
				System.out.println(dto.getId());
				System.out.println(dto.getFirstName());
				System.out.println(dto.getLastName());
				System.out.println(dto.getLoginId());
				System.out.println(dto.getPassword());
				System.out.println(dto.getDob());
				System.out.println(dto.getRoleId());
				System.out.println(dto.getUnsuccessfullLogin());
				System.out.println(dto.getGender());
				System.out.println(dto.getLastLogin());
				System.out.println(dto.getUserLock());
				System.out.println(dto.getMobileNo());
				System.out.println(dto.getCreatedBy());
				System.out.println(dto.getModifiedBy());
				System.out.println(dto.getCreatedDatetime());
				System.out.println(dto.getModifiedDatetime());
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests authenticate User.
	 */

	public static void testAuthenticate() {

		try {
			UserDTO dto = new UserDTO(); //
			dto.setLoginId("pavan8080@gmail.com"); 
			dto.setPassword("Pass4444"); dto =
			model.authenticate(dto.getLoginId(), dto.getPassword());
			if (dto != null) {
				System.out.println("Successfully login");

			} else {
				System.out.println("Invalied login Id & password");
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests add a User UserDTO dto = new UserDTO();
	 * 
	 * @throws ParseException
	 */

	public static void testchangePassword() {

		try {
			UserDTO dto = model.findByLogin("ranjitchoudhary20@gmail.com");
			String oldPassword = dto.getPassword();
			dto.setId(15l);
			dto.setPassword("rr");
			String newPassword = dto.getPassword();
			try {
				model.changePassword(15L, oldPassword, newPassword);
			} catch (RecordNotFoundException e) {
				e.printStackTrace();
			}

		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Tests add a User register
	 * 
	 * @throws ParseException
	 */

	public static void testRegisterUser() throws ParseException {
		try {
			UserDTO dto = new UserDTO();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

			// dto.setId(8L); 
			dto.setFirstName("Abhishek");
			dto.setLastName("Patidar");
			dto.setLoginId("Abhishek11@gmail.com");
			dto.setPassword("pass4444");
			dto.setConfirmPassword("pass4444");
			dto.setDob(sdf.parse("11/02/2001"));
			dto.setGender("Male");
			dto.setRoleId(2);
			long pk = model.registerUser(dto);
			System.out.println("Successfully register");
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getLastName());
			System.out.println(dto.getDob());
			UserDTO registerDto = model.findByPK(pk);
			if (registerDto == null) {
				System.out.println("Test add fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests fogetPassword
	 * 
	 * @throws ParseException
	 */

	public static void testforgetPassword() {
		try {
			boolean b = model.forgetPassword("ranjitchoudhary20@gmail.com");

			System.out.println("Suucess : Test Forget Password Success");

		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tests resetPassword
	 * 
	 * @throws ParseException
	 */

	public static void testresetPassword() {
		UserDTO dto = new UserDTO();
		try {
			dto = model.findByLogin("ranjitchoudhary20@gmail.com");
			if (dto != null) {
				boolean pass = model.resetPassword(dto);
				if (pass = false) {
					System.out.println("Test Update fail");
				}
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

	}

}
