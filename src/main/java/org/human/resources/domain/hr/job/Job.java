package org.human.resources.model.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Job {

    private ObjectId id;
    private String title;
    private long minSalary;
    private long maxSalary;
    private Set<ObjectId> employeeId;
    private Set<Task> tasks;
}
