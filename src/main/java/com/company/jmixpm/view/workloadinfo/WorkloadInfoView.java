package com.company.jmixpm.view.workloadinfo;


import com.company.jmixpm.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.core.entity.KeyValueEntity;
import io.jmix.flowui.Notifications;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.model.KeyValueContainer;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "workload-info-view", layout = MainView.class)
@ViewController("WorkloadInfoView")
@ViewDescriptor("workload-info-view.xml")
public class WorkloadInfoView extends StandardView {

    @ViewComponent
    private KeyValueContainer workloadDc;

    @Autowired
    private Notifications notifications;

    public WorkloadInfoView withItem(KeyValueEntity item) {
        workloadDc.setItem(item);
        return this;
    }

    @Subscribe(id = "workloadDc", target = Target.DATA_CONTAINER)
    public void onWorkloadDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<KeyValueEntity> event) {
        notifications.show("Property changed: " + event.getProperty());
    }
}