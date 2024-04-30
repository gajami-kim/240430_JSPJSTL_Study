package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import domain.memberVO;
import service.BoardService;
import service.BoardServiceImpl;


@WebServlet("/brd/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(BoardController.class);
    
    private RequestDispatcher rdp;
    private String destPage="";
    private int isOk;
    private BoardService bsv;
    
    public BoardController() {
    	bsv = new BoardServiceImpl();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//메서드 실행
//		log.info("잘들어오는지 test");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(path);
		
		switch(path) {
		case "register":
			destPage = "/board/register.jsp";
			break;
		case "insert":
			try {
				String title = request.getParameter("title");
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				BoardVO bvo = new BoardVO(title, writer, content);
				int isOk = bsv.insert(bvo);
				log.info("insert isOk>>>{}",isOk);
				destPage = "/index.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "list":
			try {
				List<BoardVO> list = bsv.getList();
				log.info("list isOk>>>{}",list);
				request.setAttribute("list", list);
				destPage = "/board/list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "detail": case "modify":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				log.info(">>>> "+bno);
				BoardVO bvo = bsv.getDetail(bno);
				log.info("detail isOk>>>{}",bvo);
				request.setAttribute("bvo", bvo);
				destPage="/board/"+path+".jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "update":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				BoardVO bvo = new BoardVO(bno,title,content);
				int isOk = bsv.update(bvo);
				log.info("update isOk>>>{}",isOk);
				destPage = "detail";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "delete":
			try {
				int bno = Integer.parseInt(request.getParameter("bno"));
				int isOk = bsv.remove(bno);
				log.info("delete isOk>>>{}",isOk);
				destPage = "/brd/list";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "mypost":
			try {
				HttpSession ses = request.getSession();
				String id = ((memberVO)ses.getAttribute("ses")).getId();
				log.info(id);
				List<BoardVO> postList = bsv.postList(id);
				log.info(">>{}",postList);
				request.setAttribute("postList", postList);
				destPage = "/board/mypost.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
	
		
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request,response);
	}

}
