package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.memberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImpl implements MemberService {

	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	private MemberDAO mdao;
	
	public MemberServiceImpl() {
		mdao = new MemberDAOImpl();
	}

	@Override
	public int register(memberVO mvo) {
		log.info("register service in");
		return mdao.insert(mvo);
	}

	@Override
	public memberVO login(memberVO mvo) {
		log.info("login service in");
		return mdao.login(mvo);
	}

	@Override
	public int lastLogin(String id) {
		log.info("lastLogin service in");
		return mdao.lastLogin(id);
	}

	@Override
	public int update(memberVO mvo) {
		log.info("update service in");
		return mdao.update(mvo);
	}

	@Override
	public List<memberVO> getList() {
		log.info("getList service in");
		return mdao.list();
	}

	@Override
	public int remove(String id) {
		log.info("remove service in");
		return mdao.delete(id);
	}

}
