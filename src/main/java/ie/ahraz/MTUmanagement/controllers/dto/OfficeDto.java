package ie.ahraz.MTUmanagement.controllers.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Relation(collectionRelation = "offices",itemRelation = "office")
public class OfficeDto  extends RepresentationModel<OfficeDto> {
    private String officeNumber;
    private int maxOccupancy;
    private int currentOccupancy;
}
