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
        return ok(login.render("tets"));
    }
    // public Result logouthtml() {
    //     return ok(logouthtml.render());
    // }

    public Result loginSubmit()
    {
    	DynamicForm dynamicForm = Form.form().bindFromRequest();
    	Logger.info("Username is: " + dynamicForm.get("username"));
    	Logger.info("Password is: " + dynamicForm.get("password"));
    	String email = dynamicForm.get("username");
    	session("connected", email);
    	// return ok();
    	// return redirect(
     //        routes.Application.logout()
     //    );
    	return ok(index.render(email));//couldn't figure out how to redirect to logoutsala.html
    								   // so redirecting to this site

    }
    public Result logoutSubmit() 
    {	
    	session().remove("connected");
    	return ok(login.render("You logged out"));
	}


}

 
