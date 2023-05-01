package ie.ahraz.MTUmanagement.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ie.ahraz.MTUmanagement.entites.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ie.ahraz.MTUmanagement.entites.Department;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int officeID;

    private String officeNumber;
    private int maxOccupancy;
    private int currentOccupancy;

    @ManyToOne
    @JsonIgnore
    //I was having trouble deleting the department by id, so I used this
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;

    public Office(String officeNumber, int maxOccupancy, int currentOccupancy, Department department) {
        this.officeNumber = officeNumber;
        this.maxOccupancy = maxOccupancy;
        this.currentOccupancy = currentOccupancy;
        this.department = department;
    }
}
