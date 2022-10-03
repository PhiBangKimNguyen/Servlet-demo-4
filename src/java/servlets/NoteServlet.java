package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Phi
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(new File(path)))) {
            String title = br.readLine();
            String contents = br.readLine();
            
            Note note = new Note (title, contents);
            request.setAttribute("note", note);
            
            String edit = request.getParameter("edit");
                     
            if(edit == null){
                this.getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);              
            } else {
                this.getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            }
        } catch (FileNotFoundException fileNotFound) {
            System.out.println(fileNotFound);
        }
    }
         
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");

        Note note = new Note(title,contents);
        request.setAttribute("note",note);
        
        try (PrintWriter pw = new PrintWriter(new BufferedWriter (new FileWriter(path,false)))) {
            pw.println(title);
            pw.println(contents);
        } catch (FileNotFoundException fileNotFound) {
            System.out.println(fileNotFound);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request,response);
    
    }

  
}
