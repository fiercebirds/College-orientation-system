package cn.edu.scau.yx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.scau.yx.dao.ProblemsMapper;
import cn.edu.scau.yx.entity.Problems;
import cn.edu.scau.yx.service.interfaces.ProblemsService;

@Service
public class ProblemsServiceImpl implements ProblemsService{

	
	//注入Service依赖
	@Autowired
	private ProblemsMapper problemsMapper;
	
	
	public int delById(int problemsId) {
		int delCount=problemsMapper.delProblemsById(problemsId);
		return delCount;
	}

//	public List<Problems> getById(int problemsId) {
//		return problemsMapper.findById(problemsId);
//	}
	public Problems getById(int problemsId) {
		return problemsMapper.findById(problemsId);
	}

	public List<Problems> getList() {
		return problemsMapper.findAll();
	}

	public List<Problems> getListByCondition(String audit, String authority, String keyWord) {
		return problemsMapper.findWithKey(audit, authority, keyWord);
	}

	@Override
	public int replyById(int problemsId,Problems problems) {
		int updateCount = problemsMapper.updateContentById(problemsId,problems);
		return updateCount;
	}

	/**
	 * 添加咨询记录
	 */
	@Override
	public int addProblems(Problems problems) {
		int addCount = problemsMapper.insertProblems(problems);
		return addCount;
	}

	@Override
	public List<Problems> getListByUserId(int userId) {
		List<Problems> problems = problemsMapper.findByUserId(userId);
		return problems;
	}

	@Override
	public List<Problems> getSearchByUserId(int userId,String keyWord) {
		return problemsMapper.searchByUserId(userId,keyWord);
	}

}
