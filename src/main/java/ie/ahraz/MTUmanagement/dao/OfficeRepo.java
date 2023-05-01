package ie.ahraz.MTUmanagement.dao;

import ie.ahraz.MTUmanagement.entites.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface OfficeRepo extends JpaRepository<Office, Integer> {
    List<Office> findAllByDepartment_TitleName(String titleName);

    @Query("select c from Office c where c.department.titleName=?1")
    List<Office> findAllByDepartmentName(String titleName);

//    @Modifying
//    @Transactional
//    @Query(value = "update Office c set c.department.titleId= :newId where c.officeId= :officesId")
//    int moveDepartment(@Param("officesId") int officesId, @Param("newId") int newId);

    List<Office> findAllByDepartment_TitleId(int titleId);


}
