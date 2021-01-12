package org.human.resources.domain.hr.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.ZonedDateTime;


@Document(collection = "job_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobHistory {

    @Id
    private String id;

    @Indexed
    private String employeeId;

    private ZonedDateTime startDate;

    private ZonedDateTime endDate;

    @DBRef(db = "department")
    private String departmentId;

    private String jobId;


}
