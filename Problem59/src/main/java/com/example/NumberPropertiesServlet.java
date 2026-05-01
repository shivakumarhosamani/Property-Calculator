package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * NumberPropertiesServlet
 * 
 * Provides a professional-grade interface for number property calculations.
 */
@WebServlet("/calculate")
public class NumberPropertiesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public NumberPropertiesServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String numStr = request.getParameter("number");
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Calculation Result</title>");
        out.println("<link href='https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600&display=swap' rel='stylesheet'>");
        out.println("<style>");
        out.println(":root { --primary: #2563eb; --bg: #f8fafc; --card: #ffffff; --text: #1e293b; --muted: #64748b; --border: #e2e8f0; --error: #ef4444; }");
        out.println("body { font-family: 'Inter', sans-serif; background-color: var(--bg); color: var(--text); display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; }");
        out.println(".card { background-color: var(--card); padding: 2.5rem; border-radius: 1rem; box-shadow: 0 10px 15px -3px rgba(0,0,0,0.1); width: 100%; max-width: 450px; }");
        out.println("h2 { margin: 0 0 1.5rem; font-size: 1.5rem; font-weight: 600; text-align: center; }");
        out.println("table { width: 100%; border-collapse: separate; border-spacing: 0; margin: 1.5rem 0; border: 1px solid var(--border); border-radius: 0.5rem; overflow: hidden; }");
        out.println("th, td { padding: 1rem; text-align: left; border-bottom: 1px solid var(--border); }");
        out.println("tr:last-child td { border-bottom: none; }");
        out.println("th { background-color: #f1f5f9; font-weight: 600; color: var(--muted); font-size: 0.875rem; text-transform: uppercase; letter-spacing: 0.05em; }");
        out.println(".val-cell { font-family: monospace; font-size: 1.1rem; font-weight: 600; color: var(--primary); text-align: right; }");
        out.println(".back-btn { display: block; width: 100%; padding: 0.75rem; background-color: #f1f5f9; color: var(--text); text-align: center; text-decoration: none; border-radius: 0.5rem; font-weight: 600; transition: background-color 0.2s; box-sizing: border-box; }");
        out.println(".back-btn:hover { background-color: var(--border); }");
        out.println(".error-box { background-color: #fef2f2; border: 1px solid #fee2e2; color: var(--error); padding: 1rem; border-radius: 0.5rem; margin-bottom: 1.5rem; text-align: center; font-size: 0.875rem; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='card'>");
        
        try {
            if (numStr == null || numStr.trim().isEmpty()) {
                throw new Exception("No number was provided.");
            }
            
            double num = Double.parseDouble(numStr);
            
            if (num <= 0) {
                throw new Exception("Please enter a positive value.");
            }
            
            double sq = num * num;
            double cube = num * num * num;
            double sqrt = Math.sqrt(num);
            
            out.println("<h2>Calculation Results</h2>");
            out.println("<table>");
            out.println("<thead><tr><th>Property</th><th style='text-align:right'>Value</th></tr></thead>");
            out.println("<tbody>");
            out.println("<tr><td>Input Value</td><td class='val-cell'>" + num + "</td></tr>");
            out.println("<tr><td>Square</td><td class='val-cell'>" + String.format("%.2f", sq) + "</td></tr>");
            out.println("<tr><td>Cube</td><td class='val-cell'>" + String.format("%.2f", cube) + "</td></tr>");
            out.println("<tr><td>Square Root</td><td class='val-cell'>" + String.format("%.2f", sqrt) + "</td></tr>");
            out.println("</tbody>");
            out.println("</table>");
            
        } catch (NumberFormatException e) {
            out.println("<h2>Error</h2>");
            out.println("<div class='error-box'>The provided input is not a valid number.</div>");
        } catch (Exception e) {
            out.println("<h2>Error</h2>");
            out.println("<div class='error-box'>" + e.getMessage() + "</div>");
        }
        
        out.println("<a href='index.html' class='back-btn'>Back to Calculator</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
