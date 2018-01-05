import me.lumen.demo.dao.ProductMapper;
import me.lumen.demo.domain.Product;
import me.lumen.demo.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by lumen on 18-1-5.
 */
public class Test {
    public static void main(String[] args){
        SqlSessionFactory sqlSessionFactory =SqlSessionFactoryUtil.getSqlSessionFactory();
//        sqlSessionFactory.getConfiguration().addMapper(ProductMapper.class);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            Product product = productMapper.select(1);
            System.out.println(product.toString());
        }finally {
            sqlSession.close();
        }
    }
}
