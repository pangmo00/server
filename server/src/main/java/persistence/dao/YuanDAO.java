package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.DTO;
import persistence.dto.YuanDTO;
import persistence.mapper.YuanMapper;

import java.util.List;

public class YuanDAO extends DAO{
    SqlSessionFactory sqlSessionFactory;

    public YuanDAO(SqlSessionFactory sqlSessionFctory){
        this.sqlSessionFactory = sqlSessionFctory;
    }

    public List<YuanDTO> selectAll(){
        List<YuanDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        YuanMapper mapper = session.getMapper(YuanMapper.class);
        try{
            list = mapper.selectAll();
            session.commit();
        }catch(Exception e){
            e.getStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return list;
    }

    public boolean insert(DTO dto){
        boolean b = false;
        SqlSession session = sqlSessionFactory.openSession();
        YuanMapper mapper = session.getMapper(YuanMapper.class);
        try{
            b = mapper.insert(dto);
            session.commit();
        }catch (Exception e) {
            e.getStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        return b;
    }

}
