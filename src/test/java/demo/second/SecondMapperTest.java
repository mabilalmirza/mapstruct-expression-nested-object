package demo.second;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import demo.second.source.Companion;
import demo.second.source.Root;
import demo.second.source.RootChild;
import demo.second.source.RootDecendent;
import demo.second.target.OneUnit;
import demo.second.target.OtherUnit;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class SecondMapperTest {

    private final SecondMapper mapper = Mappers.getMapper(SecondMapper.class);

    @Test
    void testMapUnit() {

        Companion companion = new Companion();
        companion.setDescription("the companion");

        Root root = new Root();
        root.setName("I am Groot");

        root.setRootChild(new RootChild());
        root.getRootChild().setChildName("Mr. Child");

        root.getRootChild().setRootDecendent(new RootDecendent());
        root.getRootChild().getRootDecendent().setDecendentName("GrandChild");

        OneUnit oneUnit = new OneUnit();
        oneUnit.setRoot("I am Groot");
        oneUnit.setDescription("the companion");

        oneUnit.setOtherUnit(new OtherUnit());
        oneUnit.getOtherUnit().setDescription("the companion");
        oneUnit.getOtherUnit().setChild("Mr. Child");
        oneUnit.getOtherUnit().setDecendent("GrandChild");
        oneUnit.getOtherUnit().setAnother("GrandChild_Postfix");

        assertEquals(oneUnit, mapper.mapUnit(root, companion));
    }

    @Test
    void testMapUnit_RootNull() {
        assertNull(mapper.mapUnit(null, null));
    }

    @Test
    void testMapUnit_ChildNull() {

        Companion companion = new Companion();
        companion.setDescription("the companion");

        Root root = new Root();
        root.setName("I am Groot");

        OneUnit oneUnit = new OneUnit();
        oneUnit.setRoot("I am Groot");

        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> mapper.mapUnit(root, companion));
    }

    @Test
    void testMapUnit_DecendentNull() {

        Companion companion = new Companion();
        companion.setDescription("the companion");

        Root root = new Root();
        root.setName("I am Groot");

        root.setRootChild(new RootChild());
        root.getRootChild().setChildName("Mr. Child");

        OneUnit oneUnit = new OneUnit();
        oneUnit.setRoot("I am Groot");

        NullPointerException exception = assertThrows(NullPointerException.class,
                () -> mapper.mapUnit(root, companion));
    }
}
