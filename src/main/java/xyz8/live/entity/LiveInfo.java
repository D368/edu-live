package xyz8.live.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import xyz8.live.common.BaseEntity;

/**
 * 资源表(LiveInfo)表实体类
 *
 * @author liangw
 * @since 2020-08-11 13:43:51
 */
@SuppressWarnings("serial")
@Data
@TableName("live_info")
@ApiModel("资源表")
public class LiveInfo extends BaseEntity {
    /**
     * 资源ID
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "资源ID", name = "id")
    private Long id;
    /**
     * 直播名称
     */
    @ApiModelProperty(value = "直播名称", name = "liveName")
    private String liveName;
    /**
     * 直播key
     */
    @ApiModelProperty(value = "直播key", name = "liveKey")
    private String liveKey;
    /**
     * 直播用户ID
     */
    @ApiModelProperty(value = "直播用户ID", name = "userId")
    private Long userId;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;



}