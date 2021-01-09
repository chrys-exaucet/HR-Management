package org.human.resources.model.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "country")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country {
    private ObjectId id;
    private String name;
    private Region region;
}
