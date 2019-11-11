package com.sample.cnb.listener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;

public class CNBWMListener implements RuleRuntimeEventListener {

    private Logger logger = LoggerFactory.getLogger(CNBWMListener.class);

    public void objectDeleted(ObjectDeletedEvent arg0) {
        logger.trace("object deleted " + arg0.toString());
    }

    public void objectInserted(ObjectInsertedEvent arg0) {
        logger.trace("Inserting into WM: " + arg0.getObject());
    }

    public void objectUpdated(ObjectUpdatedEvent arg0) {
        logger.trace("Updating: " + arg0.getObject());
    }
}
