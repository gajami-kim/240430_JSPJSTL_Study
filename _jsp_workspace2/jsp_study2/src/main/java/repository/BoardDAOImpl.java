package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import orm.DatabaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	private SqlSession sql;
	
	public BoardDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(BoardVO bvo) {
		log.info("insert dao in");
		int isOk = sql.insert("BoardMapper.add",bvo);
		if(isOk>0) {sql.commit();}
		return isOk;
	}

	@Override
	public List<BoardVO> list() {
		log.info("list dao in");
		return sql.selectList("BoardMapper.list");
	}

	@Override
	public BoardVO detail(int bno) {
		log.info("list dao in");
		return sql.selectOne("BoardMapper.detail", bno);
	}

	@Override
	public int update(BoardVO bvo) {
		log.info("update dao in");
		int isOk = sql.update("BoardMapper.update",bvo);
		if(isOk>0) {sql.commit();}
		return isOk;
	}

	@Override
	public int delete(int bno) {
		log.info("delete dao in");
		int isOk = sql.delete("BoardMapper.remove",bno);
		if(isOk>0) {sql.commit();}
		return isOk; 
	}

	@Override
	public List<BoardVO> postList(String id) {
		log.info("postList dao in");
		return sql.selectList("BoardMapper.post", id);
	}

}
