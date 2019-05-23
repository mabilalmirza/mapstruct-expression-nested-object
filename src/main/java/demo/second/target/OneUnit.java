package demo.second.target;

import java.util.Objects;

public class OneUnit {

    private String description;
    private String root;
    private OtherUnit otherUnit;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public OtherUnit getOtherUnit() {
        return otherUnit;
    }

    public void setOtherUnit(OtherUnit otherUnit) {
        this.otherUnit = otherUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OneUnit oneUnit = (OneUnit) o;
        return Objects.equals(description, oneUnit.description) &&
                Objects.equals(root, oneUnit.root) &&
                Objects.equals(otherUnit, oneUnit.otherUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, root, otherUnit);
    }

    @Override
    public String toString() {
        return "OneUnit{" +
                "description='" + description + '\'' +
                ", root='" + root + '\'' +
                ", otherUnit=" + otherUnit +
                '}';
    }
}
