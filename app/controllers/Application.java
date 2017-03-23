package controllers;

import play.mvc.*;
import play.Logger;
import views.html.*;
import play.data.DynamicForm;
import play.data.Form;


public class Application extends Controller {


	// public static Result GO_HOME = redirect(
 //            routes.Application.logout()
 //    );
    public Result login() {
        return ok(login.render());
    }
    // public Result logouthtml() {
    //     return ok(logouthtml.render());
    // }

    public Result loginSubmit()
    {
    	DynamicForm dynamicForm = Form.form().bindFromRequest();
    	Logger.info("Username is: " + dynamicForm.get("username"));
    	Logger.info("Password is: " + dynamicForm.get("password"));
    	session("connected", "user@gmail.com");
    	// return ok();
    	// return redirect(
     //        routes.Application.logout()
     //    );
    	return redirect(logouthtml.render());

    }
    public Result logoutSubmit() 
    {
    	session().remove("connected");
    	return ok("Bye");
	}


}

 
