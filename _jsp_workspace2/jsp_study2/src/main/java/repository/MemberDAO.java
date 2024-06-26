package repository;

import java.util.List;

import domain.memberVO;

public interface MemberDAO {

	int insert(memberVO mvo);

	memberVO login(memberVO mvo);

	int lastLogin(String id);

	int update(memberVO mvo);

	List<memberVO> list();

	int delete(String id);

}
