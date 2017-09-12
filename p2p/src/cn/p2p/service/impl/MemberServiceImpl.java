package cn.p2p.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.p2p.dao.MemberMapper;
import cn.p2p.pojo.Member;
import cn.p2p.service.MemberService;

@Service(value = "memberService")
public class MemberServiceImpl implements MemberService {
	@Resource
	private MemberMapper memberMapper;

	@Override
	public Member findMemberByName(String username) {
		Member member = memberMapper.findMemberByName(username);
		return member;
	}

	@Override
	public List<Member> findByAdmin(Integer from, Integer pageSize) {
		return memberMapper.findByAdmin(from, pageSize);
	}

	@Override
	public Integer findByAdminCount() {
		return memberMapper.findByAdminCount();
	}

	@Override
	public boolean deleteById(Integer id) {
		boolean falg = false;
		int i = memberMapper.deleteById(id);
		if (i > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public Member findMemberById(Integer id) {
		return memberMapper.findMemberById(id);
	}

	@Override
	public boolean alter(Member member) {
		boolean falg = false;
		int i = memberMapper.alter(member);
		if (i > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public boolean add(Member member) {
		boolean falg = false;
		int i = memberMapper.add(member);
		if (i > 0) {
			falg = true;
		}
		return falg;
	}

	@Override
	public List<Member> findAll(String username, Integer from, Integer pageSize) {
		return memberMapper.findAll(username, from, pageSize);
	}

	@Override
	public int findAllCount(String username) {
		return memberMapper.findAllCount(username);
	}

}
