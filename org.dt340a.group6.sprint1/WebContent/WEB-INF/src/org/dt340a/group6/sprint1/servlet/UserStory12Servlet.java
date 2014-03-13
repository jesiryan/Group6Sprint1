package org.dt340a.group6.sprint1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dt340a.group6.sprint1.entity.CallFailure;

/**
 * Servlet implementation class User12Servlet
 */
@WebServlet("/User12Servlet")
public class UserStory12Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Date startDate, endDate;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		
		try {
			startDate = sdf.parse(request.getParameter("startDateTime"));
			endDate = sdf.parse(request.getParameter("endDateTime"));
		} catch (ParseException e) { e.printStackTrace();}
		
		System.out.println("Start date: "+request.getParameter("startDateTime")+ "  " +startDate);
		System.out.println("End date: "+request.getParameter("endDateTime")+ "  " +endDate);
		
		String currentStory = request.getParameter("userStoryNumber");
		
//		IMSIQuery query = new IMSIQuery();
//		List<CallFailure> callFailures = query.viewInfoForIMSI(imsi);
		
		beginHTMLPrintout(out, currentStory);

		endHTMLPrintout(out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * Begin the HTML printout for the page <br> (up until the result display section)
	 * @param out PrintWriter
	 * @param currentStory String
	 */
	private void beginHTMLPrintout(PrintWriter out, String currentStory) {
		genericHeader(out);
		startBody(out);
		if(currentStory.equals("us4")){
			out.println("                <h4>User Story 4</h4>");
			out.println("                <h4> As Customer Service Rep. I want to display, for a given affected IMSI, <br>the Event ID and Cause Code for any / all failures affecting that IMSI</h4>");
		}
		else if(currentStory.equals("us6")){
			out.println("                <h4>User Story 6</h4>");
			out.println("                <h4>As a customer service rep, I want to see, for a given IMSI, <br>all the unique cause codes associated with its call failures.</h4>");
		}
		out.println("            </div>");
		startTable(out);
	}
	
	/**
	 * Start the html tag <br> Fill out the generic head tag for html
	 * @param out
	 */
	private void genericHeader(PrintWriter out) {
		out.println("<html>");
		out.println("    <head>");
		out.println("       <title>Dt340a - Group 6</title>");
		out.println("      <link rel='icon' type='image/ico' href='http://www.ericsson.com/favicon.ico'/>");
		out.println("        <link rel='stylesheet' type='text/css' href='css/mystyle.css'>");
		out.println("        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		out.println("    </head>");
	}
	
	/**
	 * Starts the generic body of the html
	 * @param out PrintWriter
	 */
	private void startBody(PrintWriter out) {
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
	}
	
	/**
	 * Create the back button & container and start the results table
	 * @param out PrintWriter
	 */
	private void startTable(PrintWriter out) {
		out.println("            <div id='inner-container' >  ");
		out.println("            <form method=GET action='imsiQuery'>");
		out.println("               <input Type='button' VALUE='Back' onClick='history.go(-2);return true;'>");
		out.println("            </form>");
		out.println("            </div>");
		out.println("            <div id='inner-container'>");
		out.println("                <table id='customers'>");
	}
	
	/**
	 * Finishes off the table for the results, prints the bottom grad, closes the html tags
	 * @param out PrintWriter
	 */
	private void endHTMLPrintout(PrintWriter out) {
		out.println("");
		out.println("                </table>");
		out.println("            </div>");
		out.println("         </div>");
		out.println("         <div id='eric-multi'>");
		out.println("              <img src='images/ebottomgrad.jpg' >");
		out.println("         </div>");
		out.println("    </body>");
		out.println("</html>");
	}
	
}
