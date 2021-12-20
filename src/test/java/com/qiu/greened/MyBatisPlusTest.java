//package com.qiu.greened;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.qiu.greened.mapper.UserMapper;
//import com.qiu.greened.pojo.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//
///**
// * MyBatisPlus测试
// */
//@SpringBootTest
//public class MyBatisPlusTest {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    /**
//     * 查询所有
//     */
//    @Test
//    public void testSelect() {
//        System.out.println(("----- selectAll method test ------"));
//        List<User> userList = userMapper.selectList(null);
////        Assert.assertEquals(5, userList.size());
//        userList.forEach(System.out::println);
//    }
//
//    /**
//     * 根据id查询
//     */
//    @Test
//    public void testSelectById() {
////        User user = userMapper.selectById(1);
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("id", 1);
//        queryWrapper.select("name", "email");
//        User user = userMapper.selectOne(queryWrapper);
//        System.out.println(user);
//    }
//
//    /**
//     * 条件查询
//     */
//    @Test
//    public void testQueryWrapper() {
//        //名字带J
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name", "%J%");
//        List<User> users = userMapper.selectList(queryWrapper);
//        users.forEach(System.out::println);
//    }
//
//    /**
//     * 插入数据
//     */
//    @Test
//    public void testInstallData() {
//        User user = new User("Cat", 12, "aacjawjwj@1.com");
////        user.setCreateTime(new Date());
////        user.setUpdateTime(new Date());
//        userMapper.insert(user);
//    }
//
//    /**
//     * 删除数据
//     */
//    @Test
//    public void testDeleteDataById() {
//        String projectPath = System.getProperty("user.dir");
//        System.out.println(projectPath);
//    }
//
//    /**
//     * 更新数据
//     */
//    @Test
//    public void testUpDateById() {
//
//    }
//
//}