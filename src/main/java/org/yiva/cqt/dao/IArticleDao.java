package org.yiva.cqt.dao;

import java.util.ArrayList;

import org.yiva.cqt.model.Article;

public interface IArticleDao {

	public ArrayList<Article> queryArticles();
}
