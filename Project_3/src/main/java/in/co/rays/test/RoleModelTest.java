package in.co.rays.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.dto.RoleDTO;
import in.co.rays.exception.ApplicationException;
import in.co.rays.exception.DuplicateRecordException;
import in.co.rays.model.RoleModelHibImpl;
import in.co.rays.model.RoleModelInt;

public class RoleModelTest {
	 /**
     * Model object to test
     */
 
     public static RoleModelInt model = new RoleModelHibImpl();
 
   // public static RoleModelInt model = new RoleModelJDBCImpl();
 
	
	 /**
     * Main method to call test methods.
     *  
     */
    public static void main(String[] args){
      testAdd();
        // testDelete();
        // testUpdate();
//         testFindByPK();
       //  testFindByLogin();
        // testSearch();
        // testList();
 
    }
 
    /**
     * Tests add a User
     */
    public static void testAdd() {
 
        try {
            RoleDTO dto = new RoleDTO();
            // SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
 
            // dto.setId(1L);
            dto.setName("Student");
            dto.setDescription("Student");
            dto.setCreatedBy("pavanpatidar8080@gmail.com");
			dto.setModifiedBy("pavanpatidar8080@gmail.com");

			dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
			dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

            long pk = model.add(dto);
            System.out.println("Test add succ");
            RoleDTO addedDto = model.findByPK(pk);
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
     */
    public static void testDelete() {
 
        try {
            RoleDTO dto = new RoleDTO();
            long pk = 2L;
            dto.setId(pk);
            model.delete(dto);
            System.out.println("Test Delete succ");
            RoleDTO deletedDto = model.findByPK(pk);
            if (deletedDto != null) {
                System.out.println("Test Delete fail");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * Tests update a User
     */
    public static void testUpdate() {
 
        try {
            RoleDTO dto = model.findByPK(1L);
            dto.setName("HRgg");
            dto.setDescription("This is the HR Dep");
            model.update(dto);
 
        /*    RoleDTO updatedDTO = model.findByPK(6L);
            System.out.println("Test Update ");
            if (!"cmc limited".equals(updatedDTO.getName())) {
                System.out.println("Test Update fail");
            }*/
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
            RoleDTO dto = new RoleDTO();
            long pk = 2L;
            dto = model.findByPK(pk);
            if (dto == null) {
                System.out.println("Test Find By PK fail");
            }
            System.out.println();
            System.out.println(dto.getName());
            System.out.println(dto.getDescription());
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
 
    }
 
    /**
     * Tests find a User by Login.
     */
    public static void testFindByLogin() {
        try {
            RoleDTO dto = new RoleDTO();
            dto = model.findByName("hr");
            if (dto == null) {
                System.out.println("Test Find By PK fail");
            }
            System.out.println(dto.getId());
            System.out.println(dto.getName());
            System.out.println(dto.getDescription());
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * Tests get Search
     */
    public static void testSearch() {
 
        try {
            RoleDTO dto = new RoleDTO();
            List list = new ArrayList();
            dto.setName("admin");
            list = model.search(dto, 0, 0);
            if (list.size() < 0) {
                System.out.println("Test Serach fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                dto = (RoleDTO) it.next();
                System.out.println(dto.getId());
                System.out.println(dto.getName());
                System.out.println(dto.getDescription());
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
            RoleDTO dto = new RoleDTO();
            List list = new ArrayList();
            list = model.list(1, 10);
            if (list.size() < 0) {
                System.out.println("Test list fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                dto = (RoleDTO) it.next();
                System.out.println(dto.getId());
                System.out.println(dto.getName());
                System.out.println(dto.getDescription());
            }
 
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }
	
}
