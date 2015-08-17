package com.vainolo.phd.opp.interpreter.server;

import java.util.function.Consumer;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.ext.web.Router;

/*
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class Server extends AbstractVerticle {

  // Convenience method so you can run it in your IDE
  public static void main(String[] args) {
    System.setProperty("vertx.cwd", "hello");
    Consumer<Vertx> runner = vertx -> {
      try {
        vertx.deployVerticle(Server.class.getName());
      } catch(Throwable t) {
        t.printStackTrace();
      }
    };
    Vertx vertx = Vertx.vertx(new VertxOptions());
    runner.accept(vertx);
  }

  @Override
  public void start() throws Exception {

    Router router = Router.router(vertx);

    router.route().handler(routingContext -> {
      routingContext.response().putHeader("content-type", "text/html").end("Stop Me!!!");
    });

    vertx.createHttpServer().requestHandler(router::accept).listen(8080);
  }
}