package com.cos.googleapp.config;

import org.springframework.context.annotation.Configuration;

import io.sentry.Sentry;
import io.sentry.event.Event;
import io.sentry.event.EventBuilder;

@Configuration
public class SentrySupport {

	// IOC 할때 자동으로 실행됨
	public SentrySupport() {
		System.out.println("=========================================SentrySupport init()");
		Sentry.init("https://6a0a410bf7364e0fadb7e1e1aeb4187c@o434900.ingest.sentry.io/5392549");
	}
	
    public void logSimpleMessage(String msg) {
        // This sends an event to Sentry.
    	System.out.println("여기왔음?");
        EventBuilder eventBuilder = new EventBuilder()
                        .withMessage(msg)
                        .withLevel(Event.Level.ERROR)
                        .withLogger(SentrySupport.class.getName());

        // Note that the *unbuilt* EventBuilder instance is passed in so that
        // EventBuilderHelpers are run to add extra information to your event.
        
        Sentry.capture(eventBuilder); // capture = send 한다는 것
    }

}
