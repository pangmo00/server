package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.AmericaDTO;
import persistence.dto.DTO;
import persistence.dto.JapanDTO;
import persistence.mapper.AmericaMapper;
import persistence.mapper.JapanMapper;

import java.util.List;

public class AmericaDAO extends DAO{
    SqlSessionFactory sqlSessionFactory;

    public AmericaDAO(SqlSessionFactory sqlSessionFctory){
        this.sqlSessionFactory = sqlSessionFctory;
    }

    public List<DTO> selectAll(){
        List<DTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        AmericaMapper mapper = session.getMapper(AmericaMapper.class);
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
    public boolean insert(DTO dto) {
        boolean b = false;
        SqlSession session = sqlSessionFactory.openSession();
        AmericaMapper mapper = session.getMapper(AmericaMapper.class);
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
