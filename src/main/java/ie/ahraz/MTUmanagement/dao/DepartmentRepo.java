package ie.ahraz.MTUmanagement.dao;

import ie.ahraz.MTUmanagement.entites.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

    Department findByTitleName(String titleName);

    boolean existsByTitleName(String titleName);

    }
