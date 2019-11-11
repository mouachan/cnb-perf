package com.sample.cnb.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.kie.api.event.rule.AgendaEventListener;
import org.drools.core.event.AgendaGroupPoppedEvent;
import org.drools.core.event.AgendaGroupPushedEvent;
import org.drools.core.event.RuleFlowGroupActivatedEvent;
import org.drools.core.event.RuleFlowGroupDeactivatedEvent;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;



public class CNBAgendaListener implements AgendaEventListener {

    private Logger logger = LoggerFactory.getLogger(CNBAgendaListener.class);
    private List<String> rulesFired = new ArrayList<String>();

    public List<String> getRulesFired() {
        return this.rulesFired;
    }
    /**
     * Méthode vidant la liste des noms de règles exécutées
     */
    public void clearRulesFiredList() {
        this.rulesFired.clear();
    }

    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {
        String ruleName = event.getMatch().getRule().getName();
        rulesFired.add(ruleName);
        logger.trace("***** Rule fired: '" + ruleName + "'");

        Iterator<? extends Object> iter = event.getMatch().getObjects().iterator();
        while (iter.hasNext()){
            logger.trace("  -> rule " + ruleName + " fired with following data: " + iter.next().toString());
        }

    }

    @Override
    public void beforeMatchFired(BeforeMatchFiredEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterRuleFlowGroupActivated(org.kie.api.event.rule.RuleFlowGroupActivatedEvent event) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void afterRuleFlowGroupDeactivated(org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent event) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void beforeRuleFlowGroupActivated(org.kie.api.event.rule.RuleFlowGroupActivatedEvent event) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void beforeRuleFlowGroupDeactivated(org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent event) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void matchCancelled(MatchCancelledEvent event) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void matchCreated(MatchCreatedEvent event) {
        // TODO Auto-generated method stub
        
    }


   @Override
   public void agendaGroupPopped(org.kie.api.event.rule.AgendaGroupPoppedEvent event) {
       // TODO Auto-generated method stub
       
   }
   @Override
   public void agendaGroupPushed(org.kie.api.event.rule.AgendaGroupPushedEvent event) {
       // TODO Auto-generated method stub
       
   }



}
