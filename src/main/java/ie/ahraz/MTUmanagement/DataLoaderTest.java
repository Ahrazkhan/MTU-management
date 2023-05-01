package ie.ahraz.MTUmanagement;

import ie.ahraz.MTUmanagement.dao.DepartmentRepo;
import ie.ahraz.MTUmanagement.dao.OfficeRepo;
import ie.ahraz.MTUmanagement.entites.Department;
import ie.ahraz.MTUmanagement.entites.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class DataLoaderTest implements CommandLineRunner {
    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    OfficeRepo officeRepo;

    @Override
    public void run(String... args) throws Exception {
        Department depOne = departmentRepo.save(new Department("Civil Department", "civil@mtu.ie"));
        Department depTwo = departmentRepo.save(new Department("Computer Department", "computer@mtu.ie"));
        Department depthree = departmentRepo.save(new Department("Agriculture Department", "agriculture@mtu.ie"));
        Department depfour = departmentRepo.save(new Department("Medical Department", "medical@mtu.ie"));

        officeRepo.save(new Office("A21", 10, 7, depOne));
        officeRepo.save(new Office("B22", 10, 8, depTwo));
        officeRepo.save(new Office("C23", 10, 9, depthree));
        officeRepo.save(new Office("D24", 10, 8, depfour));
    }


}
