package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * mybatis plus demo 表
 * </p>
 *
 * @author kirito
 * @since 2021-12-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "MpDemo对象", description = "mybatis plus demo 表")
public class MpDemo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "状态 0正常 -1删除")
    @TableField("data_status")
    private Integer dataStatus;


}
