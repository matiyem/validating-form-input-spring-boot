package validating.input;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * created by Atiye Mousavi
 * Date: 8/27/2021
 * Time: 3:22 PM
 */
@Data
public class PersonForm {
    @NotNull(message = "5000")
    @Size(min=2, max=30,message = "70001")
    private String name;

    @NotNull(message = "این ستون نمیتواند خالی باشد")
    @Min(value = 18 ,message = "عدد باید از 18 بزرگتر باشد")
    private Integer age;


    public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + ")";
    }

}
