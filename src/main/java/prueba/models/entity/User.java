package prueba.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user_db")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String passw;

    private String name_one;

    private String name_others;

    private String last_name_one;

    private String last_name_two;

    private String country;

    private String identification;

    @Column(name = "id_num")
    private String numId;

    private String email;

    private Boolean status;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date create_at;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL )
    private List<Round> rounds;

    public User(  String passw, String name_one, String name_others, String last_name_one, String last_name_two, String country, String identification, String numId,String email) {
        //this.user_id = user_id;
        this.passw = passw;
        this.name_one = name_one;
        this.name_others = name_others;
        this.last_name_one = last_name_one;
        this.last_name_two = last_name_two;
        this.country = country;
        this.identification = identification;
        this.numId = numId;
        this.email = email;
        this.status = true;
        this.create_at = new Date();
    }

    public User() {

    }


}
