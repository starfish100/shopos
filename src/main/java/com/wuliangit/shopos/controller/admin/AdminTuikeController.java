package com.wuliangit.shopos.controller.admin;

import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.dto.TuikeCheckListDTO;
import com.wuliangit.shopos.dto.TuikePageListDTO;
import com.wuliangit.shopos.entity.CommissionCashLog;
import com.wuliangit.shopos.service.CommissionCashLogService;
import com.wuliangit.shopos.service.TuikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 26229 on 2017/4/27.
 */

@Controller
@RequestMapping("/admin/tuike")
public class AdminTuikeController {

    @Autowired
    private TuikeService tuikeService;
    @Autowired
    private CommissionCashLogService commissionCashLogService;

    /**
     * 获取审核列表页面
     * @return
     */
    @RequestMapping("/checkListPage")
    public String checkListPage(Model model) {
        return "admin/tuike/check_list";
    }

    /**
     * 推客提现日志列表页面
     * @param model
     * @return
     */
    @RequestMapping("/getTuikeCommissionLogPage")
    public String getTuikeCommissionLogPage(Model model){
        return "admin/tuike/commission_log_page";
    }

    /**
     * 获取推客管理列表页面
     * @return
     */
    @RequestMapping("/tuikeListPage")
    public String tuikeListPage() {
        return "admin/tuike/tuike_list";
    }

    /**
     * 获得审核列表数据
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/getCheckList")
    @ResponseBody
    public Object getCheckList(@RequestParam("draw") int draw,
                               @RequestParam(value = "searchKey", required = false) String searchKey,
                               @RequestParam(value = "orderColumn", required = false) String orderColumn,
                               @RequestParam(value = "orderType", required = false) String orderType,
                               @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<TuikeCheckListDTO> tuikeCheckListDTO = tuikeService.getCheckList(searchKey,orderColumn,orderType,page,pageSize);
        return new PageResult<TuikeCheckListDTO>(tuikeCheckListDTO,draw);
    }

    /**
     * 审核推客
     * @param memberId
     * @param state
     * @return
     */
    @RequestMapping("/checkOperation")
    @ResponseBody
    public RestResult checkOperation(Integer memberId, String state){
        RestResult result = new RestResult();
        Integer info = tuikeService.checkOperation(memberId,state);
        if(info != 1){
            result.add("code",RestResult.CODE_SERVERERROR);
            result.add("msg",RestResult.MSG_ERROR);
        }
        return result;
    }

    /**
     * 获得推客管理列表数据
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/getTuikeList")
    @ResponseBody
    public Object getTuikeList(@RequestParam("draw") int draw,
                               @RequestParam(value = "searchKey", required = false) String searchKey,
                               @RequestParam(value = "orderColumn", required = false) String orderColumn,
                               @RequestParam(value = "orderType", required = false) String orderType,
                               @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<TuikePageListDTO> tuikePageListDTOS = tuikeService.getTuikeList(searchKey,orderColumn,orderType,page,pageSize);
        return new PageResult<TuikePageListDTO>(tuikePageListDTOS,draw);
    }

    /**
     * 禁用推客
     * @param tuikeId
     * @param state
     * @return
     */
    @RequestMapping("/forbiddenTuike")
    @ResponseBody
    public RestResult forbiddenTuike(Integer tuikeId, String state){
        RestResult result = new RestResult();
        Integer info = tuikeService.forbiddenTuike(tuikeId,state);
        if(info != 1){
            result.add("code",RestResult.CODE_SERVERERROR);
            result.add("msg",RestResult.MSG_ERROR);
        }
        return result;
    }

    /**
     * 获取推客佣金提现记录
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/getCommissionLogList")
    @ResponseBody
    public PageResult getCommissionLogList(@RequestParam("draw") int draw,
                                           @RequestParam(value = "searchKey", required = false) String searchKey,
                                           @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                           @RequestParam(value = "orderType", required = false) String orderType,
                                           @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                           @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        List<CommissionCashLog> commissionCashLogs = commissionCashLogService.getCommissionLogList(searchKey,orderColumn,orderType,page,pageSize);
        return new PageResult<CommissionCashLog>(commissionCashLogs,draw);
    }

}
