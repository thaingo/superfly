package com.payneteasy.superfly.web.wicket.component.field;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.ResourceModel;

public class LabelValueRow<T> extends Panel{
	public LabelValueRow(String id, final IModel<T> model, String labelResourceKey) {
        super(id, model);

        // label
        add(new Label("label-id", new ResourceModel(labelResourceKey)));

        // value
        IModel<String> valueModel = new AbstractReadOnlyModel<String>() {
            @Override
            public String getObject() {
                String value = String.valueOf(model.getObject());
                return value;
            }
        };
        
        add(new Label("field-id", valueModel));
    }
    
    public LabelValueRow(String id, Object object, String labelResourceKey) {
        this(id, new PropertyModel<T>(object, id), labelResourceKey);
    }
}
