package com.company.jmixpm.app.valiation;

import com.company.jmixpm.entity.Project;
import io.jmix.core.DataManager;
import io.jmix.core.validation.group.UiComponentChecks;
import io.jmix.flowui.component.validation.group.UiCrossFieldChecks;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated(value = {Default.class, UiComponentChecks.class, UiCrossFieldChecks.class})
@Service
public class ProjectsService {

    @Autowired
    private DataManager dataManager;

    public void saveProject(@NotNull @Valid Project project) {
        dataManager.save(project);
    }
}
