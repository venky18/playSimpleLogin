package controllers;

import play.mvc.*;
import play.Logger;
import views.html.*;
import play.data.DynamicForm;
import play.data.Form;


public class Application extends Controller {


    public Result login() {
        return ok(login.render("no user logged in"));
    }
    // public Result logouthtml() {
    //     return ok(logouthtml.render());
    // }

    public Result loginSubmit()
    {
    	DynamicForm dynamicForm = Form.form().bindFromRequest();
    	Logger.info("Username is: " + dynamicForm.get("username"));
    	Logger.info("Password is: " + dynamicForm.get("password"));
    	String username = dynamicForm.get("username");
        String password = dynamicForm.get("password");
        if (username.equals("netlogo") && password.equals("pass"))
        {
             session("connected", username);
            return ok(index.render("connected with username "+username));
        }

        return badRequest(login.render("NOT VALID PASSWORD"));
                                       

        // return badRequest(login.render("NOT VALID PASSWORD"));
    	
    	// return ok();
    	// return redirect(
     //        routes.Application.logout()
     //    );

    }
    public Result logoutSubmit() 
    {	
    	session().remove("connected");
        session().clear();
    	return ok(login.render("You logged out"));
	}


}

 
