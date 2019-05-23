package demo.second.target;

import java.util.Objects;

public class OtherUnit {

    private String description;
    private String child;
    private String decendent;
    private String another;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getDecendent() {
        return decendent;
    }

    public void setDecendent(String decendent) {
        this.decendent = decendent;
    }

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OtherUnit otherUnit = (OtherUnit) o;
        return Objects.equals(description, otherUnit.description) &&
                Objects.equals(child, otherUnit.child) &&
                Objects.equals(decendent, otherUnit.decendent) &&
                Objects.equals(another, otherUnit.another);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, child, decendent, another);
    }

    @Override
    public String toString() {
        return "OtherUnit{" +
                "description='" + description + '\'' +
                ", child='" + child + '\'' +
                ", decendent='" + decendent + '\'' +
                ", another='" + another + '\'' +
                '}';
    }
}
