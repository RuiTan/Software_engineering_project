package top.guitoubing.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.guitoubing.mapper.UserMapper;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test(){
        System.out.println(userMapper.selectByTel("18936361545").getName());
//        System.out.println(trainMapper.selectByPrimaryKey((short) 930));
//        System.out.println(carrigeMapper.selectByPrimaryKey("91792"));
//        System.out.println(trainMapper.list().size());
//        System.out.println(splitReportProbabilityMapper.list());
//        List<SplitReportProbability> splitReportProbabilities = splitReportProbabilityMapper.selectByDistanceRange(10001);
//        System.out.println(splitReportProbabilities);
    }
//
//    @Test
//    public void testAdd(){
//        for (int i = 0; i < 100; i++){
//            Category category = new Category();
//            category.setName("new Category");
//            categoryMapper.add(category);
//        }
//    }
//
//    @Test
//    public void testTotal(){
//        int total = categoryMapper.total();
//        System.out.println(total);
//    }
//
//    @Test
//    public void testList(){
//        Page p = new Page();
//        p.setStart(2);
//        p.setCount(3);
//        List<Category> cs = categoryMapper.list(p);
//        for (Category c : cs){
//            System.out.println(c.getName());
//        }
//    }

//    @Test
//    public void testStudentAdd(){
//        for (int i = 0; i < 100; i++){
//            Lover lover = new Lover();
//            lover.setId(i);
//            lover.setName("FangFang");
//            loverMapper.insert(lover);
//        }
//    }

//    @Test
//    public void testMD5(){
//        String pwd = "tanrui";
//        System.out.println(MD5Validate.getMd5(pwd));
//        System.out.println(MD5Validate.validateMd5(pwd, MD5Validate.getMd5(pwd)));
//    }
//

}
