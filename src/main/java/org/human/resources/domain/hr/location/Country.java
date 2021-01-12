package org.human.resources.domain.hr.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "country")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country {

    private String id;
    private String name;
    private Region region;

}
