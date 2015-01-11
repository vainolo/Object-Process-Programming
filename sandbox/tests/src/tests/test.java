package tests;

import java.util.Collection;

import com.google.common.base.Joiner;

class Challenge {

  private static final Logger log = LoggerFactory.getLogger(Challenge.class);

  private void logIfRequired(String prefix, String separator, Collection<String> words) {
    if(log.isDebugEnabled()) {
      log.debug(prefix + Joiner.on(separator).join(words));
    }
  }

  public void wrongLogIfRequired(String text) {
    if(log.isDebugEnabled()) {
      log.debug(text);
    }
  }

  public void doSomething(Collection<String> words) {
    log.debug("doing work on " + Joiner.on(";").join(words));
    doWork(words);
  }

  public void doSomething_naiveSolution(Collection<String> words) {
    if(log.isDebugEnabled()) {
      log.debug("doing work on " + Joiner.on(";").join(words));
    }
    doWork(words);
  }

  public void doSomething_betterSolution(Collection<String> words) {
    logIfRequired("doing work on ", ";", words);
    doWork(words);
  }

  public void doSomething_otherSolution(Collection<String> words) {
    log.debug(log.isDebugEnabled() ? "Doing work on " + Joiner.on(";").join(words) : "Doing work");
    doWork(words);
  }

  private void doWork(Collection<String> words) {
    // ...
  }
}