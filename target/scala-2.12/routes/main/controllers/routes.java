// @GENERATOR:play-routes-compiler
// @SOURCE:/home/david/Documents/interview/transaction/conf/routes
// @DATE:Tue Apr 14 22:28:24 CDT 2020

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
  }

}
