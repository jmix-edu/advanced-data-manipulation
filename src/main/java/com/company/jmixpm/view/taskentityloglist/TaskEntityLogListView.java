package com.company.jmixpm.view.taskentityloglist;


import com.company.jmixpm.entity.Task;
import com.company.jmixpm.view.main.MainView;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.router.Route;
import io.jmix.audit.entity.EntityLogItem;
import io.jmix.flowui.component.combobox.EntityComboBox;
import io.jmix.flowui.component.combobox.JmixComboBox;
import io.jmix.flowui.model.CollectionContainer;
import io.jmix.flowui.model.CollectionLoader;
import io.jmix.flowui.view.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Route(value = "task-entity-log-list-view", layout = MainView.class)
@ViewController("TaskEntityLogListView")
@ViewDescriptor("task-entity-log-list-view.xml")
public class TaskEntityLogListView extends StandardView {
    @ViewComponent
    private CollectionLoader<EntityLogItem> entityLogItemsDl;

    @Subscribe("tasksField")
    public void onTasksFieldComponentValueChange(final AbstractField.ComponentValueChangeEvent<EntityComboBox<Task>, Task> event) {
        if (event.getValue() == null) {
            entityLogItemsDl.removeParameter("id");
        } else {
            entityLogItemsDl.setParameter("id", event.getValue().getId());
        }
        entityLogItemsDl.load();
    }
}