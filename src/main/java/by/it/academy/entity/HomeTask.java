package by.it.academy.entity;


import by.it.academy.embed.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@DiscriminatorValue("H")
public class HomeTask extends Task {


    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "LOKKING_NAME")),
            @AttributeOverride(name = "surname", column = @Column(name = "LOKKING_SURNAME"))
    })
    @Embedded
    private Person looking;
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "EXECUTOR_NAME")),
            @AttributeOverride(name = "surname", column = @Column(name = "EXECUTOR_SURNAME"))
    })
    @Embedded
    private Person executor;

    @Column(name = "startDate")
    private LocalDate startDate;
    @Column(name = "endDate")
    private LocalDate endDate;
}