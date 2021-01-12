package org.human.resources.domain.hr.location;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "location")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {

    @Id
    private String id;
    private String streetAddress;
    private String postalCode;

    @Indexed
    private String city;
    private String stateAddress;


    @Indexed
    private Country country;

}
