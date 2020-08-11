package xyz8.live.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LiangWei
 * @date 2020/8/11 13:11
 */
public class BaseEntity implements Serializable {
    /**
     * 乐观锁
     */
    private Long revision;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updatedBy;
    /**
     * 更新时间
     */
    private Date updatedTime;

}
