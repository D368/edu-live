package xyz8.live.controller.live;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import xyz8.live.common.result.ResResult;
import xyz8.live.entity.LiveInfo;
import xyz8.live.service.LiveInfoService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 资源表(LiveInfo)表控制层
 *
 * @author liangw
 * @since 2020-08-11 13:53:13
 */
@RestController
@RequestMapping("liveInfo")
@Api(tags = "资源表")
public class LiveInfoController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private LiveInfoService liveInfoService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param liveInfo 查询实体
     * @return 所有数据
     */
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public ResResult selectAll(Page<LiveInfo> page, LiveInfo liveInfo) {
        return ResResult.success(this.liveInfoService.page(page, new QueryWrapper<>(liveInfo)));
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
        return ResResult.success(this.liveInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param liveInfo 实体对象
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增")
    public ResResult insert(@RequestBody LiveInfo liveInfo) {
        boolean b = liveInfoService.save(liveInfo);
        if (b) {
            return ResResult.success();
        }
        return ResResult.fail();

    }

    /**
     * 修改数据
     *
     * @param liveInfo 实体对象
     * @return 修改结果
     */
    @PutMapping("/update")
    @ApiOperation("修改")
    public ResResult update(@RequestBody LiveInfo liveInfo) {
        boolean b = liveInfoService.updateById(liveInfo);
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
        boolean b = liveInfoService.removeByIds(idList);
        if (b) {
            return ResResult.success();
        }
        return ResResult.fail();
    }
}