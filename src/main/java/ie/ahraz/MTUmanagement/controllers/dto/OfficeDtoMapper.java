package ie.ahraz.MTUmanagement.controllers.dto;

import ie.ahraz.MTUmanagement.controllers.WebService;
import ie.ahraz.MTUmanagement.entites.Department;
import ie.ahraz.MTUmanagement.entites.Office;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OfficeDtoMapper extends RepresentationModelAssemblerSupport<Office,OfficeDto> {

    public OfficeDtoMapper() {
        super(WebService.class, OfficeDto.class);
    }

    @Override
    public OfficeDto toModel(Office entity) {
        OfficeDto officeDto = new OfficeDto(entity.getOfficeNumber(), entity.getMaxOccupancy(), entity.getCurrentOccupancy());
        officeDto.add(WebMvcLinkBuilder.linkTo(methodOn(WebService.class).getAOfficeById(entity.getOfficeID())).withSelfRel());
//        officeDto.add(WebMvcLinkBuilder.linkTo(methodOn(WebService.class).moveDepartment(entity.getOfficeID(), null,null)).withRel("move"));#
        officeDto.add(WebMvcLinkBuilder.linkTo(methodOn(WebService.class).getADepartmentById(entity.getDepartment().getTitleId())).withRel("department"));
        return officeDto;
    }

    @Override
    public CollectionModel<OfficeDto> toCollectionModel(Iterable<? extends Office> entites){
        return  super.toCollectionModel(entites);
    }
}
