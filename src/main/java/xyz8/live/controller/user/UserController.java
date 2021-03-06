package xyz8.live.controller.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @since 2020-08-11 14:08:48
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户信息")
public class UserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
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
    public ResResult selectAll(Page<User> page, User user) {
        return ResResult.success(this.userService.page(page, new QueryWrapper<>(user)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("ID查询")
    public ResResult selectOne(@PathVariable Serializable id) {
        return ResResult.success(this.userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增")
    public ResResult insert(@RequestBody User user) {
        boolean b = userService.save(user);
        if (b) {
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
    @PutMapping("/update")
    @ApiOperation("修改")
    public ResResult update(@RequestBody User user) {
        boolean b = userService.updateById(user);
        if (b) {
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
    @DeleteMapping("/delete")
    @ApiOperation("删除")
    public ResResult delete(@RequestParam("idList") List<Long> idList) {
        boolean b = userService.removeByIds(idList);
        if (b) {
            return ResResult.success();
        }
        return ResResult.fail();
    }
}