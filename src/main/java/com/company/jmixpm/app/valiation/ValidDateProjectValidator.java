package com.company.jmixpm.app.valiation;

import com.company.jmixpm.entity.Project;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;

public class ValidDateProjectValidator implements ConstraintValidator<ValidDateProject, Project> {

    @Override
    public boolean isValid(Project project, ConstraintValidatorContext context) {
        if (project == null) {
            return false;
        }

        LocalDateTime startDate = project.getStartDate();
        LocalDateTime endDate = project.getEndDate();

        if (startDate == null || endDate == null) {
            return true;
        }
        return endDate.compareTo(startDate) > 0;
    }
}
