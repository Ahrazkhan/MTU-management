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
@Profile("dev")
public class DataLoader implements CommandLineRunner {
    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    OfficeRepo officeRepo;

    @Override
    public void run(String... args) throws Exception {
        Department depOne =departmentRepo.save(new Department("Civil Department","civil@mtu.ie"));
        Department depTwo =departmentRepo.save(new Department("Computer Department","computer@mtu.ie"));
        Department depthree =departmentRepo.save(new Department("Agriculture Department","agriculture@mtu.ie"));
        Department depfour =departmentRepo.save(new Department("Medical Department","medical@mtu.ie"));
        departmentRepo.findAll().forEach(System.out::println);

        System.out.println(departmentRepo.findByTitleName("Civil Department"));

        officeRepo.save(new Office("A210",10,7,depOne));
        officeRepo.save(new Office("B220",10,8,depTwo));
        officeRepo.save(new Office("C230",10,9,depthree));
        officeRepo.save(new Office("D240",10,8,depfour));
        officeRepo.save(new Office("A320",12,4,depOne));
        officeRepo.save(new Office("B350",12,11,depTwo));
        officeRepo.save(new Office("C370",12,6,depthree));



        officeRepo.findAll().forEach(System.out::println);

        officeRepo.findAllByDepartmentName("Computer Department").forEach(System.out::println);
        //
//        officeRepo.findAllByDepartment_TitleName("Computer Department").forEach(System.out::println);





    }
}
