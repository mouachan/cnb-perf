package com.sample.cnb.runner;

import static org.junit.Assume.assumeNoException;

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.kie.api.KieServices;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.cnb.listener.CNBAgendaListener;
import com.sample.cnb.listener.CNBWMListener;
import com.sample.cnb.modele.ElementDate;

/**
 * This is a sample class to launch a rule.
 */
public class Runner {

	private static final String _15S_10S_10S_10S_10S_10S_10S = "%15s|%10s|%10s|%10s|%10s|%10s|%10s|";
	private static final String _15S_10D_10D_10D_10D_10D_10D = "%15s|%10d|%10d|%10d|%10d|%10d|%10d|";
	protected  CNBWMListener wmListener;
	protected  CNBAgendaListener agListener;
	private final  Logger logger = LoggerFactory.getLogger(Runner.class);
	private KieServices ks;
	private KieContainer kContainer; 
	private String inputData;



	public void init(String filename) {
		try {

			System.setProperty("drools.dateformat", "yyyy-MMM-dd");
			inputData = Files.readString(new File(filename).toPath());
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public void extracted(String kSessionName, int annee, int maxAnnee) {
		long t1 = System.currentTimeMillis();
		ks = KieServices.Factory.get();
		kContainer = ks.getKieClasspathContainer();
		logger.info("kSessionName "+kSessionName);
		KieSession kSession = kContainer.newKieSession(kSessionName);
		wmListener = new CNBWMListener();
		kSession.addEventListener(wmListener);
		agListener = new CNBAgendaListener();
		kSession.addEventListener(agListener);
		long t2 = System.currentTimeMillis();

		long t3 = System.currentTimeMillis();
		IntStream.range(annee, maxAnnee).forEach(o -> kSession.insert(o));
		for (String string : inputData.split("\\n")) 
			kSession.insert(new ElementDate(LocalDate.parse(string), null));
			
		
		long t4 = System.currentTimeMillis();

		long t5 = System.currentTimeMillis();

		int nb = kSession.fireAllRules();
		long t6 = System.currentTimeMillis();
	
		logger.trace("Rules Fired : "+agListener.getRulesFired());
		logger.info(String.format(_15S_10S_10S_10S_10S_10S_10S, "Ksession", "NB FR", "Session ms", "",
		"Injection ms", "", "Exec ms"));
		logger.info(String.format(_15S_10D_10D_10D_10D_10D_10D,
				kSessionName + "-" + annee + "-" + inputData.split("\\n").length, nb, (t2 - t1), (t3 - t2), (t4 - t3),
				(t5 - t4), (t6 - t5)));
		kSession.dispose();

	}

}
