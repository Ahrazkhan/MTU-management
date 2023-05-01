package ie.ahraz.MTUmanagement.dao;

import ie.ahraz.MTUmanagement.entites.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserDao extends JpaRepository<MyUser,String> {
}
