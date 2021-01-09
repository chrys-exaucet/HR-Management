package org.human.resources.model.location;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "region")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Region {

    @Id
    private ObjectId id;
    private String name;

}
