package com.company.jmixpm.app.datatype;

import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ProjectLabels implements Serializable {

    private final List<String> labels;

    public ProjectLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<String> getLabels() {
        return Collections.unmodifiableList(labels);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return CollectionUtils.isEqualCollection(((ProjectLabels) obj).labels, labels);
    }

    @Override
    public int hashCode() {
        return Objects.hash((labels.toArray()));
    }
}
