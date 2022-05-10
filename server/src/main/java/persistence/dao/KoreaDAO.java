package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.KoreaDTO;
import persistence.dto.YuanDTO;
import persistence.mapper.KoreaMapper;
import persistence.mapper.YuanMapper;

import java.util.List;

public class KoreaDAO extends DAO{
    SqlSessionFactory sqlSessionFactory;

    public KoreaDAO(SqlSessionFactory sqlSessionFctory){
        this.sqlSessionFactory = sqlSessionFctory;
    }

    public List<KoreaDTO> selectAll(){
        List<KoreaDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        KoreaMapper mapper = session.getMapper(KoreaMapper.class);
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

    @Override
    public boolean insert() {
        return super.insert();
    }

    public boolean insert(KoreaDTO koreaDTO){
        boolean b = false;
        SqlSession session = sqlSessionFactory.openSession();
        KoreaMapper mapper = session.getMapper(KoreaMapper.class);
        try{
            b = mapper.insert(koreaDTO);
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
