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
 * 用户信息表(User)表实体类
 *
 * @author liangw
 * @since 2020-08-11 14:12:30
 */
@SuppressWarnings("serial")
@Data
@TableName("user")
@ApiModel("用户信息表")
public class User extends BaseEntity {
    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID", name = "userId")
    private Long userId;
    /**
     * 部门ID
     */
    @ApiModelProperty(value = "部门ID", name = "deptId")
    private Long deptId;
    /**
     * 用户账号
     */
    @ApiModelProperty(value = "用户账号", name = "userName")
    private String userName;
    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称", name = "nickName")
    private String nickName;
    /**
     * 用户类型（00系统用户）
     */
    @ApiModelProperty(value = "用户类型（00系统用户）", name = "userType")
    private String userType;
    /**
     * 用户邮箱
     */
    @ApiModelProperty(value = "用户邮箱", name = "email")
    private String email;
    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码", name = "phonenumber")
    private String phonenumber;
    /**
     * 用户性别（0男 1女 2未知）
     */
    @ApiModelProperty(value = "用户性别（0男 1女 2未知）", name = "sex")
    private String sex;
    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址", name = "avatar")
    private String avatar;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", name = "password")
    private String password;
    /**
     * 帐号状态（0正常 1停用）
     */
    @ApiModelProperty(value = "帐号状态（0正常 1停用）", name = "status")
    private String status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）", name = "delFlag")
    private String delFlag;
    /**
     * 最后登陆IP
     */
    @ApiModelProperty(value = "最后登陆IP", name = "loginIp")
    private String loginIp;
    /**
     * 最后登陆时间
     */
    @ApiModelProperty(value = "最后登陆时间", name = "loginDate")
    private Date loginDate;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;


}