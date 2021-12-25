package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;
import com.example.demo.config.MybatisPlusConfig;
import com.example.demo.config.R;
import com.example.demo.domain.MpDemo;
import com.example.demo.mapper.MpDemoMapper;
import com.example.demo.service.IMpDemoService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kirito
 * @desc ...
 * @date 2021-10-26 16:24:39
 */
@Slf4j
@RestController
@Api(tags = "999 测试")
@ApiSort(999)
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final MpDemoMapper mpDemoMapper;
    private final IMpDemoService iMpDemoService;

    //http://localhost:8080/doc.html
    //
    @ApiOperation(value = "count查询报错测试", notes = "")
    @ApiOperationSupport(order = 1)
    @PostMapping("/count")
    public R<?> count() {
        LambdaQueryChainWrapper<MpDemo> queryChainWrapper = ChainWrappers.lambdaQueryChain(mpDemoMapper)
                .select(MpDemo::getId, MpDemo::getName)
                .eq(MpDemo::getDataStatus, 0);
        Long count = queryChainWrapper.count();
        System.out.println("count = " + count);
        List<MpDemo> demoList = queryChainWrapper.list();
        demoList.forEach(System.out::println);
        return R.newSuccessResponse("success");
    }

    /**
     * mybatis-plus 3.4.3.1
     * 使用queryChainWrapper，在count前select了一下
     * sql为
     * SELECT COUNT(  id,name  ) FROM mp_demo     WHERE (data_status = ?)
     *
     * 报错
     * {
     *   "code": 999,
     *   "msg": "org.springframework.jdbc.BadSqlGrammarException: \r\n### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'name\n ) FROM mp_demo \n \n WHERE (data_status = 0)' at line 2\r\n### The error may exist in com/example/demo/mapper/MpDemoMapper.java (best guess)\r\n### The error may involve defaultParameterMap\r\n### The error occurred while setting parameters\r\n### SQL: SELECT COUNT(  id,name  ) FROM mp_demo     WHERE (data_status = ?)\r\n### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'name\n ) FROM mp_demo \n \n WHERE (data_status = 0)' at line 2\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'name\n ) FROM mp_demo \n \n WHERE (data_status = 0)' at line 2",
     *   "data": null
     * }
     */
}
