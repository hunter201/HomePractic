import java.io.Serial;
import java.io.Serializable;

public class Actor implements Serializable, Cloneable {

    @Serial
    private static final long serialVersionUID = 100L;

    private final String name;

    private final String surname;

    public Actor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    @Override
    public Actor clone() {
        try {
            Actor clone = (Actor) super.clone();
          
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
