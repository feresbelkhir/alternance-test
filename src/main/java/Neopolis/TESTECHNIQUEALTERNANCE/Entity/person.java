package Neopolis.TESTECHNIQUEALTERNANCE.Entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "person", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"email"})})
public class person implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String Civilite;

    private String Nom;

    private String prenom;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datenaiss;

    private String Situation_Familial;

    private int Nombre_enfont;

    @NotBlank
    @Email
    private String email;

    private String numero_tel1;

    private String numero_tel2;

    private String mobile;

    private String address;

    private String pays;

    private String ville;

    private String Rue;

    private String Numero_Rue;

    private String code_postal;

    private String complement_address;

    private String mot_cle;

    private String commentaire;

    private String relation;

}
