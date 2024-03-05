package com.company.jmixpm.view.roadmap;

import com.company.jmixpm.entity.Roadmap;

import com.company.jmixpm.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "roadmaps/:id", layout = MainView.class)
@ViewController("Roadmap.detail")
@ViewDescriptor("roadmap-detail-view.xml")
@EditedEntityContainer("roadmapDc")
public class RoadmapDetailView extends StandardDetailView<Roadmap> {
}