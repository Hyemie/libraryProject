package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.example.demo.repository.MemberDao;

import vo.MemberVo;

@Component
public class MemberService {

	@Autowired
	private MemberDao dao;

	public boolean join(MemberVo member) throws DuplicateKeyException {
		try {
			if (dao.insert(member) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
		} finally {
			System.out.println("에러");
		}
		return false;
	}

	public boolean login(String id, String password) {
		if (dao.selectMemberNum(id, password) == 1) {
			return true;
		} else {
			return false;
		}
	}

	public MemberVo selectMember(String id) {
		return dao.selectMember(id);
	}

	public boolean updateUser(MemberVo member, String id) {
		MemberVo original = dao.selectMember(member.getId());
		if (id != null && id.equals(original.getId())) {
			dao.update(member);
			return true;
		} else {
			return false;
		}

	}

	public int deleteUser(String id) {
		MemberVo member = dao.selectMember(id);
		return dao.delete(member.getId());

	}

}
