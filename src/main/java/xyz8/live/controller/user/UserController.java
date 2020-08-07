package xyz8.live.controller.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz8.live.common.result.ResResult;
import xyz8.live.entity.User;
import xyz8.live.service.UserService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 用户信息表(User)表控制层
 *
 * @author liangw
 * @since 2020-08-06 17:10:57
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户")
public class UserController extends ApiController {
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public ResResult<IPage<User>> selectAll(Page<User> page, User user) {
        return ResResult.success(userService.page(page, new QueryWrapper<>(user)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("ID查询")
    public ResResult<User> selectOne(@PathVariable Serializable id) {
        return ResResult.success(this.userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation("新增")
    public ResResult insert(@RequestBody User user) {
        boolean b = this.userService.save(user);
        if (b){
            return ResResult.success();
        }
        return ResResult.fail();
    }

    /**
     * 修改数据
     *
     * @param user 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    @ApiOperation("更新")
    public ResResult update(@RequestBody User user) {
        if (userService.updateById(user)){
            return ResResult.success();
        }
        return ResResult.fail();
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    @ApiOperation("删除")
    public ResResult delete(@RequestParam("idList") List<Long> idList) {
        if (userService.removeByIds(idList)){
            return ResResult.success();
        }

        return ResResult.fail();
    }
}