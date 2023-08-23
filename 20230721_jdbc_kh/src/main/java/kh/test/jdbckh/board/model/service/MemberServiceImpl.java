public class MemberServiceImpl {
	MemberDAOLogic memberDAO = new MemberDAOLogic();

	public int insertMember(MemberVO mOne) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = memberDAO.insertMember(session, mOne);
		if (result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
}
