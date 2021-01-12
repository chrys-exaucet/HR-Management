package org.human.resources.domain.hr.location;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "region")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Region {

    @Id
    private String id;
    private String name;

}
