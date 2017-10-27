package org.yiva.cqt.core.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.yiva.cqt.core.IArticleService;
import org.yiva.cqt.dao.IArticleDao;
import org.yiva.cqt.model.Article;

@Service("articleService")
public class ArticleServiceImpl implements IArticleService{

	@Autowired
	@Qualifier("articleDao")
	private IArticleDao articleDao;
	

	@Override
	public ArrayList<Article> findAllArticles() {
		// TODO Auto-generated method stub
		return articleDao.queryArticles();
	}

}
