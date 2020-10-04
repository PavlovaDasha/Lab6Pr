/**
 * Interface for working with commands which have an argument
 *
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import java.io.IOException;
import java.io.Serializable;

public interface Commandable extends Serializable {
    String execute(Object o) throws IOException;
    String getName();
}
