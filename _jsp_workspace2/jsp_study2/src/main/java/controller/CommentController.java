package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import service.CommentService;
import service.CommentServiceImpl;


@WebServlet("/cmt/*")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CommentController.class);
	private CommentService csv;
 
    public CommentController() {
    	csv = new CommentServiceImpl();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String url = request.getRequestURI();
		String path = url.substring(url.lastIndexOf("/")+1);
		
		switch(path) {
		case "post":
			try {
				log.info("post case check 1");
				StringBuffer sb = new StringBuffer();
				String line="";
				BufferedReader br = request.getReader();
				while((line=br.readLine())!=null) {
					sb.append(line);
				}
				log.info(">>>>sb {}",sb.toString());
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				log.info(">>>>jsonObj {}", jsonObj);
				
				int bno = Integer.parseInt(jsonObj.get("bno").toString());
				String writer = jsonObj.get("writer").toString();
				String content = jsonObj.get("content").toString();
				
				CommentVO cvo = new CommentVO(bno, writer, content);
				int isOk = csv.post(cvo);
				log.info(">>>cvo{}", cvo);
				log.info("isOk {}",(isOk>0?"성공":"실패"));
				
				PrintWriter out = response.getWriter();
				out.print(isOk);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "list":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

}
