package cn.mybatis.mydemo3.mapper;

import cn.mybatis.mydemo3.domain.Article;

public interface ArticleMapper {
    Article selectArticleByOrderId(int id);
}

