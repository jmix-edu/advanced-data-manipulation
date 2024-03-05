package com.company.jmixpm.view.timeentry;

import com.company.jmixpm.entity.TimeEntry;

import com.company.jmixpm.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.core.LoadContext;
import io.jmix.core.UnconstrainedDataManager;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "timeEntries", layout = MainView.class)
@ViewController("TimeEntry.list")
@ViewDescriptor("time-entry-list-view.xml")
@LookupComponent("timeEntriesDataGrid")
@DialogMode(width = "64em")
public class TimeEntryListView extends StandardListView<TimeEntry> {

    @Autowired
    private UnconstrainedDataManager dataManager;

    @Install(to = "timeEntriesDl", target = Target.DATA_LOADER)
    private List<TimeEntry> timeEntriesDlLoadDelegate(LoadContext<TimeEntry> loadContext) {
        return dataManager.loadList(loadContext);
    }
}