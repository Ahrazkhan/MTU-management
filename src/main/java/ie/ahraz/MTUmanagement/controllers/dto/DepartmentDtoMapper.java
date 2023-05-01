package ie.ahraz.MTUmanagement.controllers.dto;

import ie.ahraz.MTUmanagement.controllers.WebService;
import ie.ahraz.MTUmanagement.entites.Department;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DepartmentDtoMapper extends RepresentationModelAssemblerSupport<Department,DepartmentDto> {
    public DepartmentDtoMapper() {
        super(WebService.class, DepartmentDto.class);
    }

    @Override
    public DepartmentDto toModel(Department entity) {
        DepartmentDto departmentDto = new DepartmentDto(entity.getTitleName(), entity.getEmailAddress());
        departmentDto.add(WebMvcLinkBuilder.linkTo(methodOn(WebService.class).getADepartmentById(entity.getTitleId())).withSelfRel());
        return departmentDto;
    }

    @Override
    public CollectionModel<DepartmentDto> toCollectionModel(Iterable<? extends Department> entites){
        return super.toCollectionModel(entites);
    }
}
