package Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Donor {
    private String name;
    private int age;
    private String gender;
    private String address;
    private String phone;
    private String email;
}
