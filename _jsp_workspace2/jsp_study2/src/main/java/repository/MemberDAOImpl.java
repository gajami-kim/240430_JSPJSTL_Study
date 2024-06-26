package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.memberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(memberVO mvo) {
		log.info("insert dao in");
		int isOk = sql.insert("MemberMapper.register",mvo);
		if(isOk>0) {sql.commit();}
		return isOk;
	}

	@Override
	public memberVO login(memberVO mvo) {
		log.info("login dao in");
		return sql.selectOne("MemberMapper.login",mvo);
	}

	@Override
	public int lastLogin(String id) {
		log.info("lastLogin dao in");
		int isOk = sql.update("MemberMapper.lastlogin",id);
		if(isOk>0) {sql.commit();}
		return isOk; 
	}

	@Override
	public int update(memberVO mvo) {
		log.info("lastLogin dao in");
		int isOk = sql.update("MemberMapper.modify",mvo);
		if(isOk>0) {sql.commit();}
		return isOk;
	}

	@Override
	public List<memberVO> list() {
		log.info("list dao in");
		return sql.selectList("MemberMapper.list");
	}

	@Override
	public int delete(String id) {
		log.info("delete dao in");
		int isOk = sql.delete("MemberMapper.remove",id);
		if(isOk>0) {sql.commit();}
		return isOk;
	}

}
