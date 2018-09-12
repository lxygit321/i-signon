package ca.gc.cra.kr.apps.isignon.isignonserver.dao;

import ca.gc.cra.kr.apps.isignon.isignonserver.domain.PacmanComponent;
import ca.gc.cra.kr.apps.isignon.isignonserver.mappers.PacmanComponentMapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacmanComponentDao
{
    private PacmanComponentMapper pacmanComponentMapper;
    private final SqlSession sqlSession;

    public PacmanComponentDao(SqlSession sqlSession) {this.sqlSession = sqlSession;}


//    public void setPacmanComponentMapper(PacmanComponentMapper pacmanComponentMapper)
//    {
//        this.pacmanComponentMapper = pacmanComponentMapper;
//    }

    public List<PacmanComponent> findAllComponents() {
        return this.sqlSession.getMapper(PacmanComponentMapper.class).findAllComponents();
    }
}
