package com.example.demo.service.impl;

import com.example.demo.domain.MpDemo;
import com.example.demo.mapper.MpDemoMapper;
import com.example.demo.service.IMpDemoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * mybatis plus demo 表 服务实现类
 * </p>
 *
 * @author kirito
 * @since 2021-12-25
 */
@Service
public class MpDemoServiceImpl extends ServiceImpl<MpDemoMapper, MpDemo> implements IMpDemoService {

}
