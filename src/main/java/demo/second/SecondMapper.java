package demo.second;

import demo.second.source.Companion;
import demo.second.source.Root;
import demo.second.target.OneUnit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SecondMapper {


    @Mapping(target = "root", source = "root.name")
    @Mapping(target = "description", source = "companion.description")
    @Mapping(target = "otherUnit.description", source = "companion.description")
    @Mapping(target = "otherUnit.child", source = "root.rootChild.childName")
    @Mapping(target = "otherUnit.decendent", source = "root.rootChild.rootDecendent.decendentName")
    @Mapping(target = "otherUnit.another",
            expression = "java(root.getRootChild().getRootDecendent().getDecendentName() + \"_Postfix\")")
    public OneUnit mapUnit(Root root, Companion companion);

}
