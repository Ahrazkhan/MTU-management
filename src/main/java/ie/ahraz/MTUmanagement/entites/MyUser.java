package ie.ahraz.MTUmanagement.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyUser {
    @Id
    private String userEmail;

    @Column
    private String userPassword;

    private String userRole;

    private boolean disabled,locked;

}
