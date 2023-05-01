package ie.ahraz.MTUmanagement.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int titleId;
    @Column(nullable = false,unique = true)
    private String titleName;


    @Column(nullable = false,unique = true)
    private String emailAddress;

    @OneToMany(orphanRemoval = true, mappedBy = "department")
    @ToString.Exclude
    @JsonIgnore
    private List<Office> officeList;

    public Department(String titleName, String emailAddress) {
        this.titleName = titleName;
        this.emailAddress = emailAddress;
    }


}
