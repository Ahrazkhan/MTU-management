package ie.ahraz.MTUmanagement;

import ie.ahraz.MTUmanagement.dao.DepartmentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@ActiveProfiles("test")
class MtuManagementApplicationTests {
	@Autowired
	private DepartmentRepo departmentRepo;

	@Test
	void contextLoads() {
		Assertions.assertEquals(4,departmentRepo.count());

	}

	@Test
	void deleteDepartmentExistingId() {
		int testId = 4;
		Assertions.assertTrue(departmentRepo.findById(testId).isPresent());
		departmentRepo.deleteById(testId);
		Assertions.assertTrue(departmentRepo.findById(testId).isEmpty());
	}
	@Test
	void deleteDepartmentNoId() {
		int testId=50;
		Assertions.assertThrows(EmptyResultDataAccessException.class, ()->departmentRepo.deleteById(testId));
	}

}
