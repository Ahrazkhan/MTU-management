package ie.ahraz.MTUmanagement.service;

import ie.ahraz.MTUmanagement.dao.DepartmentRepo;
import ie.ahraz.MTUmanagement.entites.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public Department saveDepartment(String titleName, String emailAddress ){
        if (! departmentRepo.existsByTitleName(titleName))
            return departmentRepo.save(new Department(titleName,emailAddress));
        return null;
    }
}
