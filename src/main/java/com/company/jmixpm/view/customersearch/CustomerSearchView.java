package com.company.jmixpm.view.customersearch;


import com.company.jmixpm.entity.Customer;
import com.company.jmixpm.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.model.CollectionContainer;
import io.jmix.flowui.view.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Route(value = "customer-search-view", layout = MainView.class)
@ViewController("CustomerSearchView")
@ViewDescriptor("customer-search-view.xml")
public class CustomerSearchView extends StandardView {

    private static final Logger log = LoggerFactory.getLogger(CustomerSearchView.class);

    @ViewComponent
    private CollectionContainer<Customer> customersDc;

    @Subscribe
    public void onInit(InitEvent event) {
        log.info("InitEvent - customers size: " + customersDc.getItems().size());
    }

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        log.info("BeforeShowEvent - customers size: " + customersDc.getItems().size());
    }
}