package org.dt340a.group6.sprint1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dt340a.group6.sprint1.query.IMSIQuery;
import org.dt340a.group6.sprint1.entity.CallFailure;
import org.dt340a.group6.sprint1.validation.PrimitiveCheck;

public class ImsiQueryServlet extends HttpServlet{
	
	String imsi;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();		
		imsi = req.getParameter("username");
		String currentStory = req.getParameter("userStoryNumber");
		
		IMSIQuery query = new IMSIQuery();
		List<CallFailure> callFailures = query.viewInfoForIMSI(imsi);
		
		topText(out, currentStory);
		
		if (PrimitiveCheck.isLong(imsi)) {
			if (callFailures == null) {
				noResultsFound(out);
			}
			else {
				if(currentStory.equals("us4")){
					midUS4(out, callFailures);
				}
				if(currentStory.equals("us6")){
					Boolean found = false;
					ArrayList<CallFailure> alreadySeenCallFailureCodes = new ArrayList<CallFailure>();
					for(CallFailure currentCallFailure : callFailures){
						for(CallFailure currentCF : alreadySeenCallFailureCodes){
							if(currentCallFailure.getCause().getCauseCode() == currentCF.getCause().getCauseCode()){
								found = true;
								break;
							}
						}
						if(!found){
							alreadySeenCallFailureCodes.add(currentCallFailure);
						}
						found = false;
					}
					midUS6(out, callFailures);
					System.out.println("user story 6");
				}
				else{
					System.out.println("************PROBLEM****************");
				}
			}
		}
		else {
			notAValidImsi(out);
		}
		
		bottomText(out);		
	}
	
	private void notAValidImsi(PrintWriter out) {
		out.println("                    <tr>");
		out.println("                      <td>Warning Message:</td>");
		out.println("                    </tr>");
		out.println("                    <tr>");
		out.println("                      <td>The value '" + imsi + "' is not a valid IMSI. Please enter a valid IMSI.</td>");
		out.println("                    </tr>");
	}
	
	private void noResultsFound(PrintWriter out) {
		out.println("                    <tr>");
		out.println("                      <td>Information Message:</td>");
		out.println("                    </tr>");
		out.println("                    <tr>");
		out.println("                      <td>This search has returned 0 results for IMSI: " + imsi + " </td>");
		out.println("                    </tr>");
    }
	
	private void midUS4(PrintWriter out, List<CallFailure> callFailures) {
		int count=0;
		out.println("                    <tr class='alt'>");
		out.println("                      <td>IMSI Number:</td>");
        out.println("                      <td>"+imsi+"</td>");
        out.println("                      <td></td>");
		out.println("                    </tr>");
		out.println("                    <tr>");		
		out.println("                      <th>Event ID</th>");
        out.println("                      <th>Cause Code</th>");
        out.println("                      <th>Description</th>");
		out.println("                    </tr>");
		for(CallFailure fail : callFailures){
			
			if (count%2==0) {
				out.println("                    <tr>");

				out.println("                      <td>" + (int)fail.getCause().getEventId() + "</td>");
                out.println("                      <td>" + (int)fail.getCause().getCauseCode() + "</td>");
                out.println("                      <td>" + fail.getCause().getDescription() + "</td>");
				out.println("                    </tr>");
			}
			else {
				out.println("                    <tr class='alt'>");

				out.println("                      <td>" + (int)fail.getCause().getEventId() + "</td>");
				out.println("                      <td>" + (int)fail.getCause().getCauseCode() + "</td>");
                out.println("                      <td>" + fail.getCause().getDescription() + "</td>");
				out.println("                    </tr>");
			}
			count++;
		}
	}
	
	private void midUS6(PrintWriter out, List<CallFailure> callFailures) {
		int count=0;
		out.println("                    <tr class='alt'>");
		out.println("                      <td>IMSI Number:</td>");
        out.println("                      <td>"+imsi+"</td>");
        out.println("                      <td></td>");
		out.println("                    </tr>");
		out.println("                    <tr>");		
		out.println("                      <th>*****</th>");
        out.println("                      <th>Cause Code</th>");
        out.println("                      <th>Description</th>");
		out.println("                    </tr>");
		for(CallFailure fail : callFailures){
			
			if (count%2==0) {
				out.println("                    <tr>");

				out.println("                      <td>" + "</td>");
                out.println("                      <td>" + (int)fail.getCause().getCauseCode() + "</td>");
                out.println("                      <td>" + fail.getCause().getDescription() + "</td>");
				out.println("                    </tr>");
			}
			else {
				out.println("                    <tr class='alt'>");

				out.println("                      <td>" + "</td>");
				out.println("                      <td>" + (int)fail.getCause().getCauseCode() + "</td>");
                out.println("                      <td>" + fail.getCause().getDescription() + "</td>");
				out.println("                    </tr>");
			}
			count++;
		}
	}
	
	private void topText(PrintWriter out, String currentStory) {
		out.println("<html>");
		out.println("    <head>");
		out.println("       <title>Dt340a - Group 6</title>");
		out.println("      <link rel='icon' type='image/ico' href='http://www.ericsson.com/favicon.ico'/>");
		out.println("        <link rel='stylesheet' type='text/css' href='css/mystyle.css'>");
		out.println("        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		out.println("    </head>");
		out.println("    <body>");
		out.println("        <div id='container'>");
		out.println("            <div id='heading-container'>");
		out.println("                <div id='eir-image'> ");
		out.println("                    <img alt='Ericsson' src='http://www.ericsson.com/shared/eipa/images/elogo.png'>   ");
		out.println("                </div> ");
		out.println("                <div id='dit-image'> ");
		out.println("                     <img alt='DIT' src='http://www.dit.ie/media/styleimages/dit_crest.gif' width='90px' height='90px'>  ");
		out.println("                </div> ");
		out.println("                <h1>Call Investigation Assistant</h1>");
		out.println("                <h2>Group 6</h2>");
		out.println("                <h3>Customer Service Representative View</h3>");
		if(currentStory.equals("us4")){
			out.println("                <h4>User Story 4</h4>");
			out.println("                <h4> As Customer Service Rep. I want to display, for a given affected IMSI, <br>the Event ID and Cause Code for any / all failures affecting that IMSI</h4>");
		}
		else if(currentStory.equals("us6")){
			out.println("                <h4>User Story 6</h4>");
			out.println("                <h4>As a customer service rep, I want to see, for a given IMSI, <br>all the unique cause codes associated with its call failures.</h4>");
		}
		out.println("            </div>");
		out.println("            <div id='inner-container' >  ");
		out.println("            <form method=GET action='imsiQuery'>");
		out.println("               <input class='submissionfield' type='text' name='username' placeholder='Please Enter an IMSI number Here' required='required' >");
		out.println("               <input type='submit'>");
		out.println("               <input Type='button' VALUE='Back' onClick='history.go(-2);return true;'>");
		out.println("            </form>");
		out.println("            </div>");
		out.println("            <div id='inner-container'>");
		out.println("                <table id='customers'>");
	}
	
	private void bottomText(PrintWriter out) {
		out.println("");
		out.println("                </table>");
		out.println("            </div>");
		out.println("        </div>");
		out.println("         <div id='eric-multi'>");
		out.println("                       <img src='images/ebottomgrad.jpg' >");
		out.println("         </div>");
		out.println("    </body>");
		out.println("</html>");
	}


}