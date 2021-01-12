package org.human.resources.domain.hr.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Job {

    private String id;
    private String title;
    private long minSalary;
    private long maxSalary;
    private Set<String> employeeId;
    private Set<Task> tasks;

}
