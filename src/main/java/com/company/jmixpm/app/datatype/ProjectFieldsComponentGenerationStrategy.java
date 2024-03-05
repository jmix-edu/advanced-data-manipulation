package com.company.jmixpm.app.datatype;

import com.company.jmixpm.entity.Project;
import com.vaadin.flow.component.Component;
import io.jmix.core.JmixOrder;
import io.jmix.core.metamodel.datatype.Datatype;
import io.jmix.core.metamodel.model.MetaClass;
import io.jmix.core.metamodel.model.MetaProperty;
import io.jmix.core.metamodel.model.MetaPropertyPath;
import io.jmix.core.metamodel.model.Range;
import io.jmix.flowui.UiComponents;
import io.jmix.flowui.component.ComponentGenerationContext;
import io.jmix.flowui.component.ComponentGenerationStrategy;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.sys.ValuePathHelper;
import org.springframework.core.Ordered;
import org.springframework.lang.Nullable;

@org.springframework.stereotype.Component("pm_ProjectFieldsComponentGenerationStrategy")
public class ProjectFieldsComponentGenerationStrategy implements ComponentGenerationStrategy, Ordered {

    private UiComponents uiComponents;

    public ProjectFieldsComponentGenerationStrategy(UiComponents uiComponents) {
        this.uiComponents = uiComponents;
    }

    @Nullable
    @Override
    public Component createComponent(ComponentGenerationContext context) {
        String checkProperty = context.getProperty(); // 1
        String[] properties = ValuePathHelper.parse(checkProperty); // 2
        if (properties.length > 1) {
            checkProperty = properties[properties.length - 1]; // 3
        }
        if (!"projectLabels".equals(checkProperty)) {
            return null;
        }

        MetaClass metaClass = context.getMetaClass();
        MetaPropertyPath propertyPath = metaClass.getPropertyPath(context.getProperty()); // 4
        if (propertyPath != null) {
            metaClass = propertyPath.getMetaProperty().getDomain();  // 5
        }
        if (!metaClass.getJavaClass().equals(Project.class)) {
            return null;
        }
        MetaProperty property = metaClass.getProperty(checkProperty);
        Range range = property.getRange();

        if (range.isDatatype()) {
            Datatype projectLabelsDatatype = range.asDatatype();
            if (projectLabelsDatatype instanceof ProjectLabelsDatatype) {
                return create(context);
            }
        }

        return null;
    }

    @Override
    public int getOrder() {
        return JmixOrder.HIGHEST_PRECEDENCE;
    }

    private TypedTextField<ProjectLabels> create(ComponentGenerationContext context) {
        TypedTextField<ProjectLabels> component = uiComponents.create(TypedTextField.class);
        component.setValueSource(context.getValueSource());
        component.setReadOnly(true);
        return component;
    }
}
