package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {

	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}

	@Override
	public int insert(BoardVO bvo) {
		log.info("insert service in");
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList() {
		log.info("list service in");
		return bdao.list();
	}

	@Override
	public BoardVO getDetail(int bno) {
		log.info("detail service in");
		return bdao.detail(bno);
	}

	@Override
	public int update(BoardVO bvo) {
		log.info("detail service in");
		return bdao.update(bvo);
	}

	@Override
	public int remove(int bno) {
		log.info("remove service in");
		return bdao.delete(bno);
	}

	@Override
	public List<BoardVO> postList(String id) {
		log.info("post service in");
		return bdao.postList(id);
	}
	
}
